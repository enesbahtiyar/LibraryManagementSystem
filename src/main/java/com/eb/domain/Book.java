package com.eb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "title cannot be null")
    @NotBlank(message = "title cannot be white space")
    @Size(min = 2, max = 50, message = "title '${validatedValue}' must be between : {min} and {max}")
    private String title;

    private String author;

    @Column(nullable = false)
    private String publicationDate;

    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.REMOVE)
    private List<Teacher> teacherList = new ArrayList<>();
}
