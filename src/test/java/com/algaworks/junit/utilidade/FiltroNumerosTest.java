package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FiltroNumerosTest {

    @Test
    public void deveRetornarNumerosPares() {

        var numeros = Arrays.asList(1, 2, 3, 4);
        var numerosParesEsperados = Arrays.asList(2, 4);

        List<Integer> resultado = FiltroNumeros.numerosPares(numeros);

        Assertions.assertIterableEquals(numerosParesEsperados, resultado);

    }

    @Test
    public void numerosImpares() {

        var numeros = Arrays.asList(1, 2, 3, 4);
        var numerosImparesEsperados = Arrays.asList(1,3);

        List<Integer> resultado = FiltroNumeros.numerosImpares(numeros);

        Assertions.assertIterableEquals(numerosImparesEsperados, resultado);

    }

    @Test
    public void isPositivo() {

        var numero = 1;

        var resultado = FiltroNumeros.isPositivo(numero);

        Assertions.assertTrue(resultado);

    }
}