package demo02;

import javax.validation.constraints.AssertTrue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="timeout")
public class TimeoutParams {
	
	private long minimum = 50L;
	private long maximum = 100L;

	@AssertTrue(message = "minimum should be less than maximum")
	public boolean isValid() {
		return minimum < maximum;
	}
}
