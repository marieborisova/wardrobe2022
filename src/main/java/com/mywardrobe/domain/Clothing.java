package com.mywardrobe.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clothing")
public class Clothing {
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
    @ManyToOne(targetEntity = Sex.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "sex_id")
    private Sex sex;


}
