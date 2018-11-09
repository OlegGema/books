package com.intent.service;

import com.intent.DTO.BookDTO;
import com.intent.DTO.BookResponse;
import com.intent.entity.Book;

import java.util.List;

public interface BookService
{
  void save(BookDTO bookDTO);
  List<BookResponse>findAll();
  void deleteBook(long id);
  void updateBook(long id,BookDTO bookDTO);
  BookResponse findBooksByName(String name);
}
