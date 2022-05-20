package com.mywardrobe.service;

import com.mywardrobe.domain.Wardrobe;

import java.util.List;

public interface WardrobeService {
    Wardrobe insert(
            String nameWardrobe,
            String nameSeason,
            String nameSize
    );

    Wardrobe update(
            int id,
            String nameWardrobe,
            String nameSeason,
            String nameSize
    );

    List<Wardrobe> getAll();

    Wardrobe getById(int id);

    List<Wardrobe> getByName(String nameBook);

    void deleteById(int id);

}

