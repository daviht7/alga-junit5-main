package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe de teste de SaudacaoUtil")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Deve saudar com bom dia")
    public void saudarTeste() {

        String saudacao = SaudacaoUtil.saudar(9);
        System.out.println(saudacao);

        assertEquals("Bom dia", saudacao);

    }

    @Test
    public void saudarTeste_deveRetornarBoaTarde() {

        String saudacao = SaudacaoUtil.saudar(12);
        System.out.println(saudacao);

        assertEquals("Boa tarde", saudacao);

    }
    @Test
    public void saudarTeste_deveRetornarBoaNoite() {

        String saudacao = SaudacaoUtil.saudar(20);
        System.out.println(saudacao);

        assertEquals("Boa noite", saudacao);

    }

    @Test
    public void deveLancarException() {
        int horaInvalida = -10;

        Executable executable = () -> SaudacaoUtil.saudar(horaInvalida);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, executable);

        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(5));
    }

}