package org.generation.jaita138.demo9.db.service;

import java.util.List;

import org.generation.jaita138.demo9.db.entity.Owner;
import org.generation.jaita138.demo9.db.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepo ownerRepo;

    public List<Owner> findAll() {

        return ownerRepo.findAll();
    }

    public void save(Owner owner) {

        ownerRepo.save(owner);
    }

    public Owner findById(Long id) {

        return ownerRepo.findById(id).orElse(null);
    }
}
