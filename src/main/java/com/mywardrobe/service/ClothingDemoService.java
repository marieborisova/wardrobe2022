package com.mywardrobe.service;


import com.mywardrobe.domain.Season;
import com.mywardrobe.domain.Clothing;

import com.mywardrobe.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClothingDemoService {
    private final SeasonService seasonService;
    private final SizeService sizeService;



    private final ClothingService clothingService;

    private final ClothingRepository clothingRepository;
    public void seasonDemo(){
        List<Season> seasonList = seasonService.getAll();
        System.out.println("+++++++++++");
        for (Season season:seasonList){
            System.out.println(season);
        }
        System.out.println("+++++++++++");
//
//        seasonService.update(1, "СуперЗима");
//        seasonList = seasonService.getAll();
//        System.out.println("+++++++++++");
//        for (Season season1:seasonList){
//            System.out.println(season1);
//        }
//        System.out.println("+++++++++++");



    }
    @Transactional
    public void clothingDemo() {
        List<Clothing> clothingList = clothingService.getAll();

        for (Clothing clothing : clothingList) {
            System.out.println(clothing.getName() + ":");
            System.out.println(clothing.getSeason().getName() + "," + clothing.getSize().getName()+ "," + clothing.getSex().getName());
//            List<Comment> commentList = wardrobe.getCommentList();
//            for (Comment comment : commentList) {
//                System.out.println(comment.getContent());
   //         }
        }
        clothingService.insert("платье", "Лето",
                "M", "F");
        clothingList = clothingService.getAll();
        for (Clothing clothing : clothingList) {
            System.out.println(clothing.getName() + ":");
            System.out.println(clothing.getSeason().getName() + "," + clothing.getSize().getName()+ "," + clothing.getSex().getName());
//            List<Comment> commentList = wardrobe.getCommentList();
//            if (commentList != null) {
//                for (Comment comment : commentList) {
//                    System.out.println(comment.getContent());
//                }
//            }
        }
    }


}
