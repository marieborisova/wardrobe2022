package com.mywardrobe.rest.controller;


import com.mywardrobe.domain.Size;
import com.mywardrobe.rest.dto.SizeDto;
import com.mywardrobe.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SizeController {

    private final SizeService sizeService;

    @PostMapping("/size")
    public SizeDto createNewSize(@RequestBody SizeDto sizeDto) {

        Size size = sizeService.insert(SizeDto.toDomainObject(sizeDto));
        return SizeDto.toDto(size);
    }

    @GetMapping("/size")
    public List<SizeDto> getAllSize() {

        return sizeService
                .getAll()
                .stream()
                .map(SizeDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/size/{id}")
    public SizeDto getGenreById(@PathVariable int id) {

        return SizeDto.toDto(sizeService.getById(id));
    }

    @GetMapping("/size/name")
    public SizeDto getSizeByName(@RequestParam String name) {

        return SizeDto.toDto(sizeService.getByName(name));
    }

    @PostMapping("/size/{id}/name")
    public SizeDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return SizeDto.toDto(
                sizeService.update(id, name)
        );
    }

    @DeleteMapping("/size/{id}")
    public void deleteSizeById(@PathVariable int id) {

        sizeService.deleteById(id);
    }

}
