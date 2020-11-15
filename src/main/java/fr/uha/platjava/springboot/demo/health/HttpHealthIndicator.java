package fr.uha.platjava.springboot.demo.health;

import java.io.IOException;
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
			int status = this.httpStatus();
			if (status >= 400 && status < 600) {
				return Health.down().withDetail("httpStatus", status).build();
			}
			return Health.up().withDetail("httpStatus", status).build();
		} catch (IOException e) {
			System.out.println("Failed to connect to: " + URL);
			return Health.down().withDetail("error", e.getMessage()).build();
		}
	}

	private int httpStatus() throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(this.URL).openConnection();
		return connection.getResponseCode();
	}
}
