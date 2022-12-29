package com.study.quarkus.dto;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AlunoRequestTest {

    private static final String NAME = "Testonildo";
    private static final String GENERO = "m";
    private static final String PLANO = "normal";

    @Test
    void constructorBuilder() {

        //GIVEN
        final var factory = Validation.buildDefaultValidatorFactory();
        final var validator = factory.getValidator();

        //WHEN
        var request =
                AlunoRequest.builder()
                        .name(NAME)
                        .genero(GENERO)
                        .plano(PLANO)
                        .build();

        //THEN
        assertFields(validator, request);
        factory.close();
    }

    @Test
    void constructorAllArgs() {
        //GIVEN
        final var factory = Validation.buildDefaultValidatorFactory();
        final var validator = factory.getValidator();

        //WHEN
        var request =
                AlunoRequest.builder()
                        .name(NAME)
                        .genero(GENERO)
                        .plano(PLANO)
                        .build();

        //THEN
        assertFields(validator, request);
        factory.close();
    }

    @Test
    void equalsAndHashcodeContract() {
        EqualsVerifier.simple().forClass(AlunoRequest.class)
                .verify();
    }

    static Stream<Arguments> invalidFields() {
        return Stream.of(
                arguments(null, "Name must be not empty or null"),
                arguments("   ", "Name must be not empty or null")
        );
    }

    private void assertFields(final Validator validator, final AlunoRequest request) {
        final var violations = validator.validate(request);
        assertThat(violations).isEmpty();

        assertThat(request.getName()).isEqualTo(NAME);
    }
}