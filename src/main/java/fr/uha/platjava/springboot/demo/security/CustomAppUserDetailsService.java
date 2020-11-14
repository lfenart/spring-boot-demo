package fr.uha.platjava.springboot.demo.security;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sun.istack.logging.Logger;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.AppUserRepository;

@Service
public class CustomAppUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Logger.getLogger(this.getClass()).log(Level.INFO, "Retriving user details from " + username);
		AppUser user = aur.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		Logger.getLogger(this.getClass()).log(Level.INFO, "Retriving user details from " + user.toString());
		UserDetails ud = User.withUsername(user.getUsername()).password(user.getPassword()).roles("USER").build();
		return ud;
	}
	
	@Autowired
	private AppUserRepository aur;

}
