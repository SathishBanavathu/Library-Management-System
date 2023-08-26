package org.acci.Library.Management.System.DTOS.response.BookDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acci.Library.Management.System.enums.Genre;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class BookPriceResponseDto {

    private int id;

    private String title;

    private Genre genre;

    private int price;

    private int pages;

    private String authorName;

    private boolean issueStatus;
}
