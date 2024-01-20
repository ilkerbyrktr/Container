package com.distro.Container.service;

import com.distro.Container.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location findbyId (int locId);
}
