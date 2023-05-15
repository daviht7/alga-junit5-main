package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaudacaoUtilTest {

    @Test
    public void saudarTeste() {

        String saudacao = SaudacaoUtil.saudar(9);
        System.out.println(saudacao);

        Assertions.assertEquals("Bom dia", saudacao);
    }

}