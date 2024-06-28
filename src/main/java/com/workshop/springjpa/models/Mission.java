package com.workshop.springjpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Mission {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int duration;


}
