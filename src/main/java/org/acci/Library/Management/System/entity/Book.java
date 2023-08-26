package org.acci.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.*;
import org.acci.Library.Management.System.enums.Genre;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int price;

    private int pages;

    private boolean issueStatus;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    Card card;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionsList = new ArrayList<>();
}
