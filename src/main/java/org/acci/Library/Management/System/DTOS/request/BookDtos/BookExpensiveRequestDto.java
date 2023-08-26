package org.acci.Library.Management.System.DTOS.request.BookDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookExpensiveRequestDto {
    int range;
}
