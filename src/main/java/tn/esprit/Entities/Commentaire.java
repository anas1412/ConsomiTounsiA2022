package tn.esprit.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCommentaire;
	@NonNull
	private String content;
	
	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@ManyToOne
	private Publication publication;
	
	@ManyToOne
	private User user;
	
	
	
	
	
}
