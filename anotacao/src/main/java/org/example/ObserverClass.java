package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Observer(observed="observable_matheus")
public class ObserverClass {

}

class Observable {
    private String identificator;
    private List<Object> observers = new ArrayList<>();

    public Observable(String identificator) {
        this.identificator = identificator;
    }

    public void addObserver(Object observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Object observer : observers) {
            Observer annotation = observer.getClass().getAnnotation(Observer.class);

            if (annotation != null && annotation.observed().equals(identificator)) {
                System.out.println(annotation.observed() + " equals " + identificator);
            }
        }
    }
}