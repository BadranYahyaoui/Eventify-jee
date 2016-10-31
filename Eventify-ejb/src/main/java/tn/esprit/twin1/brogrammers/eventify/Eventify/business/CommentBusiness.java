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
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Answer;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Comment;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;

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
		try {
	        entityManager.persist(comment);

		} catch (Exception e) {
			System.err.println("Failed to Add");
		}
		
	}

	@Override
	public void updateComment(Comment comment) {
		try {
	        entityManager.merge(comment);

		} catch (Exception e) {
			System.err.println("Failed to Modify");
		}
		
	}

	@Override
	public boolean DeleteComment(int ref) {
		try{
			entityManager.remove(entityManager.find(Comment.class, ref));
			return true;
		}catch(Exception e)
		{
			System.err.println("Cant Find comment");
			return false;
		}
		
	}

	@Override
	public List<Comment> getCommentsByUserId(int id) {
		try {
			Query query = entityManager.
					createQuery("SELECT new Comment(c.Reference,c.Contain,c.CommentPK) FROM Comment c WHERE c.CommentPK.idUser=:param")
					.setParameter("param", id);
			 return (List<Comment>) query.getResultList();

		} catch (Exception e) {
			System.err.println("Cant Find Answer");
			return new ArrayList<Comment>();
		}
	}

	@Override
	public Comment GetCommentByReference(int ref) {
		Query query = entityManager.createQuery(
				"SELECT new Comment(c.Reference,c.Contain,c.CommentPK) "
						+ "FROM Comment c WHERE c.Reference=:refComment");

		Comment comment = (Comment) query.setParameter("refComment", ref).getSingleResult();
		// r.setUser(userbusiness.findUserById(r.getUser().getId()));
		return comment;
	}

}
