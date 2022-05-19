package com.mywardrobe.service;

import com.mywardrobe.domain.Season;

import java.util.List;

public interface SeasonService {

    Season insert(Season season);

    List<Season> getAll();

    Season getById(int id);

    Season getByName(String name);

    Season update(int id, String name);

    void deleteById(int id);


}
