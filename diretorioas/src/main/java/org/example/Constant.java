package org.example;

public class Constant implements Expressao {
    float valor;

    public Constant(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public float valor() {
        return valor;
    }
}
