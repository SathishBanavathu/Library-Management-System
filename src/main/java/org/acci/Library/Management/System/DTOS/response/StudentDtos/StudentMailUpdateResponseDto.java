package org.acci.Library.Management.System.DTOS.response.StudentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class StudentMailUpdateResponseDto {
    private String email;
    private String message;

}
