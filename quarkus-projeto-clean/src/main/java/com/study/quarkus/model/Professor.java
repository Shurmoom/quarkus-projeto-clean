package com.study.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFESSORES_MATEUS")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Integer id;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "professor_name", nullable = false)
    private String name;

    @NotBlank(message = "Genero must be not empty or null")
    @Column(name = "professor_genero", nullable = false)
    private String genero;

    @NotBlank(message = "Grau must be not empty or null")
    @Column(name = "professor_grau", nullable = false)
    private String grau;

    @Column(name="data_atualizacao", nullable = false)
    private LocalDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "titular")
    private Disciplina disciplina;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<Aluno> alunos;

    @PrePersist
    public void prePersist(){
        setDateTime(LocalDateTime.now());
    }

}