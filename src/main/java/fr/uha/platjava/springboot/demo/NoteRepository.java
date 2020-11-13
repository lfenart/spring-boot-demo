package fr.uha.platjava.springboot.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long>, NoteRepositoryCustom {
	
}
