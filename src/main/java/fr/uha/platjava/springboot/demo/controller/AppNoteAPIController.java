package fr.uha.platjava.springboot.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.AppUserRepository;
import fr.uha.platjava.springboot.demo.data.Note;
import fr.uha.platjava.springboot.demo.service.AppUserService;
import fr.uha.platjava.springboot.demo.service.NoteService;

@RestController
public class AppNoteAPIController {

	@Autowired
	private AppUserService user_service;
	
	@Autowired
	private NoteService note_service;
	
	@GetMapping("/api/users")
	public List<AppUser> getAllUser() {
		return this.user_service.getAllUser();
	}
	
	@GetMapping("/api/notes")
	public List<Note> getNotes() {
		AppUser user = user_service.getByName("Fabien");
		return this.note_service.getNoteVisibleBy(user);
	}
}
