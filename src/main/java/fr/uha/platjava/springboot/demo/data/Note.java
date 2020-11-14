package fr.uha.platjava.springboot.demo.data;

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

	public Note(AppUser owner) {
		this.creation_date = LocalDateTime.now();
		this.owner = owner;
	}
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() { return this.content; }
	public void setContent(String content) {
		this.content = content;
	}
	
    public AppUser getOwner() { return this.owner; }
	public void setOwner(AppUser owner) {
		this.owner = owner;
	}
	
    public Set<AppUser> getSharedUser() { return this.sharedUser; }
	public void addSharedUser(AppUser user) {
		this.sharedUser.add(user);
	}

	public LocalDateTime getCreationDate() {
		return this.creation_date;
	}
	
	private @Id @GeneratedValue Long id;
	private @ManyToOne AppUser owner;
	private @ManyToMany Set<AppUser> sharedUser;
	private String title;
	private String content;
	private LocalDateTime creation_date;


}
