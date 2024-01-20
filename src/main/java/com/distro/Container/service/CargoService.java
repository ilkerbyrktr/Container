package com.distro.Container.service;

import com.distro.Container.entity.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> findAll();
    List<Cargo> findbyContainerCode(String containerCode);
    Cargo findbyId(int id);
    void remove(Integer id);
    Cargo save (Cargo cargo);
}
