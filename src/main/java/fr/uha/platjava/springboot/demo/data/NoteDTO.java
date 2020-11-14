package fr.uha.platjava.springboot.demo.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NoteDTO {
	
	@NotNull
	@NotEmpty
	private String title;
	
	@NotNull
	private String content;
	
	public String getTitle() { return this.title; }
	public void setTitle(String t) { this.title = t; }
	
	public String getContent() { return this.content; }
	public void setContent(String content) { this.content = content; }
}
