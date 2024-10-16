package com.trabalhoundb.manage.checkers.api.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "state")
@NoArgsConstructor
@Getter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "acronym", unique = true, nullable = false, columnDefinition = "CHAR(2)")
    private String acronym;

    @Column(name = "name", unique = true, nullable = false, length = 20)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
    private List<City> cities;
}
