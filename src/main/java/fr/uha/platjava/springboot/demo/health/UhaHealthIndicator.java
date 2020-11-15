package fr.uha.platjava.springboot.demo.health;

import org.springframework.stereotype.Component;

@Component
public class UhaHealthIndicator extends HttpHealthIndicator {

	private static final String URL = "http://www.uha.fr";

	public UhaHealthIndicator() {
		super(URL);
	}

}
