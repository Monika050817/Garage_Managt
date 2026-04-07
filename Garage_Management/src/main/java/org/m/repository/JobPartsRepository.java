package org.m.repository;

import org.m.entity.JobParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobPartsRepository extends JpaRepository<JobParts, Long>
{

    List<JobParts> findByGarageId(Long garageId);

    Optional<JobParts> findByJobPartsIdAndGarageId(Long jobPartsId, Long garageId);

}