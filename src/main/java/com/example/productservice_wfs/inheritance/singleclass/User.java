package com.example.productservice_wfs.inheritance.singleclass;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "single_users")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {
    private String name;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
