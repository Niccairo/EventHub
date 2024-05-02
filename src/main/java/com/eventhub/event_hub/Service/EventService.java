package com.eventhub.event_hub.Service;

import com.eventhub.event_hub.entity.Event;
import com.eventhub.event_hub.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired private EventRepository eventRepository;

    public Event createEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    public Optional<Event> getEvent(Long id){
        return eventRepository.findById(id);
    }

    public Optional<Event> updateEvent(Long id,Event event){
        Optional<Event> eventOpt = eventRepository.findById(id);
        if (eventOpt.isPresent()){
           eventOpt.get().setName(event.getName());
            eventOpt.get().setDescription(event.getDescription());
            eventOpt.get().setPriceTicket(event.getPriceTicket());
            eventOpt.get().setEmail(event.getEmail());
            eventOpt.get().setMaxNumberOfPartecipants(event.getMaxNumberOfPartecipants());
            eventOpt.get().setDate(event.getDate());
            eventOpt.get().setStartingTime(event.getStartingTime());
            eventOpt.get().setEndTime(event.getEndTime());
            eventRepository.save(eventOpt.get());
        }
        return eventOpt;
    }

    public Optional<Event> deleteEvent(Long id){
        Optional<Event> eventOpt = eventRepository.findById(id);
        if(eventOpt.isPresent()){
            eventRepository.deleteById(id);
        }
        return eventOpt;
    }

    public void deleteAllEvents(){
        eventRepository.deleteAll();
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll()  ;
    }

}
