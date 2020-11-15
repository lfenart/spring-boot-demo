package fr.uha.platjava.springboot.demo.data;

import javax.validation.constraints.NotNull;

public class ShareDTO {
	@NotNull
	private Long noteId;
	
	@NotNull
	private Long sharedUserId;
	
	public Long getNoteId() { return this.noteId; }
	public void setNoteId(Long id) { this.noteId = id; }
	
	public Long getSharedUserId() { return this.sharedUserId; }
	public void setSharedUserId(Long id) { this.sharedUserId = id; }
}
