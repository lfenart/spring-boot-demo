package fr.uha.platjava.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uha.platjava.springboot.demo.data.Note;
import fr.uha.platjava.springboot.demo.data.NoteDTO;
import fr.uha.platjava.springboot.demo.data.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository repository;
	
	public Note addNote(NoteDTO dto) {
		Note note = new Note();
		note.setTitle(dto.getTitle());
		note.setContent(dto.getContent());
		
		return this.repository.save(note);
	}
	
	public List<Note> getAllNotes() {
		return this.repository.findAll();
	}
}
