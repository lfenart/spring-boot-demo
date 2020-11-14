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
import fr.uha.platjava.springboot.demo.service.AppUserService;

@Controller
public class AppNoteMVCController {

	@Autowired
	private AppUserService appUserService;
	
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
}
