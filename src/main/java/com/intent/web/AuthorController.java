package com.intent.web;

import com.intent.DTO.AuthorDTO;
import com.intent.DTO.AuthorResponse;
import com.intent.entity.Author;
import com.intent.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "author",description = "author")
public class AuthorController
{
  @Autowired
  private AuthorService authorService;

  @ApiOperation(value = "author")
  @RequestMapping(value = "/author/save",method = RequestMethod.POST)
  public void saveAuthor(@RequestBody AuthorDTO author){
    authorService.save(author);
  }

  @RequestMapping(value = "/author/getAll",method = RequestMethod.GET)
  public List<AuthorResponse> findAll(){
    return authorService.findAll();
  }

  @RequestMapping(value = "/author/update/{authorId}",method = RequestMethod.PATCH)
  public void updateAuthor(@PathVariable("authorId")long id,@RequestBody AuthorDTO authorDTO){
    authorService.updateAuthor(id, authorDTO);
  }

  @RequestMapping(value = "/author/delete/{authorId}",method = RequestMethod.DELETE)
  public void deleteAuthor(@PathVariable("authorId")long id){
    authorService.deleteAuthor(id);
  }

  @RequestMapping(value = "/author/search/{name}",method = RequestMethod.GET)
  public AuthorResponse findAuthor(@PathVariable("name")String name){
    return authorService.findAuthorByName(name);
  }




}
