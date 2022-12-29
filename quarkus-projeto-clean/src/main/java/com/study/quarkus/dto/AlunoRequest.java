package com.study.quarkus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class AlunoRequest {

    @NotBlank(message = "Name must be not empty or null")
    private String name;

    @NotBlank(message = "Genero must be not empty or null")
    private String genero;

    @NotBlank(message = "Plano must be not empty or null")
    private String plano;
}
