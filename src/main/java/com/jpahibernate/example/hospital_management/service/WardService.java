
package com.jpahibernate.example.hospital_management.service;

import com.jpahibernate.example.hospital_management.model.Ward;
import com.jpahibernate.example.hospital_management.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class WardService {

    @Autowired
    WardRepository wardRepository;

    public String saveWard(Ward ward) {
        wardRepository.save(ward);
        return "Ward saved successfully!";
    }

    public List<Ward> getAllWards() {
        List<Ward> wardList = wardRepository.findAll();
        return wardList;
    }

    public Ward getWardById(int wardId) {
        Optional<Ward> wardOptional = wardRepository.findById(wardId);

        if (wardOptional.isPresent()) {
            return wardOptional.get();
        } else {
            return null;
        }
    }

    public String countWards() {
        long totalCount = wardRepository.count();
        return "total wards present are : " + totalCount;
    }

    public String deleteWardById(int id) {
        wardRepository.deleteById(id);
        return "Ward with id : " + id + " is deleted successfully!";
    }

    // Update using PUT operation
    public String updateWardUsingPut(int wardId, Ward newWardRequest) {
        Ward existingWard = getWardById(wardId);

        if (existingWard != null) {
            newWardRequest.setId(wardId);
            wardRepository.save(newWardRequest);
            return "Ward with id : " + wardId + " updated successfully!";
        } else {
            return "Ward with id : " + wardId
                    + " cannot be updated as it is not present";
        }
    }

    // Update using PATCH operation
    public String updateWardUsingPatch(int wardId, String newWardName) {
        Ward existingWard = getWardById(wardId);

        if (existingWard != null) {
            existingWard.setWardType(newWardName);
            wardRepository.save(existingWard);
            return "Ward with id : " + wardId + " updated successfully!";
        } else {
            return "Ward with id : " + wardId
                    + " cannot be updated as it is not present";
        }
    }
}
