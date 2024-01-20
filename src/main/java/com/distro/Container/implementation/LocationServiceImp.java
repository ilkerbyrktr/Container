package com.distro.Container.implementation;

import com.distro.Container.dao.LocationRepository;
import com.distro.Container.entity.Location;
import com.distro.Container.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    private LocationRepository locationRepository;

    public LocationServiceImp(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll(){return locationRepository.findAll();}
    public Location findbyId(int locId){
        Optional<Location> byId=locationRepository.findById(locId);
        Location location = byId.get();
        return location;
    }
}