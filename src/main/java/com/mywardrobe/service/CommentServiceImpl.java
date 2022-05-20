package com.mywardrobe.service;

import com.mywardrobe.domain.Comment;
import com.mywardrobe.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    @Override
    public Comment insert(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByWardrobeId(int wardrobeId) {
        return commentRepository.findByWardrobeId(wardrobeId);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);

    }

    @Override
    public Comment update(int id, String content) {
        return commentRepository.save(Comment.builder()
                .id(id)
                .content(content)
                .build());

    }
}