package com.study.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DISCIPLINAS_MATEUS")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disciplina_id")
    private Integer id;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "disciplina_name", nullable = false)
    private String name;

    @NotBlank(message = "Area must be not empty or null")
    @Column(name = "disciplina_area", nullable = false)
    private String area;

    @NotNull(message = "Horas must not be null")
    @Column(name = "disciplina_horas", nullable = false)
    private int horas;

    @NotNull(message = "Obrigatoria_flag must not be null")
    @Column(name = "disciplina_obrigatoria_flag", nullable = false)
    private boolean obrigatoria;

    @Column(name="data_atualizacao", nullable = false)
    private LocalDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular", unique = true)
    private Professor titular;

    @PrePersist
    public void prePersist(){
        setDateTime(LocalDateTime.now());
    }

}
