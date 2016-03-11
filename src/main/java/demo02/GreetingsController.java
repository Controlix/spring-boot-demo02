package demo02;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.spectator.api.DistributionSummary;
import com.netflix.spectator.api.Registry;
import com.netflix.spectator.api.Timer;

@SpringBootApplication
@RestController
public class GreetingsController {

	@Autowired
	private QuoteRepo quotes;
	
	@Autowired
	private Registry registry;

	private DistributionSummary distributionSummary;

	private Timer timer;
	
	@PostConstruct
    public void init() {
		distributionSummary = registry.distributionSummary("messageSize");
		timer = registry.timer("messageTime");
	}

	@RequestMapping("/greetings")
    public String index() throws Exception {
        String quote = timer.record(() -> chooseQuote());
    	distributionSummary.record(quote.length());
    	
		return quote;
    }

	private String chooseQuote() throws InterruptedException {
    	TimeUnit.MILLISECONDS.sleep(RandomUtils.nextLong(50L, 500L));
		return quotes.chooseOne();
	}

    @Bean
    public AlwaysSampler defaultSampler() {
      return new AlwaysSampler();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GreetingsController.class, args);
    }
}
