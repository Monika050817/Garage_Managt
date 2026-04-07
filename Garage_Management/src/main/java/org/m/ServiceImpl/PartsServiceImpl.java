package org.m.ServiceImpl;

import org.m.entity.Parts;
import org.m.repository.PartsRepository;
import org.m.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsRepository partsRepository;

    @Override
    public Map<String, Object> addParts(Parts parts) {
        Map<String, Object> response = new HashMap<>();

        if (parts.getPartName() == null || parts.getPartName().isEmpty()) {
            response.put("status", "FAILED");
            response.put("code", 400);
            response.put("message", "Part Name required");
            response.put("data", null);
            return response;
        }

        partsRepository.save(parts);

        response.put("status", "SUCCESS");
        response.put("code", 200);
        response.put("message", "Parts added successfully");
        response.put("data", null);

        return response;
    }

    @Override
    public Map<String, Object> getAllParts() {
        Map<String, Object> response = new HashMap<>();

        List<Parts> list = partsRepository.findAll();

        response.put("status", "SUCCESS");
        response.put("code", 200);
        response.put("message", "Parts fetched successfully");
        response.put("data", list);

        return response;
    }

    @Override
    public Map<String, Object> getPartsById(Long id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Parts> parts = partsRepository.findById(id);

        if (parts.isPresent()) {
            response.put("status", "SUCCESS");
            response.put("code", 200);
            response.put("message", "Parts fetched successfully");
            response.put("data", parts.get());
        } else {
            response.put("status", "FAILED");
            response.put("code", 404);
            response.put("message", "Parts not found");
            response.put("data", null);
        }

        return response;
    }

    @Override
    public Map<String, Object> updateParts(Long id, Parts parts) {
        Map<String, Object> response = new HashMap<>();

        Optional<Parts> existing = partsRepository.findById(id);

        if (existing.isPresent()) {
            Parts part = existing.get();

            part.setPartName(parts.getPartName());
            part.setPartNumber(parts.getPartNumber());
            part.setQuantity(parts.getQuantity());
            part.setCostPrice(parts.getCostPrice());
            part.setSellingPrice(parts.getSellingPrice());

            partsRepository.save(part);

            response.put("status", "SUCCESS");
            response.put("code", 200);
            response.put("message", "Parts updated successfully");
            response.put("data", null);
        } else {
            response.put("status", "FAILED");
            response.put("code", 404);
            response.put("message", "Parts not found");
            response.put("data", null);
        }

        return response;
    }

    @Override
    public Map<String, Object> deleteParts(Long id) {
        Map<String, Object> response = new HashMap<>();

        if (partsRepository.existsById(id)) {
            partsRepository.deleteById(id);

            response.put("status", "SUCCESS");
            response.put("code", 200);
            response.put("message", "Parts deleted successfully");
            response.put("data", null);
        } else {
            response.put("status", "FAILED");
            response.put("code", 404);
            response.put("message", "Parts not found");
            response.put("data", null);
        }

        return response;
    }
}