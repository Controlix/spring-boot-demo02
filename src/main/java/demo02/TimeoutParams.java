package demo02;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="timeout")
public class TimeoutParams {
	
	private long minimum = 50L;
	private long maximum = 100L;

}
