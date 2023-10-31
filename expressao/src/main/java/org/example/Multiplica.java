package org.example;

public class Multiplica implements Expressao {

    float fator1;
    float fator2;

    public Multiplica(float fator1, float fator2) {
        this.fator1 = fator1;
        this.fator2 = fator2;
    }

    public float getFator1() {
        return fator1;
    }

    public void setFator1(float fator1) {
        this.fator1 = fator1;
    }

    public float getFator2() {
        return fator2;
    }

    public void setFator2(float fator2) {
        this.fator2 = fator2;
    }

    @Override
    public float valor() {
        return fator1 * fator2;
    }

}
