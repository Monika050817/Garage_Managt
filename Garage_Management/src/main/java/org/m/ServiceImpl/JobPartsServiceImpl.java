package org.m.ServiceImpl;

import org.m.entity.JobParts;
import org.m.entity.Parts;
import org.m.repository.JobPartsRepository;
import org.m.repository.PartsRepository;
import org.m.Service.JobPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobPartsServiceImpl implements JobPartsService
{

    @Autowired
    private JobPartsRepository jobPartsRepository;

    @Autowired
    private PartsRepository partsRepository;

    @Override
    public Map<String, Object> addJobPart(JobParts jobParts)
    {
        Map<String,Object> response = new HashMap<>();

        if(jobParts.getPartId()==null)
        {
            response.put("status","FAILED");
            response.put("code",400);
            response.put("message","Part Id required");
            response.put("data",null);
            return response;
        }

        Parts parts = partsRepository.findById(jobParts.getPartId()).orElse(null);

        if(parts != null)
        {
            int remaining = parts.getQuantity() - jobParts.getQuantityUsed();
            parts.setQuantity(remaining);
            partsRepository.save(parts);
        }

        jobPartsRepository.save(jobParts);

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Job Parts added successfully");
        response.put("data",jobParts);

        return response;
    }

    @Override
    public Map<String, Object> getAllJobParts()
    {
        Map<String,Object> response = new HashMap<>();

        List<JobParts> list = jobPartsRepository.findAll();

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Job Parts fetched successfully");
        response.put("data",list);

        return response;
    }

    @Override
    public Map<String, Object> getJobPartById(Long id)
    {
        Map<String,Object> response = new HashMap<>();

        Optional<JobParts> jobParts = jobPartsRepository.findById(id);

        if(jobParts.isPresent())
        {
            response.put("status","SUCCESS");
            response.put("code",200);
            response.put("message","Job Parts fetched successfully");
            response.put("data",jobParts.get());
        }
        else
        {
            response.put("status","FAILED");
            response.put("code",404);
            response.put("message","Job Parts not found");
            response.put("data",null);
        }

        return response;
    }

    @Override
    public Map<String, Object> updateJobPart(Long id, JobParts jobParts)
    {
        Map<String,Object> response = new HashMap<>();

        Optional<JobParts> existing = jobPartsRepository.findById(id);

        if(existing.isPresent())
        {
            JobParts jp = existing.get();

            jp.setJobId(jobParts.getJobId());
            jp.setPartId(jobParts.getPartId());
            jp.setQuantityUsed(jobParts.getQuantityUsed());

            jobPartsRepository.save(jp);

            response.put("status","SUCCESS");
            response.put("code",200);
            response.put("message","Job Parts updated successfully");
            response.put("data",null);
        }
        else
        {
            response.put("status","FAILED");
            response.put("code",404);
            response.put("message","Job Parts not found");
            response.put("data",null);
        }

        return response;
    }

    @Override
    public Map<String, Object> deleteJobPart(Long id)
    {
        Map<String,Object> response = new HashMap<>();

        if(jobPartsRepository.existsById(id))
        {
            jobPartsRepository.deleteById(id);

            response.put("status","SUCCESS");
            response.put("code",200);
            response.put("message","Job Parts deleted successfully");
            response.put("data",null);
        }
        else
        {
            response.put("status","FAILED");
            response.put("code",404);
            response.put("message","Job Parts not found");
            response.put("data",null);
        }

        return response;
    }

}