package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        if (saldo == null) {
            throw new IllegalArgumentException("O saldo não pode ser null");
        }
        this.saldo = saldo;
        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo
    }

    public void saque(BigDecimal valor) {

        if (valor == null || valor.intValue() < 0) {
            throw new IllegalArgumentException("O valor de saque não pode ser null ou menor que 0");
        }
        if (valor.intValue() > this.saldo.intValue()) {
            throw new RuntimeException("O valor de saque é maior que o saldo");
        }

        this.saldo = saldo().subtract(valor);
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
    }

    public void deposito(BigDecimal valor) {
        if (valor == null || valor.intValue() <= 0) {
            throw new IllegalArgumentException("o valor de depósito não pode ser null ou menor que zero");
        }
        this.saldo = saldo().add(valor);
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo
    }

    public BigDecimal saldo() {
        //TODO 1 - retornar saldo
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
