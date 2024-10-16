package com.trabalhoundb.manage.checkers.api.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address implements Serializable{
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
    
    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private UserPlayer userPlayer;

    @ManyToOne
    @JoinColumn(name = "fk_city_id")
    private City city;
}
