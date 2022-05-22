package com.mywardrobe.service;


import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Sex;
import com.mywardrobe.domain.Size;
import com.mywardrobe.domain.Clothing;
import com.mywardrobe.repository.SeasonRepository;
import com.mywardrobe.repository.SexRepository;
import com.mywardrobe.repository.SizeRepository;
import com.mywardrobe.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingServiceImpl implements ClothingService {

    private final SeasonRepository seasonRepository;
    private final ClothingRepository clothingRepository;
    private final SizeRepository sizeRepository;
    private final SexRepository sexRepository;


    @Override
    public Clothing insert(String nameClothing, String nameSeason,
                           String nameSize, String nameSex) {
        Season season = seasonRepository.findByName(nameSeason);

        if (season == null){
            season = Season.builder().name(nameSeason).build();
        }
        Size size = sizeRepository.findByName(nameSize);
        if (size == null){
            size = Size.builder().name(nameSize).build();
        }
        Sex sex= sexRepository.findByName(nameSex);
        if (sex == null){
            sex = Sex.builder().name(nameSex).build();
        }

        Clothing clothing = Clothing.builder()
                .name(nameClothing)
                .season(season)
                .size(size)
                .sex(sex)
                .build();
        return clothingRepository.save(clothing);


    }

    @Override
    public Clothing update(int id, String nameClothing, String nameSeason, String nameSize, String nameSex) {
        Season season = seasonRepository.findByName(nameSeason);

        if (season == null){
            season = Season.builder().name(nameSeason).build();
        }
        Size size = sizeRepository.findByName(nameSize);
        if (size == null){
            size = Size.builder().name(nameSize).build();
        }
        Sex sex = sexRepository.findByName(nameSex);
        if (sex == null){
            sex = Sex.builder().name(nameSex).build();
        }

        Clothing clothing = Clothing.builder()
                .id(id)
                .name(nameClothing)
                .season(season)
                .size(size)
                .sex(sex)
                .build();
        return clothingRepository.save(clothing);
    }

    @Override
    public List<Clothing> getAll() {
        return clothingRepository.findAll();
    }

    @Override
    public Clothing getById(int id) {
        return clothingRepository.getById(id);
    }

    @Override
    public List<Clothing> getByName(String nameClothing) {
        return clothingRepository.findByName(nameClothing);
    }

    @Override
    public void deleteById(int id) {
        clothingRepository.deleteById(id);

    }
}

