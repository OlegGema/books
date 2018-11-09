package com.intent.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookDTO
{
  private long authorId;
  private String name;
  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
  private Date published;

}
