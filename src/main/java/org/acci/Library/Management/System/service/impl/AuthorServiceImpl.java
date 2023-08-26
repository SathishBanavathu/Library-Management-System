package org.acci.Library.Management.System.service.impl;

import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.UpdateEmailRequestDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.AuthorEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.MailUpdateResponseDto;
import org.acci.Library.Management.System.DTOS.response.BookDtos.BookResponseDto;
import org.acci.Library.Management.System.Transformer.AuthorTransformer;
import org.acci.Library.Management.System.Transformer.BookTransformer;
import org.acci.Library.Management.System.entity.Author;
import org.acci.Library.Management.System.entity.Book;
import org.acci.Library.Management.System.repository.AuthorRepository;
import org.acci.Library.Management.System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author = AuthorTransformer.authorRequestToAuthor(authorRequestDto);
        authorRepository.save(author);
        return ""+author.getName()+" details added successful";
    }
    @Override
    public String deleteAuthor(AuthorDeleteRequestDto authorDeleteRequestDto) throws Exception
    {
          try{
              Author author = authorRepository.findById(authorDeleteRequestDto.getId()).get();
            if(author.getName().equalsIgnoreCase(authorDeleteRequestDto.getName()))
            {
                authorRepository.deleteById(author.getId());
                return "Author Deleted Successfully";
            }
            else
            {
                return "Id Doesn't Match With Name";
            }
        }
        catch (Exception e)
        {
            throw new Exception("Invalid Author Id");
        }
    }

    @Override
    public MailUpdateResponseDto updateEmail(UpdateEmailRequestDto updateEmailRequestDto) throws Exception
    {
        MailUpdateResponseDto mailUpdateResponseDto=AuthorTransformer.mailUpdateRequestDtoTomailUpdateResponseDto(updateEmailRequestDto);
        try{
            Author author = authorRepository.findById(updateEmailRequestDto.getId()).get();
            if(author.getName().equalsIgnoreCase(updateEmailRequestDto.getName()))
            {
                author.setEmail(updateEmailRequestDto.getMail());
                authorRepository.save(author);

                mailUpdateResponseDto.setMessage("Email Updated Successfully");
                return mailUpdateResponseDto;
            }
            else
            {
                mailUpdateResponseDto.setMessage("Id and name doesn't match");
                return mailUpdateResponseDto;
            }
        }
        catch (Exception e)
        {
            throw new Exception("Invalid Author Id ");
        }
    }

    @Override
    public AuthorEntityResponseDto getAuthor(int id) throws Exception
    {
        try{
            Author author=authorRepository.findById(id).get();
            AuthorEntityResponseDto authorEntityResponseDto = AuthorTransformer.authorEntityToAuthorEntityResponseDto(author);

            List<BookResponseDto> allBooks = new ArrayList<>();

            for (Book book : author.getBooks()) {
                BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);

                allBooks.add(bookResponseDto);
            }
            authorEntityResponseDto.setBookResponseDto(allBooks);

            return authorEntityResponseDto;
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Author Id");
        }
    }

    @Override
    public List<AuthorEntityResponseDto> getAllAuthor()
    {
        List<AuthorEntityResponseDto> allAuthors = new ArrayList<>();
        for (Author author : authorRepository.findAll()) {
            AuthorEntityResponseDto authorEntityResponseDto = AuthorTransformer.authorEntityToAuthorEntityResponseDto(author);

            List<BookResponseDto> allBooks = new ArrayList<>();

            for (Book book:author.getBooks()) {
                BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);

                allBooks.add(bookResponseDto);
            }
            authorEntityResponseDto.setBookResponseDto(allBooks);
            allAuthors.add(authorEntityResponseDto);
        }
        return allAuthors;
    }

    @Override
    public List<AuthorEntityResponseDto> getByAge( int age)
    {
        List<AuthorEntityResponseDto> aboveAgeAuthors = new ArrayList<>();
        List<Author> authors = authorRepository.getByAge(age);
        if(authors!=null)
        {
            for (Author author:authors) {

                AuthorEntityResponseDto authorEntityResponseDto =AuthorTransformer.authorEntityToAuthorEntityResponseDto(author);

                List<BookResponseDto> allBooks = new ArrayList<>();

                for (Book book : author.getBooks()) {

                    BookResponseDto bookResponseDto = BookTransformer.bookEntityToBookResponseDto(book);

                    allBooks.add(bookResponseDto);
                }
                authorEntityResponseDto.setBookResponseDto(allBooks);
                aboveAgeAuthors.add(authorEntityResponseDto);
            }
        }
        return aboveAgeAuthors;
    }


}
