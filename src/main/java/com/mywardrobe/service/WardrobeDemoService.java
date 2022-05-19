package com.mywardrobe.service;

import com.mywardrobe.domain.Comment;
import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Size;
import com.mywardrobe.domain.Wardrobe;
import com.mywardrobe.repository.CommentRepository;
import com.mywardrobe.repository.WardrobeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class WardrobeDemoService {
    private final SeasonService seasonService;
    private final SizeService sizeService;

    private final CommentRepository commentRepository;

    private final WardrobeService wardrobeService;

    private final WardrobeRepository wardrobeRepository;
    public void seasonDemo(){
        List<Season> seasonList = seasonService.getAll();
        System.out.println("+++++++++++");
        for (Season season:seasonList){
            System.out.println(season);
        }
        System.out.println("+++++++++++");

        seasonService.update(1, "СуперЗима");
        seasonList = seasonService.getAll();
        System.out.println("+++++++++++");
        for (Season season1:seasonList){
            System.out.println(season1);
        }
        System.out.println("+++++++++++");



    }
    @Transactional
    public void wardrobeDemo() {
        List<Wardrobe> wardrobeList = wardrobeService.getAll();

        for (Wardrobe wardrobe : wardrobeList) {
            System.out.println(wardrobe.getName() + ":");
            System.out.println(wardrobe.getSeason().getName() + "," + wardrobe.getSize().getName());
            List<Comment> commentList = wardrobe.getCommentList();
            for (Comment comment : commentList) {
                System.out.println(comment.getContent());
            }
        }
        wardrobeService.insert("платье", "лето",
                "m");
        wardrobeList = wardrobeService.getAll();
        for (Wardrobe wardrobe : wardrobeList) {
            System.out.println(wardrobe.getName() + ":");
            System.out.println(wardrobe.getSeason().getName() + "," + wardrobe.getSize().getName());
            List<Comment> commentList = wardrobe.getCommentList();
            if (commentList != null) {
                for (Comment comment : commentList) {
                    System.out.println(comment.getContent());
                }
            }
        }
    }
    @Transactional
    public void commentDemo(){
        commentRepository.updateCommentById(1, "ОЧЕНЬ");

        List<Comment> commentList =  commentRepository.findAll();
        for(Comment comment : commentList){
            //System.out.println(comment.getBook().getName() + ":");
            System.out.println(comment.getId() + " - " + comment.getContent());
        }
        commentList = commentRepository.findByBookId(2);
        for(Comment comment : commentList){
            //System.out.println(comment.getBook().getName() + ":");
            System.out.println(comment.getId() + " - " + comment.getContent());
        }

    }

}
