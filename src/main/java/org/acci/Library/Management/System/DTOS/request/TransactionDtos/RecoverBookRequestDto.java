package org.acci.Library.Management.System.DTOS.request.TransactionDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RecoverBookRequestDto {

    private int bookId;

    private int cardId;

}
