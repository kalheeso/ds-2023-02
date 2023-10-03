package newton;

public class Newton {

    public static double calcularRaizQuadrada(double n, double precisao) {
        double estimativa = n;

        // Iteração até atingir a precisão desejada
        while (Math.abs(estimativa * estimativa - n) > precisao) {
            estimativa = 0.5 * (estimativa + n / estimativa);
        }

        return estimativa;
    }

    public static void main(String[] args) {
        double resultado = calcularRaizQuadrada(36, 0.00001);

        System.out.println("A raiz quadrada é aproximadamente " + resultado);
    }
}
