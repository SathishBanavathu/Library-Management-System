package org.acci.Library.Management.System.service.impl;

import org.acci.Library.Management.System.DTOS.request.BookDtos.BookDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookExpensiveRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookPriceUpdateRequestDto;
import org.acci.Library.Management.System.DTOS.request.BookDtos.BookRequestDto;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.Transformer.BookTransformer;
import org.acci.Library.Management.System.entity.Author;
import org.acci.Library.Management.System.entity.Book;
import org.acci.Library.Management.System.exceptions.BookNotFountException;
import org.acci.Library.Management.System.repository.AuthorRepository;
import org.acci.Library.Management.System.repository.BookRepository;
import org.acci.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception
    {
        try{
            Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

            Book book = BookTransformer.bookRequestDtoToBookEntity(bookRequestDto);

            author.getBooks().add(book);
            book.setAuthor(author);
            authorRepository.save(author);
            return "Book Added Successful";
        }
        catch (Exception e)
        {
            throw new Exception("Invalid author id ");
        }

    }

    @Override
    public List<BookResponseDto> getByGenre(String genre) throws Exception
    {
        List<BookResponseDto> allBooks = new ArrayList<>();
       try{
           List<Book> books =  bookRepository.getByGenre(genre);
           for (Book book:books) {

               BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);

               allBooks.add(bookResponseDto);
           }
           return allBooks;
       }
       catch(Exception e){
           throw new Exception("Genre Is Not Found");
       }
    }

    @Override
    public List<BookResponseDto> getBookByPrice(int price)
    {
        List<BookResponseDto> allBooks = new ArrayList<>();
        for (Book book :bookRepository.getBookByPrice(price))
        {
          BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);
                allBooks.add(bookResponseDto);
        }
        return allBooks;
    }

    @Override
    public List<BookResponseDto> getExpensiveBooks(BookExpensiveRequestDto bookExpensiveRequestDto)
    {

        List<BookResponseDto> allBooks = new ArrayList<>();

        List<Book> books = bookRepository.getExpensiveBooks(bookExpensiveRequestDto.getRange());

        for (Book book:books) {
            BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);
            allBooks.add(bookResponseDto);
        }
        return allBooks;

    }

    @Override
    public List<BookResponseDto> getCheapBooks(BookExpensiveRequestDto bookExpensiveRequestDto) {

        List<BookResponseDto> allBooks = new ArrayList<>();

        List<Book> books = bookRepository.getCheapBooks(bookExpensiveRequestDto.getRange());

        for (Book book:books) {
            BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);
            allBooks.add(bookResponseDto);
        }
        return allBooks;
    }

    @Override
    public String updatePrice(BookPriceUpdateRequestDto bookPriceUpdateRequestDto) throws BookNotFountException
    {

        try{
            Book book = bookRepository.findById(bookPriceUpdateRequestDto.getId()).get();
           if(book.getTitle().equalsIgnoreCase(bookPriceUpdateRequestDto.getBookName()))
           {
               book.setPrice(bookPriceUpdateRequestDto.getNewPrice());
               return "Price Updated Successfully "+bookPriceUpdateRequestDto.getBookName();
           }
           else{
               return "Book Name Doesn't Match with Id";
           }
        }
        catch (Exception e){
            throw new BookNotFountException("Invalid Book Id");
        }
    }

    @Override
    public String deleteBook(BookDeleteRequestDto bookDeleteRequestDto) throws BookNotFountException
    {
        try{
            Book book = bookRepository.findById(bookDeleteRequestDto.getId()).get();
           if(book.getTitle().equalsIgnoreCase(bookDeleteRequestDto.getBookName()))
           {
               bookRepository.deleteById(book.getId());
               return "Book Id is : "+book.getId()+" and Book Name is : "+book.getTitle()+" Deleted Successfully.";
           }
           else {
               return "Book Name Doesn't match with Book Id.";
           }
        }
        catch(Exception e)
        {
            throw new BookNotFountException("Invalid Book Id.");
        }
    }
}
