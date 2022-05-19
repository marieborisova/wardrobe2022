package com.mywardrobe.rest.dto;


import com.mywardrobe.domain.Wardrobe;
import liquibase.pro.packaged.W;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WardrobeDto {
    private int id;
    private String name;
    private SeasonDto seasonDto;
    private SizeDto sizeDto;
    private List<CommentDto> commentDtoList;

    public static WardrobeDto toDto(Wardrobe wardrobe){
        List<CommentDto> commentDtoList1 = new ArrayList<>();
        if(wardrobe.getCommentList() != null){
            commentDtoList1 = wardrobe.getCommentList()
                    .stream()
                    .map(CommentDto::toDto)
                    .collect(Collectors.toList());
        }
        else{
            commentDtoList1 = new ArrayList<>();
        }
        return new WardrobeDto(
                wardrobe.getId(),
                wardrobe.getName(),
                SeasonDto.toDto(wardrobe.getSeason()),
                SizeDto.toDto(wardrobe.getSize()),
                commentDtoList1

        );
    }
}

