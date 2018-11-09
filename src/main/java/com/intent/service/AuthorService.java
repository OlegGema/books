package com.intent.service;

import com.intent.DTO.AuthorDTO;
import com.intent.DTO.AuthorResponse;
import com.intent.entity.Author;

import java.util.List;

public interface AuthorService
{
  void save(AuthorDTO authorDTO);
  List<AuthorResponse>findAll();
  void deleteAuthor(long id);
  void updateAuthor(long id,AuthorDTO authorDTO);
  AuthorResponse findAuthorByName(String name);
}
