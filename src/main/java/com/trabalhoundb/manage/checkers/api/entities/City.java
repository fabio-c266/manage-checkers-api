package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@NoArgsConstructor
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false, length = 40)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_state_id")
    private State state;
}
