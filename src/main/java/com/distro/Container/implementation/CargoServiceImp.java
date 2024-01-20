package com.distro.Container.implementation;

import com.distro.Container.dao.CargoRepository;
import com.distro.Container.entity.Cargo;
import com.distro.Container.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImp implements CargoService {
    private CargoRepository cargoRepository;

    public CargoServiceImp(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<Cargo> findAll(){return cargoRepository.findAll();}

    @Override
    public Cargo findbyId(int id){
        Optional<Cargo> byId = cargoRepository.findById(id);
        Cargo cargo = byId.get();
        return cargo;
    }

    @Override
    public List<Cargo> findbyContainerCode(String containerCode){
        List<Cargo> cargoList = cargoRepository.findByContainerCode(containerCode);
        return cargoList;
    }
    @Override
    public void remove (Integer id){
        cargoRepository.deleteById(id);
    }

    @Override
    public Cargo save(Cargo cargo){
        return cargoRepository.save(cargo);
    }

}