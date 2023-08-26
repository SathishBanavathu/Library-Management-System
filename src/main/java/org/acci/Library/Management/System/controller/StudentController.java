package org.acci.Library.Management.System.controller;

import org.acci.Library.Management.System.DTOS.request.StudentDtos.*;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentMailUpdateResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.UpdateResponse;
import org.acci.Library.Management.System.enums.Branch;
import org.acci.Library.Management.System.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.rmi.StubNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
       String msg =studentServiceImpl.addStudent(studentRequestDto);
       return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestBody StudentDeleteRequestDto studentDeleteRequestDto) throws Exception
    {

        return  new ResponseEntity<>(studentServiceImpl.deleteStudent(studentDeleteRequestDto),HttpStatus.OK);
    }

    @PutMapping("/updateBranch")
    public ResponseEntity<UpdateResponse> updateBranch(@RequestBody UpdateBranch updateBranch) throws Exception
    {
        return new ResponseEntity<>(studentServiceImpl.updateBranch(updateBranch),HttpStatus.OK);
    }

    @PutMapping("/updateEmail")
    public ResponseEntity<StudentMailUpdateResponseDto> updateEmail(@RequestBody StudentMailUpdateRequestDto studentMailUpdateRequestDto) throws Exception
    {
        return new ResponseEntity<>(studentServiceImpl.updateEmail(studentMailUpdateRequestDto),HttpStatus.OK);
    }

    @GetMapping("getById")
    public ResponseEntity<StudentEntityResponseDto> getStudentById(@RequestBody StudentEntityRequestDto studentEntityRequestDto) throws  Exception
    {
        return new ResponseEntity<>(studentServiceImpl.getStudentById(studentEntityRequestDto),HttpStatus.FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentEntityResponseDto>> getAllStudents()
    {
       return new ResponseEntity<>(studentServiceImpl.getAllStudents(),HttpStatus.FOUND);
    }

    @GetMapping("/getByBranch")
     public ResponseEntity<List<StudentEntityResponseDto>> getByBranch(@RequestParam("branch") String branch) throws Exception {
      return new ResponseEntity<>(studentServiceImpl.getByBranch(branch),HttpStatus.FOUND);
  }
}
