package com.example.productservice_wfs.inheritance.joint;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "joint_mentors")
@Data
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String companyName;
}
