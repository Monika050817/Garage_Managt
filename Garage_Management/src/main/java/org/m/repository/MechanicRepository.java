package org.m.repository;

import org.m.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long>
{

    List<Mechanic> findByGarageId(Long garageId);

    Mechanic findByMechanicIdAndGarageId(Long mechanicId , Long garageId);

}