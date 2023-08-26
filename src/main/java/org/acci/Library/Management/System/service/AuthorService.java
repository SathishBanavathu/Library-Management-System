package org.acci.Library.Management.System.service;

import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.UpdateEmailRequestDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.AuthorEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.MailUpdateResponseDto;

import java.util.List;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);
    public String deleteAuthor(AuthorDeleteRequestDto authorDeleteRequestDto) throws Exception;
    public MailUpdateResponseDto updateEmail(UpdateEmailRequestDto updateEmailRequestDto) throws Exception;

    public AuthorEntityResponseDto getAuthor(int id) throws Exception;

    public List<AuthorEntityResponseDto> getAllAuthor();

    public List<AuthorEntityResponseDto> getByAge(int age);
}
