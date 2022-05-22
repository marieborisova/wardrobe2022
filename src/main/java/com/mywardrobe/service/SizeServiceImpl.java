package com.mywardrobe.service;


import com.mywardrobe.domain.Size;
import com.mywardrobe.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService{

    private final SizeRepository sizeRepository;


    @Override
    public Size insert(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(int id) {
        return sizeRepository.getById(id);
    }

    @Override
    public Size getByName(String name) {
        return sizeRepository.findByName(name);
    }

    @Override
    public Size update(int id, String name) {

        Size size = Size.builder().id(id).name(name).build();
        return sizeRepository.save(size);
    }

    @Override
    public void deleteById(int id) {

        sizeRepository.deleteById(id);
    }
}

