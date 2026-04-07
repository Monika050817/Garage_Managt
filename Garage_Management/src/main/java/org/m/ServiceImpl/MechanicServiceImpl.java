package org.m.ServiceImpl;

import org.m.entity.Mechanic;
import org.m.repository.MechanicRepository;
import org.m.Service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MechanicServiceImpl implements MechanicService
{

    @Autowired
    private MechanicRepository mechanicRepository;

    @Override
    public Map<String,Object> addMechanic(Mechanic mechanic)
    {
        Map<String,Object> response = new HashMap<>();

        mechanicRepository.save(mechanic);

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Mechanic added successfully");
        response.put("data",null);

        return response;
    }

    @Override
    public Map<String,Object> getAllMechanics(Long garageId)
    {
        Map<String,Object> response = new HashMap<>();

        List<Mechanic> list = mechanicRepository.findByGarageId(garageId);

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Mechanics fetched successfully");
        response.put("data",list);

        return response;
    }

    @Override
    public Map<String,Object> getMechanicById(Long mechanicId , Long garageId)
    {
        Map<String,Object> response = new HashMap<>();

        Mechanic mechanic =
                mechanicRepository.findByMechanicIdAndGarageId(mechanicId , garageId);

        if(mechanic == null)
        {
            response.put("status","FAILED");
            response.put("code",400);
            response.put("message","Mechanic not found");
            response.put("data",null);

            return response;
        }

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Mechanic fetched successfully");
        response.put("data",mechanic);

        return response;
    }

    @Override
    public Map<String,Object> updateMechanic(Long mechanicId , Mechanic mechanic)
    {
        Map<String,Object> response = new HashMap<>();

        Mechanic existing =
                mechanicRepository.findByMechanicIdAndGarageId
                        (mechanicId , mechanic.getGarageId());

        if(existing == null)
        {
            response.put("status","FAILED");
            response.put("code",400);
            response.put("message","Mechanic not found");
            response.put("data",null);

            return response;
        }

        existing.setEmail(mechanic.getEmail());
        existing.setAddress(mechanic.getAddress());
        existing.setSpecialization(mechanic.getSpecialization());
        existing.setStatus(mechanic.getStatus());

        mechanicRepository.save(existing);

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Mechanic updated successfully");
        response.put("data",null);

        return response;
    }

    @Override
    public Map<String,Object> deleteMechanic(Long mechanicId , Long garageId)
    {
        Map<String,Object> response = new HashMap<>();

        Mechanic mechanic =
                mechanicRepository.findByMechanicIdAndGarageId(mechanicId , garageId);

        if(mechanic == null)
        {
            response.put("status","FAILED");
            response.put("code",400);
            response.put("message","Mechanic not found");
            response.put("data",null);

            return response;
        }

        mechanicRepository.delete(mechanic);

        response.put("status","SUCCESS");
        response.put("code",200);
        response.put("message","Mechanic deleted successfully");
        response.put("data",null);

        return response;
    }

}