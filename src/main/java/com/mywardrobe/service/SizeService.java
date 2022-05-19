package com.mywardrobe.service;

import com.mywardrobe.domain.Size;

import java.util.List;

public interface SizeService {
    Size insert(Size size);

    List<Size> getAll();

    Size getById(int id);

    Size getByName(String name);

    Size update(int id, String name);

    void deleteById(int id);

}