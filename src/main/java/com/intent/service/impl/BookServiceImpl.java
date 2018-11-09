package com.intent.service.impl;

import com.intent.DTO.BookDTO;
import com.intent.DTO.BookResponse;
import com.intent.entity.Author;
import com.intent.entity.Book;
import com.intent.repository.AuthorRepository;
import com.intent.repository.BookRepository;
import com.intent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService
{
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public void save(BookDTO bookDTO)
  {
    Book book=new Book();
    Author author = authorRepository.findById(bookDTO.getAuthorId());
    if (author==null)
      throw new IllegalArgumentException("wrong author id");
    book.setName(bookDTO.getName());
    book.setPublished(bookDTO.getPublished());
    book.setAuthor(author);
    bookRepository.save(book);
  }

  public List<BookResponse> findAll()
  {
    List<Book>authors=bookRepository.findAll();
    List<BookResponse>authorResponses=new ArrayList<BookResponse>();
    authors.forEach(el->{
      authorResponses.add(BookResponse.builder().name(el.getName()).id(el.getId()).published(el.getPublished()).build());
    });

    return authorResponses;
  }

  @Override
  @Transactional
  public void deleteBook(long id)
  {
    bookRepository.deleteBook(id);
  }

  @Override
  @Transactional
  public void updateBook(long id, BookDTO bookDTO)
  {
    if (bookRepository.findById(id)!=null){
      Author author = authorRepository.findById(bookDTO.getAuthorId());
      if (author==null)
        throw new IllegalArgumentException("wrong author id");
      bookRepository.updateBook(id,bookDTO.getName(),bookDTO.getPublished(),author);
    }else
      throw new IllegalArgumentException("wrong book id");
  }

  @Override
  public BookResponse findBooksByName(String name)
  {
    Book book=bookRepository.findBooksByName(name);
    return BookResponse.builder().id(book.getId()).name(book.getName()).published(book.getPublished()).build();
  }
}
