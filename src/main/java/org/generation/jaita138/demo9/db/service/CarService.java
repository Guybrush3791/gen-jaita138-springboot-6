package org.generation.jaita138.demo9.db.service;

import java.util.List;

import org.generation.jaita138.demo9.db.entity.Car;
import org.generation.jaita138.demo9.db.repo.CarRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public List<Car> findAll() {

        return carRepo.findAll();
    }

    public void save(Car car) {

        carRepo.save(car);
    }

    public void delete(Car car) {

        carRepo.delete(car);

    }

    @Transactional
    public Car findById(Long id) {

        // return carRepo.findById(id).orElse(null);

        Car car = carRepo.findById(id).orElse(null);

        Hibernate.initialize(car.getOwners());

        return car;
    }
}
