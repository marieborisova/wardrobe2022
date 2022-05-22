package com.mywardrobe.rest.controller;


import com.mywardrobe.domain.Clothing;
import com.mywardrobe.rest.dto.ClothingDto;
import com.mywardrobe.service.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClothingController {
    private final ClothingService clothingService;

    @GetMapping("/clothing")
    public List<ClothingDto> getAllClothing() {
        List<ClothingDto> clothingDtoList = clothingService.getAll()
                .stream().map(ClothingDto::toDto).collect(Collectors.toList());
        return clothingDtoList;
    }

    @PostMapping("/clothing")
    public ClothingDto insertClothing(
            @RequestParam String nameClothing,
            @RequestParam String nameSeason,
            @RequestParam String nameSize,
            @RequestParam String nameSex

    ) {
        Clothing clothing = clothingService.insert(nameClothing, nameSeason, nameSize, nameSex);
        return ClothingDto.toDto(clothing);
    }

    @PutMapping("/clothing/{id}")
    public ClothingDto updateClothing(@PathVariable int id,
                                      @RequestParam String nameClothing,
                                      @RequestParam String nameSeason,
                                      @RequestParam String nameSize,
                                      @RequestParam String nameSex) {
        Clothing clothing = clothingService.update(id, nameClothing, nameSeason, nameSize, nameSex);
        return ClothingDto.toDto(clothing);
    }

    @GetMapping("/clothing/{id}")
    public ClothingDto getClothingId(@PathVariable int id) {
        return ClothingDto.toDto(clothingService.getById(id));
    }

    @DeleteMapping("/clothing/{id}")
    public void deleteClothing(@PathVariable int id) {
        clothingService.deleteById(id);
    }


}
