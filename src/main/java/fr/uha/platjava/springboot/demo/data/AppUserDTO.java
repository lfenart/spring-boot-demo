package fr.uha.platjava.springboot.demo.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fr.uha.platjava.springboot.demo.validator.PasswordMatches;

@PasswordMatches
public class AppUserDTO {

	@NotNull
	@NotEmpty
	public String username;
	
	@NotNull
	@NotEmpty
	public String password;
	
	@NotNull
	@NotEmpty
	public String passwordMatch;
	
	public String getUsername() { return this.username; }
	public void setUsername(String name) { this.username = name; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String pw) { this.password = pw; }
	
	public String getPasswordMatch() { return this.passwordMatch; }
	public void setPasswordMatch(String pwm) { this.passwordMatch = pwm; }
	
	
	
}
