package com.intent.service.impl;

import com.intent.DTO.AuthorDTO;
import com.intent.DTO.AuthorResponse;
import com.intent.entity.Author;
import com.intent.repository.AuthorRepository;
import com.intent.repository.BookRepository;
import com.intent.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService
{
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;

  @Override
  public void save(AuthorDTO authorDTO)
  {
    Author author=new Author();
    author.setBorn(authorDTO.getBorn());
    author.setName(authorDTO.getName());
    authorRepository.save(author);
  }

  @Override
  public List<AuthorResponse> findAll()
  {
    List<Author>authors=authorRepository.findAll();
    List<AuthorResponse>authorResponses=new ArrayList<AuthorResponse>();
    authors.forEach(el->{
      authorResponses.add(AuthorResponse.builder().born(el.getBorn()).name(el.getName()).id(el.getId()).build());
    });

    return authorResponses;
  }

  @Override
  @Transactional
  public void deleteAuthor(long id)
  {
    Author author = authorRepository.findById(id);
    if (author==null)
      throw new IllegalArgumentException("wrong author id");
    bookRepository.deleteBookByAuthor(id);
    authorRepository.deleteAuthor(id);
  }

  @Override
  @Transactional
  public void updateAuthor(long id, AuthorDTO authorDTO)
  {
    if (authorRepository.findById(id)!=null){
      authorRepository.updateAuthor(id,authorDTO.getName(),authorDTO.getBorn());
    }else
      throw new IllegalArgumentException("wrong author id");
  }

  @Override
  public AuthorResponse findAuthorByName(String name)
  {
    Author author = authorRepository.findAuthorByName(name);
    return AuthorResponse.builder().id(author.getId()).name(author.getName()).born(author.getBorn()).build();
  }
}
