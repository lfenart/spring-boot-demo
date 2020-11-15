package fr.uha.platjava.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.Note;
import fr.uha.platjava.springboot.demo.data.NoteDTO;
import fr.uha.platjava.springboot.demo.data.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository repository;
	
	public Note addNote(AppUser owner, NoteDTO dto) {
		Note note = new Note(owner);
		note.setTitle(dto.getTitle());
		note.setContent(dto.getContent());
		
		return this.repository.save(note);
	}
	
	public List<Note> getNoteVisibleBy(AppUser user) {
		return this.repository.findNoteVisibleBy(user);
	}
	
	public List<Note> getAllNotes() {
		return this.repository.findAll();
	}
	
	public Note addSharedUser(AppUser user, Note note) {
		note.addSharedUser(user);
		return this.repository.save(note);
	}
}
