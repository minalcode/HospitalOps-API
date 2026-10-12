
package com.jpahibernate.example.hospital_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ward")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ward {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "ward_name", nullable = false)
    private String name;

    @Column(name = "ward_type", nullable = false)
    private String wardType;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

    @Column(name = "status", nullable = false)
    private String status;

}
