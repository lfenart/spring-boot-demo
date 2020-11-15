package fr.uha.platjava.springboot.demo.data;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public class NoteRepositoryCustomImpl implements NoteRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Note> findNoteVisibleBy(AppUser user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Note> query = cb.createQuery(Note.class);

		Root<Note> root_note = query.from(Note.class);

        query.select(root_note);
        List<Note> notes = em.createQuery(query).getResultList();
        for(int i=0; i<notes.size(); i++) {
        	if(!(notes.get(i).getOwner().equals(user) || notes.get(i).getSharedUser().contains(user))) {
        		notes.remove(i);
        	}
        }
        return notes;
	}

}
