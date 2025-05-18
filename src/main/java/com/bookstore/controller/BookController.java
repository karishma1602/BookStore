package com.bookstore.controller;

import com.bookstore.Entity.Book;
import com.bookstore.Entity.MyBookList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.Service.BookService;
import com.bookstore.Service.MyBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService bser;
	@Autowired
	private MyBookListService blser;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookregister";
	}
	
	@GetMapping("/available_book")
	public ModelAndView getAllBook(){
		List<Book> l=bser.getallbook();
		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("bookList");
//		mv.addObject("book", l);
		//return mv;
		return new ModelAndView("booklist","book",l);
		
	}
	  @PostMapping("/save")
	    public String addbook(@ModelAttribute Book b) {
	        bser.saveall(b);
	        return "redirect:/available_book"; 
	    }
	  
	  @GetMapping("/my_books")
	  public String getmybooks(Model m) {
		  List<Book>l=bser.getallbook();
		  m.addAttribute("book", l);
		  return "myBooks";
	  }
	  
	  @RequestMapping("/mylist/{id}")
	  public String getmylist(@PathVariable("id")int id) {
		  Book b=bser.getbook(id);
		  MyBookList mbl=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		  blser.saveMyBook(mbl);
		  return "redirect:/my_books";
	  }
	  @RequestMapping("/editBook/{id}")
	  public String editbook(@PathVariable ("id")int id,Model m) {
		 Book b= (Book) blser.getallmybook();
		 m.addAttribute("book", b);
		  return "bookedit";
	  }

}
