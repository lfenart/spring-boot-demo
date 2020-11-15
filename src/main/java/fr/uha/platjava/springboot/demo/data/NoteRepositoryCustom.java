package fr.uha.platjava.springboot.demo.data;

import java.util.Collection;
import java.util.List;

public interface NoteRepositoryCustom {
	public List<Note> findNoteVisibleBy(AppUser user);
}
