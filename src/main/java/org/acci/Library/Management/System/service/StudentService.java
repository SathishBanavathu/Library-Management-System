package org.acci.Library.Management.System.service;

import org.acci.Library.Management.System.DTOS.request.StudentDtos.*;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentMailUpdateResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.UpdateResponse;
import org.acci.Library.Management.System.enums.Branch;

import java.rmi.StubNotFoundException;
import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);
    public String deleteStudent(StudentDeleteRequestDto studentDeleteRequestDto) throws Exception;
    public UpdateResponse updateBranch(UpdateBranch updateBranch) throws Exception;

    public StudentMailUpdateResponseDto updateEmail(StudentMailUpdateRequestDto studentMailUpdateRequestDto) throws Exception;

    public StudentEntityResponseDto getStudentById(StudentEntityRequestDto studentEntityRequestDto) throws Exception;

    public List<StudentEntityResponseDto> getAllStudents();

    public List<StudentEntityResponseDto> getByBranch(String branch) throws Exception;


}

