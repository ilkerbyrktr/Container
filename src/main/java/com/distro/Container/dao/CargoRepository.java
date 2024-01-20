package com.distro.Container.dao;

import com.distro.Container.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo,Integer> {
    List<Cargo> findByContainerCode(String containerCode);
}