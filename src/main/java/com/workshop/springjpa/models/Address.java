package com.workshop.springjpa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String streetName;

    private String houseNumber;

    private String zipCode;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
