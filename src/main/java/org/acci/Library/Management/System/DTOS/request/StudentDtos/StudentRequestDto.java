package org.acci.Library.Management.System.DTOS.request.StudentDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level =AccessLevel.PRIVATE)
public class StudentRequestDto {

     String name;

     int age;

     String branch;

     String email;
}
