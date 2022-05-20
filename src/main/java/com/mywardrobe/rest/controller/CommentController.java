package com.mywardrobe.rest.controller;


import com.mywardrobe.domain.Comment;
import com.mywardrobe.rest.dto.CommentDto;
import com.mywardrobe.service.CommentService;
import com.mywardrobe.service.WardrobeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final WardrobeService wardrobeService;

    @PostMapping("/comment")
    public CommentDto createNewComment(
            @RequestParam String content,
            @RequestParam int wardrobeId
    ) {
        Comment comment = Comment.builder()
                .content(content)
                .wardrobe(wardrobeService.getById(wardrobeId))
                .build();
        Comment comment1 = commentService.insert(comment);

        return CommentDto.toDto(comment1);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments() {

        return commentService
                .getAll()
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment/{id}/content")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String content
    ) {

        commentService.update(id, content);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteCommentById(@PathVariable int id) {

        commentService.deleteById(id);
    }

    @GetMapping("/wardrobe/{id}/comment")
    public List<CommentDto> getCommentsByWardrobeId(@PathVariable int id) {

        return commentService
                .getByWardrobeId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}