package com.study.quarkus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class DisciplinaRequest {

    @NotBlank(message = "Name must be not empty or null")
    private String name;

    @NotBlank(message = "Area must be not empty or null")
    private String area;

    @Min(value = 1)
    private int horas;

    @NotNull(message = "Obrigatoria_flag must not be null")
    private boolean obrigatoria;
}
