package org.acci.Library.Management.System.Transformer;

import org.acci.Library.Management.System.DTOS.request.StudentDtos.StudentRequestDto;
import org.acci.Library.Management.System.DTOS.response.Card.CardEntityResponseDto;
import org.acci.Library.Management.System.DTOS.response.StudentDtos.StudentEntityResponseDto;
import org.acci.Library.Management.System.entity.Student;
import org.acci.Library.Management.System.enums.Branch;

public class StudentTransformer {

    public static Student StudentRequestDtoToStudentEntity (StudentRequestDto studentRequestDto)
    {
        return Student.builder()
                .name(studentRequestDto.getName())
                .email(studentRequestDto.getEmail())
                .age(studentRequestDto.getAge())
                .branch(Branch.valueOf(studentRequestDto.getBranch()))
                .build();
    }

    public static StudentEntityResponseDto studentEntityToStudentEntityResponseDto(Student student)
    {

        CardEntityResponseDto cardEntityResponseDto = CardEntityResponseDto.builder()
                .cardStatus(student.getCard().getCardStatus())
                .issueDate(student.getCard().getIssueDate())
                .validTill(student.getCard().getValidTill())
                .id(student.getId())
                .build();


       return StudentEntityResponseDto.builder()
                .id(student.getId())
                .age(student.getAge())
                .branch(student.getBranch())
                .email(student.getEmail())
                .name(student.getName())
                .cardEntityResponseDto(cardEntityResponseDto)
                .build();

    }
}
