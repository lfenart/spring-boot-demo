package fr.uha.platjava.springboot.demo.data;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class NoteRepositoryCustomImpl implements NoteRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<Note> findNoteVisibleBy(AppUser user) {
	/*	CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Note> query = cb.createQuery(Note.class);
		Root<Note> root_note = query.from(Note.class);
		
        query.select(root_note).where(cb.or(cb.equal(root_note.get("owner"), user), cb.in(root_note.get("shared_user"))));
		
        return em.createQuery(query).getResultList();*/
		return null;
	}

}
