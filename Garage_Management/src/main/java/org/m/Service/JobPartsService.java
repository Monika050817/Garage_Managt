package org.m.Service;

import org.m.entity.JobParts;
import java.util.Map;

public interface JobPartsService
{

    Map<String,Object> addJobPart(JobParts jobParts);

    Map<String,Object> getAllJobParts();

    Map<String,Object> getJobPartById(Long id);

    Map<String,Object> updateJobPart(Long id , JobParts jobParts);

    Map<String,Object> deleteJobPart(Long id);

}