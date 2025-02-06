package org.generation.jaita138.demo9.db.service;

import java.util.List;

import org.generation.jaita138.demo9.db.entity.Park;
import org.generation.jaita138.demo9.db.repo.ParkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ParkService {

    @Autowired
    private ParkRepo parkRepo;

    public List<Park> findAll() {

        return parkRepo.findAll();
    }

    public void save(Park park) {

        parkRepo.save(park);
    }

    @Transactional
    public Park findById(Long id) {

        return parkRepo.findById(id).orElse(null);

        // Park park = parkRepo.findById(id).orElse(null);

        // Hibernate.initialize(park.getCars());

        // return park;
    }
}
