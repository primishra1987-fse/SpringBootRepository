package com.example.springbootrestProgram.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestProgram.dao.BooksDao;
import com.example.springbootrestProgram.entity.Books;


@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksDao booksDao;
	
	
			@RequestMapping(value="/bookList", method=RequestMethod.GET, 
			produces = { "application/json", "application/xml" })
			public ResponseEntity<List<Books>> getBookListDetails(){
				List<Books> bookList ;
				
				bookList = booksDao.findAll();
				
				
				 return ResponseEntity.ok()
					        .header("Custom-Header", "foo")
					        .body(bookList);
				
			}
			
			@RequestMapping(value="/bookById/{id}", method=RequestMethod.GET, 
					produces = { "application/json", "application/xml" })
					public ResponseEntity<Books> getBookDetails(@PathVariable("id") Long id){
						Optional<Books> book ;
						
						book = booksDao.findById(id);
						
						if ( book !=null) {
						 return ResponseEntity.ok()
							        .header("Custom-Header", "foo")
							        .body(book.get());
						}
						else {
							return ResponseEntity.notFound()
									.header("Custom-Header", "IDNotFound").build();
							
							        
							
						}
						
					}
			
			
			@RequestMapping(value="/putjson", method=RequestMethod.PUT, 
					produces="application/xml", consumes={ "application/json", "application/xml" })
					public Books putEmployeeDetails123(@RequestBody @Valid Books book){
				
				System.out.println("Alok1");
				Optional<Books> bookFromReq ;
				bookFromReq = booksDao.findById(book.getBookId());
				try {
				
				if (bookFromReq != null) {
					System.out.println("test");
				bookFromReq.get().setBookId(book.getBookId());
				bookFromReq.get().setTitle(book.getTitle());
				bookFromReq.get().setPrice(book.getPrice());
				bookFromReq.get().setPublishDate(book.getPublishDate());
				bookFromReq.get().setVolume(book.getVolume());
				bookFromReq.get().setSubjectID(book.getSubjectID());
				
				booksDao.save(bookFromReq.get());
				
				}
				}
				catch (Exception e){
					e.getMessage();
					return null;
				}
				return bookFromReq.get();
				
				
			}
			
			
			@RequestMapping(value="/deletejson", method=RequestMethod.DELETE, 
					 consumes={ "application/json", "application/xml" })
					public void deleteEmployeeDetails123(@RequestBody @Valid Books book){
					
					booksDao.deleteBookByID(book.getBookId());
					
			}
				
			@RequestMapping(value="/bookjson", method=RequestMethod.POST, 
					produces="application/xml", consumes={ "application/json", "application/xml" })
					public Books getEmployeeDetails123(@RequestBody @Valid Books book){
				
				if (book != null && book.getBookId() != 0){
				System.out.println("Alok1");
				Books insertBook = new Books ();
				insertBook.setBookId(book.getBookId());
				insertBook.setTitle(book.getTitle());
				insertBook.setPrice(book.getPrice());
				insertBook.setPublishDate(book.getPublishDate());
				insertBook.setVolume(book.getVolume());
				insertBook.setSubjectID(book.getSubjectID());
				
				booksDao.save(insertBook);
				
				
				return insertBook;
				}
				else {
					return null;
				}
			}
	

	
}
