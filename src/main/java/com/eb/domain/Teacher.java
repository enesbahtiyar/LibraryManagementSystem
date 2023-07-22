package com.eb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be white space")
    @Size(min = 2, max = 50, message = "name '${validatedValue}' must be between : {min} and {max}")
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "please provide the valid email")
    @Column(length = 50, unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Setter(AccessLevel.NONE)
    private LocalDateTime registerDate = LocalDateTime.now();

    @ManyToMany
    @JoinTable(name = "Teacher_Book",
    joinColumns = @JoinColumn(name = "teacher_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> bookList = new ArrayList<>();
}
