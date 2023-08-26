package org.acci.Library.Management.System.DTOS.response.BookDtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;
import org.acci.Library.Management.System.enums.Genre;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookResponseDto {

    private int id;

    private String title;

    private Genre genre;

    private int price;

    private int pages;

    private String authorName;

    private boolean issueStatus;
}
