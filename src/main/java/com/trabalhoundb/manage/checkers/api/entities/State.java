package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.*;
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
}
