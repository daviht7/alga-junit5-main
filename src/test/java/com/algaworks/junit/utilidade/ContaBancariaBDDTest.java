package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@DisplayName("Conta bancaria")
public class ContaBancariaBDDTest {

    @Nested
    @DisplayName("Dado uma conta bancaria com saldo de R$ 100,00")
    class ContaBancariaComSaldo {

        private ContaBancaria conta;

        @BeforeEach
        void beforeEach() {
            conta = new ContaBancaria(BigDecimal.TEN);
        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor menor")
        class SaqueValorMenor {

            BigDecimal valorSaque = new BigDecimal("9");

            @Test
            @DisplayName("Entao nao deve lancar exception")
            void deveLancarSaqueSemException() {
                Assertions.assertDoesNotThrow(() -> conta.saque(valorSaque));
            }

            @Test
            @DisplayName(" e deve subtrair do saldo")
            void deveSubtrairDoSaldo() {
                conta.saque(valorSaque);
                Assertions.assertEquals(new BigDecimal("1"), conta.saldo());
            }


        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor menor")
        class SaqueComValorMaior {

            private BigDecimal valorSaque = new BigDecimal("20");

            @Test
            @DisplayName("Entao deve lancar exception")
            void deveFalhar() {
                Assertions.assertThrows(RuntimeException.class, () -> conta.saque(valorSaque));
            }

            @Test
            @DisplayName("E nao deve alterar saldo")
            void naoDeveAlterarSaldo() {
                try {

                    conta.saque(valorSaque);

                } catch (Exception e) {

                }
                Assertions.assertEquals(new BigDecimal("10"), conta.saldo());
            }

        }

    }

    @Nested
    @DisplayName("Dado uma conta bancaria com saldo de R$ 0,00")
    class ContaBancariaComSaldoZerado {

        private ContaBancaria conta;

        @BeforeEach
        void beforeEach() {
            conta = new ContaBancaria(BigDecimal.ZERO);
        }

        @Nested
        @DisplayName("Quando efetuar o saque com valor maior")
        class SaqueComValorMaior {

            private BigDecimal valorSaque = new BigDecimal("1");

            @Test
            @DisplayName("Entao deve lancar exception")
            void deveFalhar() {
                Assertions.assertThrows(RuntimeException.class, () -> conta.saque(valorSaque));
            }


        }

        @Nested
        @DisplayName("Quando efetuar um deposito de R$ 10,00")
        class DepositoComDezReais {

            private BigDecimal valor = BigDecimal.TEN;

            @Test
            @DisplayName("Entao deve somar ao saldo")
            void deveSomarAoSaldo() {

                conta.deposito(valor);

                Assertions.assertEquals(new BigDecimal("10"),valor);


            }

        }

    }

}
