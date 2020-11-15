package fr.uha.platjava.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.AppUserDTO;
import fr.uha.platjava.springboot.demo.data.AppUserRepository;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public AppUser registerAppUser(AppUserDTO dto) {
		if(repository.findByUsername(dto.getUsername()).isPresent()) {
			throw new RuntimeException("Username already used");
		}
		
		AppUser user = new AppUser();
		user.setUsername(dto.getUsername());
		user.setPassword(encoder.encode(dto.getPassword()));
		
		return repository.save(user);
	}
	
	public AppUser getByName(String username) {
		return this.repository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	public List<AppUser> getAllUser() {
		return this.repository.findAll();
	}
	
	public List<String> getAllUsername() {
		return this.repository.getAllUsername();
	}
}
