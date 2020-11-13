package fr.uha.platjava.springboot.demo.data;

import java.util.Collection;

public interface NoteRepositoryCustom {
	public Collection<Note> findNoteVisibleBy(AppUser user);
}
