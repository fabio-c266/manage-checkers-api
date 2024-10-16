package com.trabalhoundb.manage.checkers.api.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.trabalhoundb.manage.checkers.api.enums.GenderTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userPlayer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenderTypes gender;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String CPF;

    @Column(name = "phone", unique = true, nullable = false, length = 11)
    private String phone;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hashed", nullable = false)
    private String passwordHashed;

    @Column(name = "points", nullable = false)
    private Long points;
    
    @Column(name = "winners")
    private Long winners;
    
    @Column(name = "defeats")
    private Long defeats;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_address_id", referencedColumnName = "id",unique = true, nullable = false)
    private Address address;
}
