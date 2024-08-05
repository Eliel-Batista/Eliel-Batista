package com.example.adress_maneger.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl-adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String street;

    private int number;

    private String complement;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String cep;

}
