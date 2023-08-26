package org.acci.Library.Management.System.DTOS.response.TransactionDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acci.Library.Management.System.enums.TransactionStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {

    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
