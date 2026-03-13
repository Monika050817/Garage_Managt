package org.m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.m.entity.Job;
import org.m.repository.JobRepository;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        job.setJobId(id);
        return jobRepository.save(job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable int id) {
        jobRepository.deleteById(id);
        return "Job Deleted Successfully";
    }
}