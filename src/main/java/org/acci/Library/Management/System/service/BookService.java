package org.acci.Library.Management.System.service;

import org.acci.Library.Management.System.DTOS.request.BookDtos.BookDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookExpensiveRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookPriceUpdateRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookRequestDto;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.exceptions.BookNotFountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    public String addBook(BookRequestDto bookRequestDto) throws Exception;

    public List<BookResponseDto> getByGenre(String genre) throws Exception;

    public List<BookResponseDto> getBookByPrice(int price);

    public List<BookResponseDto> getExpensiveBooks( BookExpensiveRequestDto bookExpensiveRequestDto);

    public List<BookResponseDto> getCheapBooks(BookExpensiveRequestDto bookExpensiveRequestDto);

    public String updatePrice(BookPriceUpdateRequestDto bookPriceUpdateRequestDto) throws BookNotFountException;

    public String deleteBook(BookDeleteRequestDto bookDeleteRequestDto) throws BookNotFountException;
}
