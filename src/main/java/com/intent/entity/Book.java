package com.intent.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Book extends PersistableEntity
{
  private String name;

  @Temporal(TemporalType.TIMESTAMP)
  private Date published;

  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
  private Author author;

  public Book()
  {
  }
}
