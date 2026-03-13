package org.m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.m.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}