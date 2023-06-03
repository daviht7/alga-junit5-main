package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FiltroNumerosTest {

    //given, when, then
    @Test
    public void Dado_uma_lista_de_numeros_Quando_Filtrar_por_pares_Entao_deve_retornar_apenas_numeros_pares() {

        var numeros = Arrays.asList(1, 2, 3, 4);
        var numerosParesEsperados = Arrays.asList(2, 4);

        List<Integer> resultado = FiltroNumeros.numerosPares(numeros);

        Assertions.assertIterableEquals(numerosParesEsperados, resultado);

    }

    @Test
    public void Dado_uma_lista_de_numeros_Quando_Filtrar_por_impares_Entao_deve_retornar_apenas_numeros_impares() {

        var numeros = Arrays.asList(1, 2, 3, 4);
        var numerosImparesEsperados = Arrays.asList(1,3);

        List<Integer> resultado = FiltroNumeros.numerosImpares(numeros);

        Assertions.assertIterableEquals(numerosImparesEsperados, resultado);

    }

    @Test
    public void Dado_um_determinado_numero_deve_validar_se_esse_numero_e_possitivo() {

        var numero = 1;

        var resultado = FiltroNumeros.isPositivo(numero);

        Assertions.assertTrue(resultado);

    }
}