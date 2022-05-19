package com.mywardrobe.rest.dto;


import com.mywardrobe.domain.Season;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeasonDto {
    private int id;
    private String name;

    public static SeasonDto toDto(Season season) {
        return new SeasonDto(
                season.getId(),
                season.getName()
        );

    }

    public static Season toDomainObject(SeasonDto seasonDto) {
        return new Season(
                seasonDto.getId(),
                seasonDto.getName());
    }
}

