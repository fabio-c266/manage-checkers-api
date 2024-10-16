package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")

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
    
    @OneToOne(mappedBy = "address")
    private UserPlayer userPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_city_id")
    private City city;
}
