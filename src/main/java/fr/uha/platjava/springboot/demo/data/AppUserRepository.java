package fr.uha.platjava.springboot.demo.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public Optional<AppUser> findByUsername(String username);
	
	@Query("SELECT user.username FROM AppUser user")
	public List<String> getAllUsername();
}