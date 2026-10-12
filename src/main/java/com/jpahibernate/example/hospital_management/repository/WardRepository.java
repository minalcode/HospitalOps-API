package com.jpahibernate.example.hospital_management.repository;

import com.jpahibernate.example.hospital_management.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // It performs the database operations
public interface WardRepository extends JpaRepository<Ward, Integer> {
}