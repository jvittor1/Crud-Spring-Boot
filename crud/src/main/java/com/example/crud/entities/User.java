package com.example.crud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name")
    @NotBlank
    private String fullName;

    @Column(name = "email", unique = true)
    @NotBlank
    private String email;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "created_at")
    @NotNull
    private Instant createdAt;


    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = Instant.now();
    }

    public void Update(String fullName, String email, String password){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

}
