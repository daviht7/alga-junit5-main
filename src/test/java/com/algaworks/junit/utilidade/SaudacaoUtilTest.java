package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaudacaoUtilTest {

    @Test
    public void Dado_determinado_horario_quando_esse_horario_for_de_manha_deve_retornar_bom_dia() {

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