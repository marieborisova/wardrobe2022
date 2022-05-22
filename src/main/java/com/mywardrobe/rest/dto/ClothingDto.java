package com.mywardrobe.rest.dto;


import com.mywardrobe.domain.Clothing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClothingDto {
    private int id;
    private String name;
    private SeasonDto seasonDto;
    private SizeDto sizeDto;
    private SexDto sexDto;


    public static ClothingDto toDto(Clothing clothing) {

        return new ClothingDto(
                clothing.getId(),
                clothing.getName(),
                SeasonDto.toDto(clothing.getSeason()),
                SizeDto.toDto(clothing.getSize()),
                SexDto.toDto(clothing.getSex())

        );
    }
}

