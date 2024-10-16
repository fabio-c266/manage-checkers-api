package com.trabalhoundb.manage.checkers.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "championship")
@NoArgsConstructor
@Getter
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int maxPlayers;
    private int minPoints;

    //private Administrator createdBy;

    private Date endSubscriptions;
    private Date startedAt;
    private Date endedAt;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
