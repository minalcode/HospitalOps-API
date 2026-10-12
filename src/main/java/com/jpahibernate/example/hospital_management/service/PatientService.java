
package com.jpahibernate.example.hospital_management.service;

import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient saved successfully!";
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int patientId) {
        Optional<Patient> patientOptional =
                patientRepository.findById(patientId);

        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            return null;
        }
    }

    public String countPatients() {
        long totalCount = patientRepository.count();
        return "total patients present are : " + totalCount;
    }

    public String deletePatientById(int id) {
        patientRepository.deleteById(id);
        return "Patient with id : " + id + " is deleted successfully!";
    }

    // Update using PUT operation
    public String updatePatientUsingPut(int patientId, Patient newPatientRequest) {
        Patient existingPatient = getPatientById(patientId);

        if (existingPatient != null) {
            newPatientRequest.setId(patientId);
            patientRepository.save(newPatientRequest);
            return "Patient with id : " + patientId + " updated successfully!";
        } else {
            return "Patient with id : " + patientId
                    + " cannot be updated as it is not present";
        }
    }

    // Update using PATCH operation
    public String updatePatientUsingPatch(int patientId, String newMobile, String newEmail) {
        Patient existingPatient = getPatientById(patientId);

        if (existingPatient != null) {
            existingPatient.setMobile(newMobile);
            existingPatient.setEmail(newEmail);
            patientRepository.save(existingPatient);
            return "Patient with id : " + patientId + " updated successfully!";
        } else {
            return "Patient with id : " + patientId
                    + " cannot be updated as it is not present";
        }
    }
}
