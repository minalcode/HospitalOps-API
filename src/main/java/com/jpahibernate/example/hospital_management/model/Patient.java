
package com.jpahibernate.example.hospital_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "patient_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

}
