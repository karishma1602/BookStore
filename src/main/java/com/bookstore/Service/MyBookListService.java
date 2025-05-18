package com.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Entity.MyBookList;
import com.bookstore.Repository.MyBookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MyBookRepository mbr;
	
	public void saveMyBook(MyBookList bl) {
		mbr.save(bl);
	}
	
	public List<MyBookList> getallmybook() {
		return getallmybook();
	}
	
	public void deletebyid(int id) {
		mbr.deleteById(id);
	}
	
}
