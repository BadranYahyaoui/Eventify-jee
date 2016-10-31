package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Comment;


@Remote
public interface CommentBusinessRemote {
	
	public void AddComment(Comment comment);
	public void updateComment(Comment comment);
	public boolean DeleteComment(int ref);
	public List<Comment> getCommentsByUserId(int id);
	public Comment GetCommentByReference(int ref);

}
