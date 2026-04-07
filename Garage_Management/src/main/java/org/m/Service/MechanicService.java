package org.m.Service;

import org.m.entity.Mechanic;
import java.util.Map;

public interface MechanicService
{

    Map<String,Object> addMechanic(Mechanic mechanic);

    Map<String,Object> getAllMechanics(Long garageId);

    Map<String,Object> getMechanicById(Long mechanicId , Long garageId);

    Map<String,Object> updateMechanic(Long mechanicId , Mechanic mechanic);

    Map<String,Object> deleteMechanic(Long mechanicId , Long garageId);

}