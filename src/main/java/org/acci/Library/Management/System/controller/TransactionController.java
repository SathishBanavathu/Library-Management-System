package org.acci.Library.Management.System.controller;

import org.acci.Library.Management.System.DTOS.request.TransactionDtos.IssueBookRequestDto;
import org.acci.Library.Management.System.DTOS.request.TransactionDtos.RecoverBookRequestDto;
import org.acci.Library.Management.System.DTOS.response.TransactionDtos.IssueBookResponseDto;
import org.acci.Library.Management.System.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionServiceImpl;
    @PostMapping("/issue")
    public ResponseEntity<IssueBookResponseDto> issueBook (@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception

    {
        return new ResponseEntity<>(transactionServiceImpl.issueBook(issueBookRequestDto), HttpStatus.OK);
    }

    @PostMapping("/recover")
    public ResponseEntity<String> recoverBook(@RequestBody RecoverBookRequestDto recoverBookRequestDto) throws Exception
    {
        return new ResponseEntity<>(transactionServiceImpl.recoverBook(recoverBookRequestDto),HttpStatus.OK);
    }
}
