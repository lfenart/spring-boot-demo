package fr.uha.platjava.springboot.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppUser {
	
	public AppUser() {
		
	}
	
	public Long getId() { return this.id; }
	
	public String getUsername() { return this.username; }
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() { return this.hashed_password; }
	public void setPassword(String pw) { this.hashed_password = pw; }
	
	private @Id @GeneratedValue Long id;
	private String hashed_password;
	private @Column(unique=true, nullable=false) String username;
	
}
