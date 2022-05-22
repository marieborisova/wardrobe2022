package com.mywardrobe.rest.dto;

import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SexDto {
    private int id;
    private String name;

    public static SexDto toDto(Sex sex) {
        return new SexDto(
                sex.getId(),
                sex.getName()
        );

    }

    public static Sex toDomainObject(SexDto sexDto) {
        return new Sex(
                sexDto.getId(),
                sexDto.getName());
    }
}


