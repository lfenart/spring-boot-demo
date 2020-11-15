package fr.uha.platjava.springboot.demo.health;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public abstract class HttpHealthIndicator implements HealthIndicator {

	private final String URL;

	public HttpHealthIndicator(String url) {
		this.URL = url;
	}

	@Override
	public Health health() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(this.URL).openConnection();
			int status = connection.getResponseCode();
			if (status >= 400 && status < 600) {
				return Health.down().withDetail("httpStatus", status).build();
			}
			return Health.up().withDetail("httpStatus", status).build();
		} catch (Exception e) {
			System.out.println("Failed to connect to: " + URL);
			return Health.down().withDetail("error", e.getMessage()).build();
		}
	}
}
