package org.acci.Library.Management.System.DTOS.request.StudentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentMailUpdateRequestDto {

    private int studentId;

    private String studentName;

    private String email;
}
