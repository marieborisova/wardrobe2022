package com.mywardrobe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "wardrobe")
public class Wardrobe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(targetEntity = Season.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToOne(targetEntity = Size.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wardrobe")
    private List<Comment> commentList;
}
