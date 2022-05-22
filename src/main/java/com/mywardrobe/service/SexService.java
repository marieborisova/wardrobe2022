package com.mywardrobe.service;


import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Sex;

import java.util.List;

public interface SexService {

    Sex insert(Sex sex);

    List<Sex> getAll();

    Sex getById(int id);

    Sex getByName(String name);

    Sex update(int id, String name);

    void deleteById(int id);


}
