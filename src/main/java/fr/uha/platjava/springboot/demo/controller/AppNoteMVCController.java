package fr.uha.platjava.springboot.demo.controller;

import java.time.LocalDateTime;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.istack.logging.Logger;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.AppUserDTO;
import fr.uha.platjava.springboot.demo.data.Note;
import fr.uha.platjava.springboot.demo.data.NoteRepository;
import fr.uha.platjava.springboot.demo.service.AppUserService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppNoteMVCController {

	@Autowired
	private AppUserService appUserService;
	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping("/user/register")
	public String userRegisterPage(Model model) {
		AppUserDTO dto = new AppUserDTO();
		model.addAttribute("user", dto);
		return "register";
	}
	
	@PostMapping("/user/register")
	public ModelAndView registerUser(@ModelAttribute("user") @Valid AppUserDTO dto, HttpServletRequest request, Errors errors) {
		try {
			AppUser user = appUserService.registerAppUser(dto);
		} catch(RuntimeException e) {
			Logger.getLogger(AppNoteMVCController.class).log(Level.INFO, "User sign up failed");
			ModelAndView mav = new ModelAndView("register", "user", dto);
			mav.addObject("message", "Error: Username already in use");
			return mav;
		}
		return new ModelAndView("successRegister", "user", dto);
	}

	@GetMapping("/user/notes")
	public String userNotesPage(Model model) {
		Note note1 = new Note();
		Note note2 = new Note();
		Note note3 = new Note();
		AppUser user1= new AppUser();
		AppUser user2= new AppUser();
		AppUser user3= new AppUser();
		user1.setUsername("Roger");
		user2.setUsername("Bertrand");
		user3.setUsername("Gerard");
		note1.setTitle("note1");
		note2.setTitle("note2");
		note3.setTitle("note3");
		note1.setOwner(user1);
		note2.setOwner(user2);
		note3.setOwner(user1);
		note1.setContent("Ceci est la note 1");
		note2.setContent("Ceci est la note 2");		
		note3.setContent("Ceci est la note 3");
		List<Note> notes = new ArrayList<Note>();
                notes.add(note1);
                notes.add(note2);
                notes.add(note3);
		model.addAttribute("notes", notes);
		return "notes";
	}
}
