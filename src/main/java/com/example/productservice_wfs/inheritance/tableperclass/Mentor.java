package com.example.productservice_wfs.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "tpc_mentors")
@Data
public class Mentor extends User {
    private String companyName;
}
