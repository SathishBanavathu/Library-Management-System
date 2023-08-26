package org.acci.Library.Management.System.service;

import org.acci.Library.Management.System.DTOS.request.TransactionDtos.IssueBookRequestDto;
import org.acci.Library.Management.System.DTOS.request.TransactionDtos.RecoverBookRequestDto;
import org.acci.Library.Management.System.DTOS.response.TransactionDtos.IssueBookResponseDto;
import org.acci.Library.Management.System.exceptions.BookNotFountException;
import org.acci.Library.Management.System.exceptions.CardNotFoundException;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
    public String recoverBook(RecoverBookRequestDto recoverBookRequestDto) throws Exception;
}
