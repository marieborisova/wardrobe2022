package com.mywardrobe.service;

import com.mywardrobe.domain.Sex;
import com.mywardrobe.domain.Size;
import com.mywardrobe.repository.SexRepository;
import com.mywardrobe.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SexServiceImpl implements SexService{

    private final SexRepository sexRepository;


    @Override
    public Sex insert(Sex sex) {
        return sexRepository.save(sex);
    }

    @Override
    public List<Sex> getAll() {
        return sexRepository.findAll();
    }

    @Override
    public Sex getById(int id) {
        return sexRepository.getById(id);
    }

    @Override
    public Sex getByName(String name) {
        return sexRepository.findByName(name);
    }

    @Override
    public Sex update(int id, String name) {

        Sex sex = Sex.builder().id(id).name(name).build();
        return sexRepository.save(sex);
    }

    @Override
    public void deleteById(int id) {

        sexRepository.deleteById(id);
    }
}

