package org.acci.Library.Management.System.DTOS.request.StudentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntityRequestDto {

    private int studentId;

    private String studentName;
}
