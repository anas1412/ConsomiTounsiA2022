package tn.esprit.Services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import tn.esprit.Entities.Reclamation;
import tn.esprit.Repository.ReclamationRepository;
import tn.esprit.Repository.UserRepository;
import tn.esprit.Entities.User;
import tn.esprit.Entities.Livraison;
import tn.esprit.Repository.LivraisonRepository;
@Service
public class ReclamationServiceImp implements IReclamationService{
	@Autowired
	ReclamationRepository ReclamationRepo;
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	LivraisonRepository LivraisonRepo;
	
	@Autowired
	//private JavaMailSender javaMailSender;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		// TODO Auto-generated method stub
		return (List<Reclamation>) ReclamationRepo.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation rec,Long idUser,Long idLivraison) {
		// TODO Auto-generated method stub
		User u = UserRepo.findById(idUser).orElse(null);
		Livraison livraison = LivraisonRepo.findById(idLivraison).orElse(null);
		rec.setUser(u);
		rec.setLivraison(livraison);
		rec.setDateRec(new Date());
		ReclamationRepo.save(rec);
		return rec;
	}

	@Override
	public Reclamation updateReclamation(Reclamation rec) {
		// TODO Auto-generated method stub
		Reclamation reclamation = ReclamationRepo.findById(rec.getIdReclamation()).get();
	rec.setType(rec.getType());
	rec.setDescription(rec.getDescription());
	rec.setLivraison(rec.getLivraison());
	rec.setUser(rec.getUser());
	rec.setDateRec(new Date());
	rec.setIdReclamation(rec.getIdReclamation());
		ReclamationRepo.save(rec);
		return rec;
	}

	@Override
	public Reclamation retrieveReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		return ReclamationRepo.findById(idReclamation).orElse(null);
	}

	@Override
	public void removeReclamation(Long idReclamation) {
		// TODO Auto-generated method stub
		ReclamationRepo.deleteById(idReclamation);
}
	@Override
	public void assignReclamationToUser(Long id,Long idReclamation) {
		User u =UserRepo.findById(id).orElse(null);
		Reclamation rec = ReclamationRepo.findById(idReclamation).orElse(null);
		rec.setUser(u);
        ReclamationRepo.save(rec);
	}
	
	@Override
	public void assignReclamationToLivraison(Long idLivraison,Long idReclamation) {
		Livraison liv = LivraisonRepo.findById(idLivraison).orElse(null);
		Reclamation rec = ReclamationRepo.findById(idReclamation).orElse(null);
		rec.setLivraison(liv);
		ReclamationRepo.save(rec);
	}


	
	public void traiterReclamation1() {
	
		SimpleMailMessage msg1 = new SimpleMailMessage();
	
		
	            	msg1.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg1.setSubject("Traitement de r??clamation");
	                msg1.setText("Madame, ou Monsieur, (?? pr??ciser)\r\n"
	                		+ "\r\n"
	                		+ "Nous avons bien re??u votre r??clamtion relatif aux articles d??fectueux.\r\n"
	                		+ "\r\n"
	                		+ "Nous vous proposons de remplacer les articles d??fectueux. Cependant, ceux-ci devront nous ??tre retourn??s dans leur emballage d???origine.\r\n"
	                		+ "\r\n"
	                		+ "Nous vous prions de nous excuser de cet incident.\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                //javaMailSender.send(msg1);
	                
	             	
	}
	

	public void traiterReclamation2() {
	
		SimpleMailMessage msg2 = new SimpleMailMessage();
	
		
	            	msg2.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg2.setSubject("Traitement de r??clamation");
	                msg2.setText("Madame, ou Monsieur, (?? pr??ciser)\r\n"
	                		+ "\r\n"
	                		+ "Comme vous l???avez demand??, nous avons trait?? votre remboursement, et il devrait appara??tre sur votre compte bancaire dans les 3 jours ouvrables suivants.\r\n"
	                		+ "Nous sommes tristes de vous voir partir, mais nous esp??rons travailler ensemble dans le futur o?? notre produit sera utile pour vous.\r\n"
	                		+ "Si vous ??tes toujours ?? la recherche d???autres options, n???h??sitez pas ?? me le faire savoir, car je serai en mesure de vous aider ?? choisir d???autres options qui pourraient vous convenir.\r\n"
	                		+ "Veuillez rester en contact. Passez une excellente journ??e.\r\n"
	                		+ "\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                //javaMailSender.send(msg2);
	                
	             	
	}
	
	public void traiterReclamation3() {
		
		SimpleMailMessage msg3 = new SimpleMailMessage();
	
		
	            	msg3.setTo("nourmrad171199@gmail.com","gg0101162@gmail.com");
	      
	          
	                msg3.setSubject("Traitement de r??clamation");
	                msg3.setText("Madame, ou Monsieur, (?? pr??ciser)\r\n"
	                		+ "\r\n"
	                		+ "Veuillez m???excuser pour ce probl??me et le d??sagr??ment qu???il vous a caus??.\r\n"
	                		+ "En guise de d??dommagement, je vous ai rembours?? vos frais d???abonnement pour le mois en cours.\r\n"
	                		+ "Nous avons identifi?? l???origine du probl??me : il semble que celui-ci soit d?? ?? [explication]. Nous mettons tout en ??uvre pour le r??soudre au plus vite.\r\n"
	                		+ "Tout devrait ainsi rentrer dans l???ordre d???ici [heure pr??vue]. Une fois l???acc??s r??tabli, je vous recontacterai pour vous en informer.\r\n"
	                		+ "Nous vous prions de nous excuser de cet incident.\r\n"
	                		+ "\r\n"
	                		+ "Cordialement,  ");

	                //javaMailSender.send(msg3);
	                
	             	
	}


}