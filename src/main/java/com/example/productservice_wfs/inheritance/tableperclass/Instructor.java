package com.example.productservice_wfs.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "tpc_instructors")
@Data
public class Instructor extends User {
    private Double rating;
}
