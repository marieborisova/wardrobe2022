package com.mywardrobe.rest.dto;


import com.mywardrobe.domain.Comment;
import com.mywardrobe.domain.Wardrobe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private int id;
    private String content;



    public static CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getContent()

        );
    }
    public static Comment toDomainObject(CommentDto commentDto, Wardrobe wardrobe)
    {return new Comment(
            commentDto.getId(),
            commentDto.getContent(),
            wardrobe
    );}


}

