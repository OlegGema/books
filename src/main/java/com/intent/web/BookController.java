package com.intent.web;

import com.intent.DTO.BookDTO;
import com.intent.DTO.BookResponse;
import com.intent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController
{
  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/book/save",method = RequestMethod.POST)
  public void saveBook(@RequestBody BookDTO bookDTO){
    bookService.save(bookDTO);
  }

  @RequestMapping(value = "/book/getAll",method = RequestMethod.GET)
  public List<BookResponse> findAll(){
    return bookService.findAll();
  }

  @RequestMapping(value = "/book/update/{bookId}",method = RequestMethod.PATCH)
  public void updateBook(@PathVariable("bookId")long id,@RequestBody BookDTO bookDTO){
    bookService.updateBook(id, bookDTO);
  }

  @RequestMapping(value = "/book/delete/{bookId}",method = RequestMethod.DELETE)
  public void deleteBook(@PathVariable("bookId")long id){
    bookService.deleteBook(id);
  }


  @RequestMapping(value = "/book/search/{name}",method = RequestMethod.GET)
  public BookResponse findBooksByName(@PathVariable("name")String name){
    return bookService.findBooksByName(name);
  }

}
