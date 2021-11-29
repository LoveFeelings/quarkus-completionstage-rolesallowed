package com.github.antoniomacri;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Content {
    @NotNull
    private String name;

}

