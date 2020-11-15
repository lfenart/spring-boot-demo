package fr.uha.platjava.springboot.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppUser {
	
	private @Id @GeneratedValue Long id;
	private String hashed_password;
	private @Column(unique=true, nullable=false) String username;
	
	public AppUser() {
		
	}
	
	public Long getId() { return this.id; }
	
	public String getUsername() { return this.username; }
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() { return this.hashed_password; }
	public void setPassword(String pw) { this.hashed_password = pw; }
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User {\ntid:\t").append(this.getId()).append("\ntusername:\t").append(this.getUsername());
		return sb.toString();
	}
	
}
