package com.example.productservice_wfs.inheritance.joint;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "single_instructors")
@Data
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private Double rating;
}
