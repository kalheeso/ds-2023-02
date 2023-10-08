package org.newton;

import java.util.function.Function;

public class Newton implements Function<Double, Double> {

    public static double calcularRaizQuadrada(double n, double precisao) {
        double estimativa = n;

        // Iteração até atingir a precisão desejada
        while (Math.abs(estimativa * estimativa - n) > precisao) {
            estimativa = 0.5 * (estimativa + n / estimativa);
        }

        return estimativa;
    }

    @Override
    public Double apply(Double aDouble) {
        return Math.sqrt(aDouble);
    }
}
