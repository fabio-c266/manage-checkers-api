package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep", nullable = false, length = 8)
    private String CEP;

    @Column(name = "street", nullable = false, length = 60)
    private String street;

    @Column(name = "neighborhood", nullable = false, length = 60)
    private String neighborhood;

    @Column(name = "complement", length = 100)
    private String complement;

    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "fk_city_id")
    private City city;
}
