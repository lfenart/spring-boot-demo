package fr.uha.platjava.springboot.demo;

import java.util.Collection;

public interface NoteRepositoryCustom {
	public Collection<Note> findNoteVisibleBy(User user);
}
