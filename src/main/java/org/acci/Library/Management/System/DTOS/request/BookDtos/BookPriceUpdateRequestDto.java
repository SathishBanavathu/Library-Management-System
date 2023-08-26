package org.acci.Library.Management.System.DTOS.request.BookDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookPriceUpdateRequestDto {

    private int id;

    private String bookName;

    private int newPrice;
}
