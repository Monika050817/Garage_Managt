package org.m.controller;

import org.m.entity.JobParts;
import org.m.Service.JobPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/jobparts")
public class JobPartsController
{

    @Autowired
    private JobPartsService jobPartsService;


    @PostMapping("/add")
    public Map<String,Object> addJobPart(@RequestBody JobParts jobParts)
    {
        return jobPartsService.addJobPart(jobParts);
    }


    @GetMapping("/getAll")
    public Map<String,Object> getAllJobParts()
    {
        return jobPartsService.getAllJobParts();
    }


    @GetMapping("/getById/{id}")
    public Map<String,Object> getJobPartById(@PathVariable Long id)
    {
        return jobPartsService.getJobPartById(id);
    }


    @PutMapping("/update/{id}")
    public Map<String,Object> updateJobPart(@PathVariable Long id ,
                                            @RequestBody JobParts jobParts)
    {
        return jobPartsService.updateJobPart(id , jobParts);
    }


    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteJobPart(@PathVariable Long id)
    {
        return jobPartsService.deleteJobPart(id);
    }

}