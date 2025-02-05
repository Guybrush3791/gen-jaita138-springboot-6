package org.generation.jaita138.demo9.db.repo;

import org.generation.jaita138.demo9.db.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {

}
