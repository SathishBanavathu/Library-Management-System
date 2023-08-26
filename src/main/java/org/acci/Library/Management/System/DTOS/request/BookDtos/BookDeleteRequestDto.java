package org.acci.Library.Management.System.DTOS.request.BookDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDeleteRequestDto {

    private int id;

    private String bookName;
}
