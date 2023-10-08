package org.example;

import org.junit.Test;
import org.newton.Newton;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class NewtonTest {

    @Test
    void testCalcularRaizQuadrada() {
        double resultado = Newton.calcularRaizQuadrada(25, 0.0001);
        assertEquals(5.0, resultado, 0.0001);
    }

    @Test
    void testCalcularRaizQuadradaZero() {
        double resultado = Newton.calcularRaizQuadrada(0, 0.0001);
        assertEquals(0.0, resultado, 0.0001);
    }

    @Test
    void testCalcularRaizQuadradaNegativa() {
        assertThrows(ArithmeticException.class, () -> {
            Newton.calcularRaizQuadrada(-1, 0.0001);
        });
    }

    @Test
    void testApply() {
        Function<Double, Double> raiz = new Newton();
        assertEquals(3.0, raiz.apply(9.0));
    }
}