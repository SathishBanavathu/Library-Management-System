package org.acci.Library.Management.System.DTOS.response.AuthorDtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.entity.Book;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorEntityResponseDto {
    private int id;

    private String name;

    private int age;

    private  String email;

 List <BookResponseDto> bookResponseDto;
}
