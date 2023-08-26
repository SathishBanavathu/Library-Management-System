package org.acci.Library.Management.System.DTOS.response.StudentDtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.acci.Library.Management.System.DTOS.response.Card.CardEntityResponseDto;
import org.acci.Library.Management.System.enums.Branch;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntityResponseDto {

     int id;

     String name;

     int age;

     String email;

     Branch branch;

    CardEntityResponseDto cardEntityResponseDto;
}
