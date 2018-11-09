package com.intent.repository;

import com.intent.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AuthorRepository extends JpaRepository<Author,Long>
{
  @Query("from Author a where a.id=:id")
  Author findById(@Param("id")long id);

  @Query("update Author set name=:name , born=:born where id=:id")
  @Modifying
  void updateAuthor(@Param("id")long id,@Param("name")String name,@Param("born")Date born);

  @Query("delete from Author where id=:id")
  @Modifying
  void deleteAuthor(@Param("id")long id);

//  @Query("delete from Author where id=:id")
  Author findAuthorByName(@Param("name")String name);
}
