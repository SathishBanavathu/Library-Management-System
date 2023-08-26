package org.acci.Library.Management.System.DTOS.response.StudentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UpdateResponse {
    private String name;
    private String branch;
    private String message;
}
