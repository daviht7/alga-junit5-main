package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    @Test
    public void assercaoAgrupada() {
        Pessoa eu = new Pessoa("Davi", "Holanda");

        assertAll("Assertções de pessoa",
                () -> assertEquals("Davi", eu.getNome()),
                () -> assertEquals("Holanda", eu.getSobrenome())
        );
    }

}