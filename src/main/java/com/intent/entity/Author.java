package com.intent.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Author extends PersistableEntity
{
  private String name;

  @Temporal(TemporalType.TIMESTAMP)
  private Date born;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "author")
  private List<Book>books;

  public Author()
  {
  }
}
