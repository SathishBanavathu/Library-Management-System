package org.acci.Library.Management.System.DTOS.request.StudentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateBranch {
    private int id;
    private String  name;
    private String branch;
}
