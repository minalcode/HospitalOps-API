
package com.jpahibernate.example.hospital_management.controller;

import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/apis")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient) {
        String response = patientService.savePatient(patient);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Patient findPatientById(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);
        return patient;
    }

    @GetMapping("/findAll")
    public List<Patient> findAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        return patientList;
    }

    @GetMapping("/count")
    public String countPatients() {
        String response = patientService.countPatients();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatientById(@PathVariable int id) {
        String response = patientService.deletePatientById(id);
        return response;
    }

    @PutMapping("/updatePut/{id}")
    public String updatePatientUsingPut(
            @PathVariable int id,
            @RequestBody Patient newPatient) {

        String response = patientService.updatePatientUsingPut(id, newPatient);
        return response;
    }

    @PatchMapping("/updatePatch/{id}")
    public String updatePatientUsingPatch(
            @PathVariable int id,
            @RequestParam String newMobile,
            @RequestParam String newEmail) {

        String response = patientService.updatePatientUsingPatch(
                id, newMobile, newEmail);

        return response;
    }
}
