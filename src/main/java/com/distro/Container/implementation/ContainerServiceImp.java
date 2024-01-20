package com.distro.Container.implementation;

import com.distro.Container.dao.ContainerRepository;
import com.distro.Container.entity.Container;
import com.distro.Container.service.ContainerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerServiceImp implements ContainerService {
    private ContainerRepository containerRepository;

    public ContainerServiceImp(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }
    @Override
    public List<Container> findAll(){
        return containerRepository.findAll();
    }
    public Container findbyId(int id){
        Optional<Container> byId=containerRepository.findById(id);
        Container container = byId.get();
        return container;
    }
    @Override
    public Container save(Container container){return containerRepository.save(container);}
    @Override
    public void remove(Integer id){containerRepository.deleteById(id);}
}