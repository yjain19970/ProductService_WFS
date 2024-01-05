package com.example.productservice_wfs.inheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "single_mentors")
@Data
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String companyName;
}
