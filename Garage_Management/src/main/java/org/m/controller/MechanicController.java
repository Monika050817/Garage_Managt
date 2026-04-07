package org.m.controller;

import org.m.entity.Mechanic;
import org.m.Service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mechanics")
public class MechanicController
{

    @Autowired
    private MechanicService mechanicService;

    @PostMapping("/add")
    public Map<String,Object> addMechanic(@RequestBody Mechanic mechanic)
    {
        return mechanicService.addMechanic(mechanic);
    }

    @PostMapping("/getAll")
    public Map<String,Object> getAllMechanics(@RequestBody Mechanic mechanic)
    {
        return mechanicService.getAllMechanics(mechanic.getGarageId());
    }

    @PostMapping("/getById")
    public Map<String,Object> getMechanicById(@RequestBody Mechanic mechanic)
    {
        return mechanicService.getMechanicById(
                mechanic.getMechanicId(),
                mechanic.getGarageId());
    }

    @PostMapping("/update")
    public Map<String,Object> updateMechanic(@RequestBody Mechanic mechanic)
    {
        return mechanicService.updateMechanic(
                mechanic.getMechanicId(),
                mechanic);
    }

    @PostMapping("/delete")
    public Map<String,Object> deleteMechanic(@RequestBody Mechanic mechanic)
    {
        return mechanicService.deleteMechanic(
                mechanic.getMechanicId(),
                mechanic.getGarageId());
    }

}