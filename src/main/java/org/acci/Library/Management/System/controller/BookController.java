package org.acci.Library.Management.System.controller;

import org.acci.Library.Management.System.DTOS.request.BookDtos.BookDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookExpensiveRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookPriceUpdateRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookRequestDto;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.exceptions.BookNotFountException;
import org.acci.Library.Management.System.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception
    {
        String msg = bookServiceImpl.addBook(bookRequestDto);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<List<BookResponseDto>> getByGenre(@RequestParam("genre")String genre) throws Exception
    {
        return new ResponseEntity<>(bookServiceImpl.getByGenre(genre),HttpStatus.FOUND);
    }

    @GetMapping("/getByPrice")
    public ResponseEntity<List<BookResponseDto>> getBookByPrice(@RequestParam("price") int price)
    {
        return new ResponseEntity<>(bookServiceImpl.getBookByPrice(price),HttpStatus.FOUND);
    }

    @GetMapping("/expensive")
    public ResponseEntity<List<BookResponseDto>> getExpensiveBooks(@RequestBody BookExpensiveRequestDto bookExpensiveRequestDto)
    {
        return new ResponseEntity<>(bookServiceImpl.getExpensiveBooks(bookExpensiveRequestDto),HttpStatus.FOUND);
    }


    @GetMapping("/cheap")
    public ResponseEntity<List<BookResponseDto>> getCheapBooks(@RequestBody BookExpensiveRequestDto bookExpensiveRequestDto)
    {
        return new ResponseEntity<>(bookServiceImpl.getCheapBooks(bookExpensiveRequestDto),HttpStatus.FOUND);
    }
    @PutMapping("/updatePrice")
    public ResponseEntity<String> updatePrice(@RequestBody BookPriceUpdateRequestDto bookPriceUpdateRequestDto) throws BookNotFountException
    {
        return new ResponseEntity<>(bookServiceImpl.updatePrice(bookPriceUpdateRequestDto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestBody BookDeleteRequestDto bookDeleteRequestDto) throws BookNotFountException {
        return new ResponseEntity<>(bookServiceImpl.deleteBook(bookDeleteRequestDto),HttpStatus.OK);
    }
}
