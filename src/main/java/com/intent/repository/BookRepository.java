package com.intent.repository;

import com.intent.entity.Author;
import com.intent.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BookRepository extends JpaRepository<Book,Long>
{
  @Query("from Book a where a.id=:id")
  Book findById(@Param("id")long id);

  @Query("update Book set name=:name , published=:published,author=:author where id=:id")
  @Modifying
  void updateBook(@Param("id")long id,@Param("name")String name,@Param("published")Date published,@Param("author")Author author);

  @Query("delete from Book where id=:id")
  @Modifying
  void deleteBook(@Param("id")long id);

  @Query("delete from Book b where b.author.id=:authorId")
  @Modifying
  void deleteBookByAuthor(@Param("authorId")long authorId);

  Book findBooksByName(@Param("name")String name);
}
