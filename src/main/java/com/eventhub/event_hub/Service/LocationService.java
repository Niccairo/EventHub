package com.eventhub.event_hub.Service;

import com.eventhub.event_hub.entity.Location;
import com.eventhub.event_hub.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired private LocationRepository locationRepository;

    public Location createLocation(Location newLocation){
        return locationRepository.save(newLocation);
    }

    public Optional<Location> getLocation(Long id){
        return locationRepository.findById(id);
    }

    public Optional<Location> updateLocation(Long id, Location location){
        Optional<Location> locationOpt = locationRepository.findById(id);
        if(locationOpt.isPresent()){
            locationOpt.get().setName(location.getName());
            locationRepository.save(locationOpt.get());
        }
        return  locationOpt;
    }

    public  Optional<Location> deleteLocation(Long id){
        Optional<Location> locationOpt = locationRepository.findById(id);
        if(locationOpt.isPresent()){
            locationRepository.deleteById(id);
        }
        return locationOpt;
    }

    public void deleteAllLocations(){
        locationRepository.deleteAll();
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

}