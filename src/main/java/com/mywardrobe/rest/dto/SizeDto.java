package com.mywardrobe.rest.dto;


import com.mywardrobe.domain.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SizeDto {
    private int id;
    private String name;

    public static SizeDto toDto(Size size) {
        return new SizeDto(
                size.getId(),
                size.getName()
        );

    }

    public static Size toDomainObject(SizeDto sizeDto) {
        return new Size(
                sizeDto.getId(),
                sizeDto.getName());
    }
}

