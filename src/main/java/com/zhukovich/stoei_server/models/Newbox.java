package com.zhukovich.stoei_server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "NewsSub")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Newbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subTitle")
    private String sub_title;

    @Column(name = "mainText")
    private String main_text;

    @Column(name = "description")
    private String description;

    @Column(name = "under")
    private String under;

    //    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
    @Column(name = "new_id")
    private Long newID;
}
