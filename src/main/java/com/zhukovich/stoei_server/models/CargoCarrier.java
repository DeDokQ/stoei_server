package com.zhukovich.stoei_server.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cargoСarrier")
public class CargoCarrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "description", length = 1024)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ccarrier_id")
    private List<User> users = new ArrayList<>();
}
