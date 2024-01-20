package com.distro.Container.dao;

import com.distro.Container.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container,Integer> {
}
