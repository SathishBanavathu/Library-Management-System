package org.acci.Library.Management.System.controller;

import lombok.Getter;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorDeleteRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.AuthorRequestDto;
import org.acci.Library.Management.System.DTOS.request.AuthorDtos.UpdateEmailRequestDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.AuthorEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.AuthorDtos.MailUpdateResponseDto;
import org.acci.Library.Management.System.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorServiceimpl;
    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorRequestDto authorRequestDto)

    {
        String msg = authorServiceimpl.addAuthor(authorRequestDto);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAuthor( @RequestBody AuthorDeleteRequestDto authorDeleteRequestDto) throws Exception

    {
        return new ResponseEntity<>(authorServiceimpl.deleteAuthor(authorDeleteRequestDto),HttpStatus.OK);
    }

    @PutMapping("/updateEmail")
    public ResponseEntity<MailUpdateResponseDto> updateEmail(@RequestBody UpdateEmailRequestDto updateEmailRequestDto) throws Exception

    {
        return new ResponseEntity<>(authorServiceimpl.updateEmail(updateEmailRequestDto),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<AuthorEntityResponseDto> getAuthor(@RequestParam("id") int id) throws Exception
    {
       return new ResponseEntity<>(authorServiceimpl.getAuthor(id),HttpStatus.FOUND);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorEntityResponseDto>> getAllAuthor()
    {
        return new ResponseEntity<>(authorServiceimpl.getAllAuthor(),HttpStatus.FOUND);
    }

    @GetMapping("/getByAge")
    public  ResponseEntity<List<AuthorEntityResponseDto>> getByAge(@RequestParam("age") int age)
    {
          return  new ResponseEntity<>(authorServiceimpl.getByAge(age),HttpStatus.FOUND);
    }
}
