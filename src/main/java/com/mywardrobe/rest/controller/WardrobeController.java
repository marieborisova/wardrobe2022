package com.mywardrobe.rest.controller;


import com.mywardrobe.service.WardrobeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WardrobeController {
    private final WardrobeService wardrobeService;

    @GetMapping("/book")
    public List<WardrobeDto> getAllBook(){
        List<WardrobeDto> bookDtoList = bookService.getAll().stream().map(BookDto::toDto).collect(Collectors.toList());
        return bookDtoList;
    }
    @PostMapping("/book")
    public BookDto insertBook(
            @RequestParam String nameBook,
            @RequestParam String nameAuthor,
            @RequestParam String nameGenre
    ){
        Book book = bookService.insert(nameBook, nameAuthor, nameGenre);
        return BookDto.toDto(book);}
    @PutMapping("/book/{id}")
    public BookDto updateBook(@PathVariable int id,
                              @RequestParam String nameBook,
                              @RequestParam String nameAuthor,
                              @RequestParam String nameGenre){
        Book book = bookService.update(id, nameBook, nameAuthor, nameGenre);
        return BookDto.toDto(book);
    }
    @GetMapping("/book/{id}")
    public BookDto getBookId(@PathVariable int id){
        return BookDto.toDto(bookService.getById(id));
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteById(id);
    }





}
