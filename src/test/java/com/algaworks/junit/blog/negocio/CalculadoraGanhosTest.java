package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadoraGanhos;
    Editor editor;
    Post post;

    @BeforeAll
    static void initAll() {
        calculadoraGanhos = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }

    @BeforeEach
    void init() {

        editor = new Editor("Davi holanda", "daviht7@gmail.com", BigDecimal.valueOf(5L), true);

        post = new Post(1L, "Ecossistema java", "O ecosistema do java é muito maduro", editor, "ecossitema", null, false, false);

    }

    @Test
    public void dado_um_post_e_autor_quando_calcular_ganhos_entao_deve_retornar_quantidade_de_palavras_no_post() {
        Ganhos ganhos = calculadoraGanhos.calcular(post);
        Assertions.assertEquals(7, ganhos.getQuantidadePalavras());
    }

    @Test
    public void deve_calcular_ganhos_quando_houver_bonus_premio() {
        Ganhos ganhos = calculadoraGanhos.calcular(post);
        Assertions.assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
        Assertions.assertEquals(7, ganhos.getQuantidadePalavras());
        Assertions.assertEquals(editor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void dado_um_post_e_autor_quando_calcular_ganhos_entao_deve_retornar_valor_pago_por_palavras_do_autor() {
        Ganhos ganhos = calculadoraGanhos.calcular(post);
        Assertions.assertEquals(editor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void dado_um_post_e_autor_quando_calcular_ganhos_entao_deve_retornar_valor_com_bonus() {
        Ganhos ganhos = calculadoraGanhos.calcular(post);
        Assertions.assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
    }

    @Test
    public void deve_calcular_ganhos_quando_nao_houver_bonus_premio() {
        editor.setPremium(false);
        Ganhos ganhos = calculadoraGanhos.calcular(post);
        Assertions.assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
        Assertions.assertEquals(7, ganhos.getQuantidadePalavras());
        Assertions.assertEquals(editor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

}