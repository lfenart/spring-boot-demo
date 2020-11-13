package fr.uha.platjava.springboot.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.uha.platjava.springboot.demo.data.AppUser;
import fr.uha.platjava.springboot.demo.data.AppUserRepository;

@Service
public class CustomAppUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = aur.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		UserDetails ud = User.withUsername(user.getUsername()).password(user.getPassword()).build();
		return ud;
	}
	
	private AppUserRepository aur;

}
