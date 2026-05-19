package com.example.spring_auth_demo.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;


}
