package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.Service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService mbs;
	
	@RequestMapping("deleteMyist/{id}")
	public String deleteMyist(@PathVariable("id") int id) {
		mbs.deletebyid(id);
		return "redirect:/my_books";
	}
	
}
