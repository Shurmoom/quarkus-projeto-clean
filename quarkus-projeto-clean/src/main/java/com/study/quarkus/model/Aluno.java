package com.study.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALUNOS_MATEUS")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Integer id;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "aluno_name", nullable = false)
    private String name;

    @NotBlank(message = "Genero must be not empty or null java")
    @Column(name = "aluno_genero", nullable = false)
    private String genero;

    @NotBlank(message = "Plano must be not empty or null java")
    @Column(name = "aluno_plano", nullable = false)
    private String plano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor")
    private Professor tutor;

    @Column(name="data_atualizacao", nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void prePersist(){
        setDateTime(LocalDateTime.now());
    }
}
