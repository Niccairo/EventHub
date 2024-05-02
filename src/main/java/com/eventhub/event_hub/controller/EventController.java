package com.eventhub.event_hub.controller;

import com.eventhub.event_hub.Service.EventService;
import com.eventhub.event_hub.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired  private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping("/")
    public Event createEvent(@RequestBody Event newEvent){
        return eventService.createEvent(newEvent);
    }

    @GetMapping("/{id}")
    public Optional<Event> getEvent(@PathVariable Long id){
        return eventService.getEvent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable Long id,@RequestBody Event updatedEvent){
        Optional<Event> eventOpt = eventService.updateEvent(id ,updatedEvent) ;
        if(eventOpt.isPresent()){
            return ResponseEntity.ok("Evento aggiornato!");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        Optional<Event> eventOpt = eventService.deleteEvent(id);
        if (eventOpt.isPresent()){
            return ResponseEntity.ok("Evento eliminato");
        }else{
            return ResponseEntity.badRequest().body("Evento non trovato!");
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllEvents(@PathVariable String string){
        eventService.deleteAllEvents();
        return ResponseEntity.ok("Tutti gli eventi sono stati cancellati");
    }
    @GetMapping("/")

    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

}