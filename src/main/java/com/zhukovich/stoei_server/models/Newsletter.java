package com.zhukovich.stoei_server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Newsletter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "under")
    private String under;

    @Column(name = "upload_date")
    private LocalDate uploadDate;

    @Column(name = "endEvent")
    private LocalDate endEvent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "new_id")
    private List<Newbox> newssubs = new ArrayList<>();

    @Column(name = "user_id")
    private Long userID;
}

