package org.acci.Library.Management.System.Transformer;

import org.acci.Library.Management.System.DTOS.request.BookDtos.BookRequestDto;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.entity.Book;

public class BookTransformer {

    public static Book bookRequestDtoToBookEntity (BookRequestDto bookRequestDto)
    {
        return  Book.builder()
                .title(bookRequestDto.getTitle())
                .genre(bookRequestDto.getGenre())
                .pages(bookRequestDto.getPages())
                .price(bookRequestDto.getPrice())
                .build();
    }


    public static BookResponseDto bookEntityToBookResponseDto (Book book)
    {
        return BookResponseDto.builder()
                .genre(book.getGenre())
                .id(book.getId())
                .issueStatus(book.isIssueStatus())
                .pages(book.getPages())
                .price(book.getPrice())
                .title(book.getTitle())
                .authorName(book.getAuthor().getName())
                .build();
    }

}
