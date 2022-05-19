package com.mywardrobe.service;


import com.mywardrobe.domain.Season;
import com.mywardrobe.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;


    @Override
    public Season insert(Season author) {


        return seasonRepository.save(author);
    }

    @Override
    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    @Override
    public Season getById(int id) {

        return seasonRepository.getById(id);
    }

    @Override
    public Season getByName(String name) {
        return seasonRepository.findByName(name);
    }

    @Override
    public Season update(int id, String name) {

        Season author = Season.builder()
                .id(id)
                .name(name).build();
        return seasonRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        seasonRepository.deleteById(id);



    }
}

