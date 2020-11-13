package fr.uha.platjava.springboot.demo;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Note {

	public Note() {
		this.creation_date = LocalDateTime.now();
	}
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() { return this.content; }
	public void SetContent(String content) {
		this.content = content;
	}
	
	public LocalDateTime getCreationDate() {
		return this.creation_date;
	}
	
	private @Id @GeneratedValue Long id;
	private @ManyToOne User owner;
	private @ManyToMany Set<User> shared_user;
	private String title;
	private String content;
	private LocalDateTime creation_date;
}
