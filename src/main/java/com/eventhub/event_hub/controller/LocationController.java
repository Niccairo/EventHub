package com.eventhub.event_hub.controller;

import com.eventhub.event_hub.Service.LocationService;
import com.eventhub.event_hub.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/")
    public Location createLocation(@RequestBody Location newLocation){
        return locationService.createLocation(newLocation);
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable Long id){
        return locationService.getLocation(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable Long id, @RequestBody Location location){
        Optional<Location> locationOpt = locationService.updateLocation(id,location);
        if (locationOpt.isPresent()){
            return ResponseEntity.ok("Location aggiornata!");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id){
        Optional<Location> locationOpt = locationService.deleteLocation(id);
        if (locationOpt.isPresent()){
            return ResponseEntity.ok("Location Eliminata");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllLocations(){
        locationService.deleteAllLocations();
        return ResponseEntity.ok("All locations have been deleted");
    }

    @GetMapping("/all")
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

}