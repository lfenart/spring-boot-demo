package fr.uha.platjava.springboot.demo.health;

import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class UhaHealthIndicator implements HealthIndicator {

	private static final String URL = "https://e-services.uha.fr";

	@Override
	public Health health() {
		try (Socket socket = new Socket(new java.net.URL(URL).getHost(), 80)) {
		} catch (Exception e) {
			System.out.println("Failed to connect to: " + URL);
			return Health.down().withDetail("error", e.getMessage()).build();
		}
		return Health.up().build();
	}

}
