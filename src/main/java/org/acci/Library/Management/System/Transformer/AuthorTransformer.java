package org.acci.Library.Management.System.Transformer;

import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.UpdateEmailRequestDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.AuthorEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.MailUpdateResponseDto;
import org.acci.Library.Management.System.entity.Author;

public class AuthorTransformer {
    public static Author authorRequestToAuthor(AuthorRequestDto authorRequestDto)
    {
        //It's a one type of way to create object.
        //To create we have to declare @Builder annotation on top of specific class.
       return  Author.builder().name(authorRequestDto.getName())
                               .age(authorRequestDto.getAge())
                               .email(authorRequestDto.getEmail())
                               .build();
    }


    public static MailUpdateResponseDto mailUpdateRequestDtoTomailUpdateResponseDto (UpdateEmailRequestDto updateEmailRequestDto)
    {
       return MailUpdateResponseDto.builder().name(updateEmailRequestDto.getName())
                .mail(updateEmailRequestDto.getMail())
                .build();
    }


    public static AuthorEntityResponseDto authorEntityToAuthorEntityResponseDto (Author author)
    {
        return AuthorEntityResponseDto.builder()
                .name(author.getName())
                .id(author.getId())
                .age(author.getAge())
                .email(author.getEmail())
                .build();
    }
}
