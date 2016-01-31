package demo02;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingsController {

	@Autowired
	private QuoteRepo quotes;
	
    @RequestMapping("/greetings")
    public String index() throws InterruptedException {
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
