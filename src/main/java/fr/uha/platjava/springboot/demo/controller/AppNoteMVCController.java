package fr.uha.platjava.springboot.demo.controller;

import java.time.LocalDateTime;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import fr.uha.platjava.springboot.demo.data.NoteDTO;
import fr.uha.platjava.springboot.demo.service.AppUserService;
import fr.uha.platjava.springboot.demo.service.NoteService;

import fr.uha.platjava.springboot.demo.data.NoteRepository;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AppNoteMVCController {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private NoteService noteService;
	
	@GetMapping("/user/register")
	public String userRegisterPage(Model model) {
		AppUserDTO dto = new AppUserDTO();
		model.addAttribute("user", dto);
		return "register";
	}
	
	@PostMapping("/user/register")
	public ModelAndView registerUser(@ModelAttribute("user") @Valid AppUserDTO dto, HttpServletRequest request, Errors errors) {
		try {
			appUserService.registerAppUser(dto);
		} catch(RuntimeException e) {
			Logger.getLogger(AppNoteMVCController.class).log(Level.INFO, "User sign up failed");
			ModelAndView mav = new ModelAndView("register", "user", dto);
			mav.addObject("message", "Error: Username already in usev");
			return mav;
		}
		return new ModelAndView("successRegister", "user", dto);
	}
	
	@GetMapping("/notes/add")
	public String addNoteForm(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = appUserService.getByName(authentication.getName());
		model.addAttribute("user", user);
		model.addAttribute("note", new NoteDTO());
		return "addNote";
	}
	
	@PostMapping("/notes/add")
	public String addNote(@ModelAttribute("note") @Valid NoteDTO dto, HttpServletRequest request, Errors errors) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = appUserService.getByName(authentication.getName());
		noteService.addNote(user, dto);
		return "redirect:/notes";
	}

	@GetMapping("/notes")
	public String userNotesPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = appUserService.getByName(authentication.getName());
        List<Note> notes = this.noteService.getNoteVisibleBy(user);
        List<AppUser> users = this.appUserService.getAllUser();
		model.addAttribute("notes", notes);
                model.addAttribute("users", users);
		return "notes";
	}

}
