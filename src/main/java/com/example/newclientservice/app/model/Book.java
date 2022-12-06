package com.example.newclientservice.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "gallerydb")
public class Book {
   @Id
   private String id;

   @NotBlank
   @Size(max = 10)
   private String title;

   private String description;
   private String imageLink;
}
