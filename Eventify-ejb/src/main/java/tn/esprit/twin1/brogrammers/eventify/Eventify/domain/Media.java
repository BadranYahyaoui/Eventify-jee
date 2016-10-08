package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Media
 *
 */
@Entity

public class Media implements Serializable {

	   
	@Id
	private int id;
	private String typeMedia;
	private int pathMedia;
	private Date mediaDate;
	private static final long serialVersionUID = 1L;

	public Media() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTypeMedia() {
		return this.typeMedia;
	}

	public void setTypeMedia(String typeMedia) {
		this.typeMedia = typeMedia;
	}   
	public int getPathMedia() {
		return this.pathMedia;
	}

	public void setPathMedia(int pathMedia) {
		this.pathMedia = pathMedia;
	}   
	public Date getMediaDate() {
		return this.mediaDate;
	}

	public void setMediaDate(Date mediaDate) {
		this.mediaDate = mediaDate;
	}
   
}
