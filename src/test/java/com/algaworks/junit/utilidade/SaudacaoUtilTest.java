package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
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
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(5));
    }

}