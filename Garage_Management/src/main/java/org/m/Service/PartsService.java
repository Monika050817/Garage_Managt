package org.m.service;

import org.m.entity.Parts;
import java.util.Map;

public interface PartsService
{

    Map<String,Object> addParts(Parts parts);

    Map<String,Object> getAllParts();

    Map<String,Object> getPartsById(Long id);

    Map<String,Object> updateParts(Long id , Parts parts);

    Map<String,Object> deleteParts(Long id);

}