package org.acci.Library.Management.System.DTOS.request.AuthorDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level =AccessLevel.PRIVATE)
public class AuthorRequestDto {
     String name;
     int age;
     String email;
}
