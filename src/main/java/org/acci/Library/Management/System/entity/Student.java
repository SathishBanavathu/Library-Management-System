package org.acci.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;
import org.acci.Library.Management.System.enums.Branch;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Branch branch;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;

}
