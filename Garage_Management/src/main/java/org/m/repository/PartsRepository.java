package org.m.repository;

import org.m.entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long>
{

    List<Parts> findByGarageId(Long garageId);

    Optional<Parts> findByPartIdAndGarageId(Long partId, Long garageId);

}