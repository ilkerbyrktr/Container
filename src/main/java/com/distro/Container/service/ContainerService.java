package com.distro.Container.service;

import com.distro.Container.entity.Container;

import java.util.List;

public interface ContainerService {
    List<Container> findAll();
    Container findbyId(int id);
    Container save(Container container);
    void remove(Integer id);
}
