package com.workshop.springjpa.controllers.Greeting.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {

    @NotNull(message = "The MESSAGE should not null")
    @NotEmpty(message = "The MESSAGE should not empty")
    private String msg;

    @NotNull(message = "The FROM should not null")
    @NotEmpty(message = "The FROM should not empty")
    private String from;

    @NotNull(message = "The TO should not null")
    @NotEmpty(message = "The TO should not empty")
    private String to;
}
