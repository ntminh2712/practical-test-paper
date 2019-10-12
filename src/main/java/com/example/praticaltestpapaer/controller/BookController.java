package com.example.praticaltestpapaer.controller;


import com.example.praticaltestpapaer.entity.BookDetail;
import com.example.praticaltestpapaer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class BookController {


    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model){
        List<BookDetail> books = new ArrayList<>();
        model.addAttribute("books", books);
        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String searchBook(Model model, @RequestParam("keyword") String keyword){
        List<BookDetail> books = bookRepository.searchBookByName(keyword);
        model.addAttribute("books", books);
        return "search";
    }

}
