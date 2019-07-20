package hello.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hello.EventNotFoundException;
import hello.model.Event;
import hello.repository.EventsRepository;

@RestController
public class EventsController {

    @Autowired
    EventsRepository eventsRepository;
   
    // list of all events
    @GetMapping("/events")
    public List<Event> fetchEvents() {
    	
        return (List<Event>) eventsRepository.findAll();
    }
    
    //get event1 by id
	@GetMapping ("/events/{id}")
   public Event searchId(@PathVariable Long id) {
	  return eventsRepository.findById(id).get();
  }
  	
	// creating a new event
   @PostMapping("/events/add")
	public Event addEvent(@RequestBody Event event) {
		eventsRepository.save(event);
		return event;
	}
	
   // update an event
   @PutMapping("/events/{id}")
   public ResponseEntity<Object> updateEvent(@RequestBody Event event,@PathVariable Long id ) {
	   Optional<Event> ev = eventsRepository.findById(id);
	   if (!ev.isPresent())
		  return ResponseEntity.notFound().build(); // pattern da cui ho chiamato metodo notFound, siccome e' vuoto lo devo buildare!!
	   event.setId(id);
	   eventsRepository.save(event);
	   return ResponseEntity.noContent().build();
	   
   }
   
    //Deleting an event
   @DeleteMapping("/events/{id}")
   public void deleteEvent( @PathVariable Long id) {
	   Optional<Event> ev = eventsRepository.findById(id);
	   if (!ev.isPresent())
		  throw new EventNotFoundException(); // pattern da cui ho chiamato metodo notFound, siccome e' vuoto lo devo buildare!!
	  	   eventsRepository.deleteById(id);
   }
}


