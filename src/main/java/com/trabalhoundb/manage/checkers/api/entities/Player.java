package com.trabalhoundb.manage.checkers.api.entities;

import com.trabalhoundb.manage.checkers.api.enums.GenderTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenderTypes gender;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "username", unique = true, nullable = false, length = 16)
    private String username;

    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String CPF;

    @Column(name = "phone", unique = true, nullable = false, length = 11)
    private String phone;

    @Column(name = "email", unique = true, nullable = false, length = 80)
    private String email;

    @Column(name = "password_hashed", nullable = false)
    private String passwordHashed;

    @Column(name = "points", nullable = false, columnDefinition = "default '0'")
    private Long points;

    @Column(name = "active", columnDefinition = "TINYINT(1)")
    private boolean active;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "fk_address_id", unique = true, nullable = false)
    private Address address;
}
