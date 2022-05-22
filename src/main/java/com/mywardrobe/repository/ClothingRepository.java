package com.mywardrobe.repository;

import com.mywardrobe.domain.Clothing;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
    @Override
    @EntityGraph(attributePaths = {"season", "size", "sex"} )
    List<Clothing> findAll();

    List<Clothing> findByName(String name);
}
