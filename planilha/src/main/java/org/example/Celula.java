package org.example;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Celula {

    private Integer value;
    private String name;
    private List<Celula> observers = new ArrayList<>();

    public Celula(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public void addObserver(Celula c) {
        observers.add(c);
    }

    public void removeObserver(Celula c) {
        observers.remove(c);
    }

    private void notifyObservers(){
        for (Celula c : observers) {
            System.out.println("Reavaliar " + c.getName() + " por mudança ocorrida em " + this.name);
            c.resetValue(this.value);
        }
    }

    public void defineValue(int novoValor){
        if (value != novoValor) {
            this.value = novoValor;
            notifyObservers();
        }
    }

    private void resetValue(int valor){
        if (this.value == null) {
            this.value = 0;
        }
        this.value += valor;
    }
}