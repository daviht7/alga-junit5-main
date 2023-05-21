package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ContaBancariaTest {

    @Test
    void deve_saque_comSucesso() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        c.saque(new BigDecimal(5));
        Assertions.assertEquals(5, c.saldo());
    }

    @Test
    void deve_saque_comErro_saqueSendoValorNegativo() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.saque(new BigDecimal(-10)));
    }

    @Test
    void deve_saque_comErro_saqueSendoValorNull() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.saque(null));
    }

    @Test
    void deve_saque_comErro_saqueSendoValorMaior() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        Assertions.assertThrows(RuntimeException.class, () -> c.saque(new BigDecimal(20)));
    }

    @Test
    void deposito_comSucesso() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        c.deposito(new BigDecimal(5));
        Assertions.assertEquals(15,c.saldo().intValue());
    }

    @Test
    void deposito_comErroSendoValorNull() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.saque(null));
    }

    @Test
    void deposito_comErroSendoValorNegativo() {
        ContaBancaria c = new ContaBancaria(new BigDecimal(10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> c.saque(new BigDecimal(-10)));
    }

}