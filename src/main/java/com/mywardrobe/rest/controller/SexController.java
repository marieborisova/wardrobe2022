package com.mywardrobe.rest.controller;

import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Sex;
import com.mywardrobe.rest.dto.SeasonDto;
import com.mywardrobe.rest.dto.SexDto;
import com.mywardrobe.service.SeasonService;
import com.mywardrobe.service.SexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SexController {
    private final SexService sexService;
    @GetMapping("/sex")
    public List<SexDto> getAllSex(){
        return sexService.getAll()
                .stream()
                .map(SexDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/sex")
    public SexDto insertSex(@RequestBody SexDto sexDto){
        Sex sex = sexService.insert(SexDto.toDomainObject(sexDto));
        return SexDto.toDto(sex);

    }

    @PutMapping("/sex/{id}")
    public SexDto updateSeason(@PathVariable int id,
                                  @RequestParam String name){
        Sex sex = sexService.update(id, name);
        return SexDto.toDto(sex);
    }

    @DeleteMapping("/sex/{id}")
    public void deleteSex(@PathVariable int id){
        sexService.deleteById(id);
    }

    @GetMapping("/sex/{id}")
    public SexDto getSexById(@PathVariable int id){
        Sex sex = sexService.getById(id);
        return SexDto.toDto(sex);
    }




}