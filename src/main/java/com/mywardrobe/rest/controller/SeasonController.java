package com.mywardrobe.rest.controller;

import com.mywardrobe.domain.Season;
import com.mywardrobe.rest.dto.SeasonDto;
import com.mywardrobe.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SeasonController {
    private final SeasonService seasonService;
    @GetMapping("/season")
    public List<SeasonDto> getAllSeason(){
        return seasonService.getAll()
                .stream()
                .map(SeasonDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/season")
    public SeasonDto insertSeason(@RequestBody SeasonDto seasonDto){
        Season season = seasonService.insert(SeasonDto.toDomainObject(seasonDto));
        return SeasonDto.toDto(season);

    }

    @PutMapping("/season/{id}")
    public SeasonDto updateSeason(@PathVariable int id,
                                  @RequestParam String name){
        Season season = seasonService.update(id, name);
        return SeasonDto.toDto(season);
    }

    @DeleteMapping("/season/{id}")
    public void deleteSeason(@PathVariable int id){
        seasonService.deleteById(id);
    }

    @GetMapping("/season/{id}")
    public SeasonDto getSeasonById(@PathVariable int id){
        Season season = seasonService.getById(id);
        return SeasonDto.toDto(season);
    }




}

