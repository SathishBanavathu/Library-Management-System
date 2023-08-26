package org.acci.Library.Management.System.DTOS.response.AuthorDtos;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MailUpdateResponseDto {

    private  String name;

    private  String mail;

    private  String message;
}
