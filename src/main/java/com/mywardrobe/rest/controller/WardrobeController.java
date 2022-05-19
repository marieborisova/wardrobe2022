package com.mywardrobe.rest.controller;


import com.mywardrobe.domain.Wardrobe;
import com.mywardrobe.rest.dto.WardrobeDto;
import com.mywardrobe.service.WardrobeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WardrobeController {
    private final WardrobeService wardrobeService;

    @GetMapping("/wardrobe")
    public List<WardrobeDto> getAllBook(){
        List<WardrobeDto> wardrobeDtoList = wardrobeService.getAll()
                .stream().map(WardrobeDto::toDto).collect(Collectors.toList());
        return wardrobeDtoList;
    }
    @PostMapping("/wardrobe")
    public WardrobeDto insertWardrobe(
            @RequestParam String nameWardrobe,
            @RequestParam String nameSeason,
            @RequestParam String nameSize
    ){
        Wardrobe wardrobe = wardrobeService.insert(nameWardrobe, nameSeason, nameSize);
        return WardrobeDto.toDto(wardrobe);}
    @PutMapping("/wardrobe/{id}")
    public WardrobeDto updateWardrobe(@PathVariable int id,
                              @RequestParam String nameWardrobe,
                              @RequestParam String nameSeason,
                              @RequestParam String nameSize){
        Wardrobe wardrobe = wardrobeService.update(id, nameWardrobe, nameSeason, nameSize);
        return WardrobeDto.toDto(wardrobe);
    }
    @GetMapping("/wardrobe/{id}")
    public WardrobeDto getWardrobeId(@PathVariable int id){
        return WardrobeDto.toDto(wardrobeService.getById(id));
    }

    @DeleteMapping("/wardrobe/{id}")
    public void deleteWardrobe(@PathVariable int id){
        wardrobeService.deleteById(id);
    }





}
