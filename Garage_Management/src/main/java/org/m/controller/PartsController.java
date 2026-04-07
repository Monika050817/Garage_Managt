package org.m.controller;

import org.m.entity.Parts;
import org.m.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/parts")
public class PartsController
{

    @Autowired
    private PartsService partsService;


    @PostMapping("/add")
    public Map<String,Object> addParts(@RequestBody Parts parts)
    {
        return partsService.addParts(parts);
    }


    @GetMapping("/getAll")
    public Map<String,Object> getAllParts()
    {
        return partsService.getAllParts();
    }


    @GetMapping("/getById/{id}")
    public Map<String,Object> getPartsById(@PathVariable Long id)
    {
        return partsService.getPartsById(id);
    }


    @PutMapping("/update/{id}")
    public Map<String,Object> updateParts(@PathVariable Long id ,
                                          @RequestBody Parts parts)
    {
        return partsService.updateParts(id , parts);
    }


    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteParts(@PathVariable Long id)
    {
        return partsService.deleteParts(id);
    }

}