package com.jpahibernate.example.hospital_management.repository;

import com.jpahibernate.example.hospital_management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // It performs the database operations
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}