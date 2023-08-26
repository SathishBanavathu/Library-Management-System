package org.acci.Library.Management.System.DTOS.request.AuthorDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UpdateEmailRequestDto {

    private int id;
    private String name;
    private String mail;
}
