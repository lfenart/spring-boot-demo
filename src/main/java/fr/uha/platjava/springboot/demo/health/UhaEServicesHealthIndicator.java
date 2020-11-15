package fr.uha.platjava.springboot.demo.health;

import org.springframework.stereotype.Component;

@Component
public class UhaEServicesHealthIndicator extends HttpHealthIndicator {

	private static final String URL = "https://e-services.uha.fr/";

	public UhaEServicesHealthIndicator() {
		super(URL);
	}

}
