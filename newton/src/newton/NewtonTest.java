package newton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
}