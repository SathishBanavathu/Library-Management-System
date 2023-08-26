package org.acci.Library.Management.System.DTOS.request.BookDtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acci.Library.Management.System.enums.Genre;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookRequestDto {
    private String title;

    private Genre genre;

    private int price;

    private int pages;

    private int authorId;
}
