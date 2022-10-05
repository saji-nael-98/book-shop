package com.example.bookshop.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AuthorDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    private String gender;
}
