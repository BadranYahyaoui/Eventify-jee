package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Comment;


@Local
public interface CommentBusinessLocal {
	
	public void AddComment(Comment comment);
	
	public void updateComment(Comment comment);
	
	public boolean DeleteComment(int ref);
	
	public List<Comment> getCommentsByUserId(int id);
	
	public Comment GetCommentByReference(int ref);
	
}
