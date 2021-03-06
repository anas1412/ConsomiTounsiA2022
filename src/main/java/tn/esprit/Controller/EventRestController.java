package tn.esprit.Controller;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.media.MediaType;
import tn.esprit.QRcodeGenerator;
import tn.esprit.Entities.Event;
//import tn.esprit.Entities.Reservation;
import tn.esprit.Repository.EventRepository;
import tn.esprit.Services.IEventService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/event")
public class EventRestController {
	
	@Autowired
	IEventService eventInterface;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("event", eventInterface.retrieveAllEvents());
		return "event/index";
	}
	
	
	
	@GetMapping("/getAllEvent")
	@ResponseBody
	public List<Event> getAll() {
	List<Event> listevent = eventInterface.retrieveAllEvents();
	return listevent;
	}
	
	
	
	
	

	@GetMapping("/getAllEventActive")
	@ResponseBody
	public Collection<Event> getActive() {
		Collection<Event> listevent = eventInterface.retrieveAllEventsActive();
	return listevent;
	}
	
	@GetMapping("/getEventByCagnotte")
	@ResponseBody
	public Collection<Event> getEventByCagnotte() {
		Collection<Event> listevent = eventInterface.findEventByCagnotte();
	return listevent;
	}
	
	@GetMapping("/getEvent/{id}")
	@ResponseBody
	public Event retrieveEvent(@PathVariable("id") Long idEvent) {
	return eventInterface.retrieveEvent(idEvent);
	}
	
	@PostMapping("/add-getEvent")
	@ResponseBody
	public Event addEvent(@RequestBody Event e )
	{
		Event event = eventInterface.addEvent(e);
	return event;
	}
	
	@PostMapping("/add-getEvent/{cagnotte-id}")
	@ResponseBody
	public Event addEventCagnotte(@RequestBody Event e,@PathVariable("cagnotte-id") Long idCagnotte)
	{
	
		Event event = eventInterface.addCagnotteToEvent(e, idCagnotte);
	return event;
	}
	
	
	
	
	@DeleteMapping("/remove-event/{idEvent-id}")
	@ResponseBody
	public void removeEvent(@PathVariable("idEvent-id") Long idEvent) {
		eventInterface.removeEventt(idEvent);
	}
	
	@PutMapping("/modify-event")
	@ResponseBody
	public Event updateEvent(@RequestBody Event e) {
	return eventInterface.updateEvent(e);
	}
	
	
	@PutMapping("/updateEtat")
	@ResponseBody
	public void updateEtat() {
		eventInterface.updateEtat();
		
	}
	
/*	
	@PostMapping("/FaireReservation/{idReservation}/{idUser}/{idEvent}")
	public void FaireReservation(@PathVariable("idReservation")Long idreservation,@PathVariable("idUser") Long idUser,
	@PathVariable("idEvent") Long idEvent) {
		eventInterface.FaireReservation(idreservation,idUser, idEvent);
	}
	*/
	
	@GetMapping("/getNbParticipant/{id}")
	@ResponseBody

	public int NombreParticpEvent(@PathVariable("id") int idEvent) {
		
		return eventInterface.getNombreParticpEvent(idEvent);
	}
	
	@GetMapping("/getNbPlace/{id}")
	@ResponseBody

	public int NombrePlace(@PathVariable("id") int idEvent) {
		
		return eventInterface.getNombrePlacesEvent(idEvent);
	}
	
	@PostMapping("/add-getEvent-user/{cagnotte-id}/{user-id}")
	@ResponseBody
	public Event addEventUser(@RequestBody Event e,@PathVariable("cagnotte-id")Long idCagnotte,@PathVariable("user-id")Long idUser) {
		
		Event event = eventInterface.addEvent(e, idCagnotte, idUser);
		return event;
	}
	
}
