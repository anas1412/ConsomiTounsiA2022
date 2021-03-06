package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.esprit.Entities.Commentaire;
import tn.esprit.Entities.Publication;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
		
  	List<Commentaire> findByPublication(Publication publication);

}
