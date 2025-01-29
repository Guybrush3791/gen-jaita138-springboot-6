package org.generation.jaita138.demo9.db.repo;

import org.generation.jaita138.demo9.db.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}
