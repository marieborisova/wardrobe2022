package com.mywardrobe.service;

import com.mywardrobe.domain.Clothing;

import java.util.List;

public interface ClothingService {
    Clothing insert(
            String nameClothing,
            String nameSeason,
            String nameSize,
            String nameSex
    );

    Clothing update(
            int id,
            String nameClothing,
            String nameSeason,
            String nameSize,
            String nameSex
    );

    List<Clothing> getAll();

    Clothing getById(int id);

    List<Clothing> getByName(String nameClothing);

    void deleteById(int id);

}

