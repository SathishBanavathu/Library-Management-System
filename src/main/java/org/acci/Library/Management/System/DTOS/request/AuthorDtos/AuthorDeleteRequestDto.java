package org.acci.Library.Management.System.DTOS.request.AuthorDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthorDeleteRequestDto {

    private int id;

    private String name;
}
