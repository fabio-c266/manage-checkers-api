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
    private Double registrationFee;

    //private Administrator createdBy;

    private Date endSubscriptions;
    private Date startedAt;
    private Date endedAt;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserPlayer userPlayer;

	public Championship(String name, String description, int maxPlayers, int minPoints, Double registrationFee,
			Date endSubscriptions, Date startedAt, Date endedAt, UserPlayer userPlayer) {
		super();
		this.name = name;
		this.description = description;
		this.maxPlayers = maxPlayers;
		this.minPoints = minPoints;
		this.registrationFee = registrationFee;
		this.endSubscriptions = endSubscriptions;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
		this.userPlayer = userPlayer;
	}
    
    
}
