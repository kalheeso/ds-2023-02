package org.example;

public class Soma implements Expressao {

    float termo1;
    float termo2;

    public Soma(float termo1, float termo2) {
        this.termo1 = termo1;
        this.termo2 = termo2;
    }

    public float getTermo1() {
        return termo1;
    }

    public void setTermo1(float termo1) {
        this.termo1 = termo1;
    }

    public float getTermo2() {
        return termo2;
    }

    public void setTermo2(float termo2) {
        this.termo2 = termo2;
    }

    @Override
    public float valor() {
        return termo1 + termo2;
    }

}
