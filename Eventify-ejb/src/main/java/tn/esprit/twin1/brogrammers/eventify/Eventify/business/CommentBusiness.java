package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CommentBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CommentBusinessRemote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Comment;


/**
 * Session Bean implementation class CommentBusiness
 */
@Stateless
@LocalBean
public class CommentBusiness implements CommentBusinessRemote, CommentBusinessLocal {

    /**
     * Default constructor. 
     */
	
	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	
    public CommentBusiness() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void AddComment(Comment comment) {
		
		entityManager.persist(comment);
		
	}


	@Override
	public boolean DeleteComment(int idUser, int idEvent) {
		
		if(GetCommentByUserIdAndEventId(idUser, idEvent)!=null)
		{
			entityManager.remove(entityManager.merge(GetCommentByUserIdAndEventId(idUser, idEvent)));;
			return true;
		}
		else 
		return false;
	}


	@Override
	public void updateComment(Comment comment) {
		entityManager.merge(comment);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentsByEvent(int id) {
		try {
			Query query = entityManager.
					createQuery("SELECT new Comment(c.contain,c.commentPK) FROM Comment c "
							+ "WHERE c.commentPK.idEvent=:param")
					.setParameter("param", id);
			System.out.println("comment finded by event");
			 return query.getResultList();

		} catch (Exception e) {
			System.err.println("Cant Find comment of event");
			return new ArrayList<Comment>();
		}
	
	}


	@Override
	public Comment GetCommentByUserIdAndEventId(int idUser, int idEvent) {
		try {
			Query query = entityManager.
					createQuery("SELECT new Comment(c.contain,c.commentPK) FROM Comment c"
							+ " WHERE (c.commentPK.idUser=:userId AND c.commentPK.idEvent=:eventId) ")
			.setParameter("userId", idUser)
			.setParameter("eventId", idEvent);
			System.out.println("Comment finded by event and user ");
			 return (Comment) query.getSingleResult();
			 

		} catch (Exception e) {
			System.err.println("Cant Find Comment  event and user : "+e);
			return null; } 
		
	}



}
