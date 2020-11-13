package fr.uha.platjava.springboot.demo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppNoteMVCController {

	@GetMapping("/user/register")
	public String userRegisterPage(Model model) {
		model.addAttribute("datetime", LocalDateTime.now().toString());
		return "register";
	}
}
