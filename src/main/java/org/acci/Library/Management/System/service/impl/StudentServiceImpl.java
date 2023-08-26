package org.acci.Library.Management.System.service.impl;

import org.acci.Library.Management.System.DTOS.request.StudentDtos.*;
import org.acci.Library.Management.System.DTOS.response.Card.CardEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentMailUpdateResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.UpdateResponse;
import org.acci.Library.Management.System.Transformer.StudentTransformer;
import org.acci.Library.Management.System.entity.Card;
import org.acci.Library.Management.System.entity.Student;
import org.acci.Library.Management.System.enums.Branch;
import org.acci.Library.Management.System.enums.CardStatus;
import org.acci.Library.Management.System.exceptions.StudentNotFoundException;
import org.acci.Library.Management.System.repository.StudentRepository;
import org.acci.Library.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto)
    {

      Student student = StudentTransformer.StudentRequestDtoToStudentEntity(studentRequestDto);
      Card card = new Card();
      card.setCardStatus(CardStatus.ACTIVATE);
      card.setValidTill("2025-01-01");
      card.setStudent(student);
      student.setCard(card);
      studentRepository.save(student);
        return "Student Registration Successful";
    }

    @Override
    public String deleteStudent(StudentDeleteRequestDto studentDeleteRequestDto) throws Exception
    {
        try{
            Student student = studentRepository.findById(studentDeleteRequestDto.getId()).get();
            if(student.getName().equalsIgnoreCase(studentDeleteRequestDto.getName()))
            {
                studentRepository.deleteById(studentDeleteRequestDto.getId());
                return "Student Deleted Successfully";
            }
            else
            {
                return "Id and Name Doesn't match ";
            }

        }
        catch(Exception e)
        {
            throw new Exception("Invalid Id");
        }
    }

    @Override
    public UpdateResponse updateBranch(UpdateBranch updateBranch) throws Exception
    {
        UpdateResponse updateResponse = new UpdateResponse();
        try{
            Student student=studentRepository.findById(updateBranch.getId()).get();
            if(student.getName().equalsIgnoreCase(updateBranch.getName())) {
                student.setBranch(Branch.valueOf(updateBranch.getBranch()));
                studentRepository.save(student);
                updateResponse.setBranch(updateBranch.getBranch());
                updateResponse.setName(updateBranch.getName());
                updateResponse.setMessage("Updated Successfully");
                return updateResponse;
            }
            else {
                updateResponse.setBranch(updateBranch.getBranch());
                updateResponse.setName(updateBranch.getName());
                updateResponse.setMessage("Id doesn't match with name");
                return updateResponse;
            }
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Student Id");
        }
    }

    @Override
    public StudentMailUpdateResponseDto updateEmail(StudentMailUpdateRequestDto studentMailUpdateRequestDto) throws Exception
    {
        try{
            Student student = studentRepository.findById(studentMailUpdateRequestDto.getStudentId()).get();
            StudentMailUpdateResponseDto studentMailUpdateResponseDto = new StudentMailUpdateResponseDto();
            if(studentMailUpdateRequestDto.getStudentName().equalsIgnoreCase(student.getName()))
            {
                student.setEmail(studentMailUpdateRequestDto.getEmail());
                studentRepository.save(student);
                studentMailUpdateResponseDto.setEmail(studentMailUpdateRequestDto.getEmail());
                studentMailUpdateResponseDto.setMessage("Email Updated Successfully....!!");
                return studentMailUpdateResponseDto;
            }
            else {
                studentMailUpdateResponseDto.setEmail(studentMailUpdateRequestDto.getEmail());
                studentMailUpdateResponseDto.setMessage("Student Name Doesn't Match with Id");
                return studentMailUpdateResponseDto;
            }
        }
        catch(Exception e)
        {
            throw new Exception("Invalid Student Id");
        }
    }

    @Override
    public StudentEntityResponseDto getStudentById(StudentEntityRequestDto studentEntityRequestDto) throws Exception
    {

        try{
            Student student = studentRepository.findById(studentEntityRequestDto.getStudentId()).get();
            if(student.getName().equalsIgnoreCase(studentEntityRequestDto.getStudentName()))
            {
                StudentEntityResponseDto studentEntityResponseDto = StudentTransformer.studentEntityToStudentEntityResponseDto(student);
                return studentEntityResponseDto;
            }
            else {
                throw new Exception("Id Doesn't Match With Name");
            }
        }
        catch(Exception e)
        {
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public List<StudentEntityResponseDto> getAllStudents()
    {
        List<StudentEntityResponseDto> allStudents= new ArrayList<>();
        for (Student student: studentRepository.findAll()) {

            StudentEntityResponseDto studentEntityResponseDto = StudentTransformer.studentEntityToStudentEntityResponseDto(student);

            allStudents.add(studentEntityResponseDto);
        }
        return allStudents;
    }

    @Override
    public List<StudentEntityResponseDto> getByBranch(String branch) throws Exception
    {
        try{
           // List<Student> students = studentRepository.findByBranch(branch);
            List<StudentEntityResponseDto> allStudents =new ArrayList<>();
            for(Student student:studentRepository.findByBranch(branch)){

                StudentEntityResponseDto studentEntityResponseDto = StudentTransformer.studentEntityToStudentEntityResponseDto(student);

                allStudents.add(studentEntityResponseDto);
            }
            return allStudents;
        }
        catch(Exception e){
            throw new Exception(" Branch Not Found");
        }
    }

}
