package com.mywardrobe.service;


import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Size;
import com.mywardrobe.domain.Wardrobe;
import com.mywardrobe.repository.SeasonRepository;
import com.mywardrobe.repository.SizeRepository;
import com.mywardrobe.repository.WardrobeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WardrobeServiceImpl implements WardrobeService{

    private final SeasonRepository seasonRepository;
    private final WardrobeRepository wardrobeRepository;
    private final SizeRepository sizeRepository;


    @Override
    public Wardrobe insert(String nameWardrobe, String nameSeason,
                           String nameSize) {
        Season season = seasonRepository.findByName(nameSeason);

        if (season == null){
            season = Season.builder().name(nameSeason).build();
        }
        Size size = sizeRepository.findByName(nameSize);
        if (size == null){
            size = Size.builder().name(nameSize).build();
        }

        Wardrobe wardrobe = Wardrobe.builder()
                .name(nameWardrobe)
                .season(season)
                .size(size)
                .build();
        return wardrobeRepository.save(wardrobe);


    }

    @Override
    public Wardrobe update(int id, String nameWardrobe, String nameSeason, String nameSize) {
        Season season = seasonRepository.findByName(nameSeason);

        if (season == null){
            season = Season.builder().name(nameSeason).build();
        }
        Size size = sizeRepository.findByName(nameSize);
        if (size == null){
            size = Size.builder().name(nameSize).build();
        }

        Wardrobe wardrobe = Wardrobe.builder()
                .id(id)
                .name(nameWardrobe)
                .season(season)
                .size(size)
                .build();
        return wardrobeRepository.save(wardrobe);
    }

    @Override
    public List<Wardrobe> getAll() {
        return wardrobeRepository.findAll();
    }

    @Override
    public Wardrobe getById(int id) {
        return wardrobeRepository.getById(id);
    }

    @Override
    public List<Wardrobe> getByName(String nameBook) {
        return wardrobeRepository.findByName(nameBook);
    }

    @Override
    public void deleteById(int id) {
        wardrobeRepository.deleteById(id);

    }
}

