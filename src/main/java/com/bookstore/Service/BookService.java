package com.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Entity.Book;
import com.bookstore.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository brep;
	public void saveall(Book b) {
		brep.save(b);
	}
	
	 public List<Book> getallbook(){
		 return brep.findAll();
	 }
	 
	 public Book getbook(int id) {
		return brep.findById(id).get();
	}
	 public void deletebyid(int id) {
		brep.deleteById(id);
	}

}

