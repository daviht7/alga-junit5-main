package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    void deveEsperarENaoDarTimeout() {

        //Assertions.assertTimeout(Duration.ofSeconds(2),() -> SimuladorEspera.esperar(Duration.ofSeconds(1)));

        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(2),() -> SimuladorEspera.esperar(Duration.ofSeconds(1)));

    }
}