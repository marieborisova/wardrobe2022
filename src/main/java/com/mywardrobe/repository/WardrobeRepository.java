package com.mywardrobe.repository;

import com.mywardrobe.domain.Wardrobe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardrobeRepository  extends JpaRepository<Wardrobe, Integer> {
    @Override
    @EntityGraph(attributePaths = {"season", "size"} )
    List<Wardrobe> findAll();

    List<Wardrobe> findByName(String name);
}
