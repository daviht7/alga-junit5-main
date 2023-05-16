package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaudacaoUtilTest {

    @Test
    public void saudarTeste() {

        String saudacao = SaudacaoUtil.saudar(9);
        System.out.println(saudacao);

        assertEquals("Bom dia", saudacao);

    }

}