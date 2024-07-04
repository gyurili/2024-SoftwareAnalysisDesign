package practice.ch17;

import java.util.ArrayList;
import java.util.List;

// 관찰 대상 (수를 생성하는 객체를 나타내는 추상 클래스)
public abstract class NumberGenerator {
    // Observer를 보관한다  
    private List<Observer> observers = new ArrayList<>();

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(this); // 관찰자에게 표시를 갱신하라고 통지함
        }
    }

    // 수를 취득한다 (추상)
    public abstract int getNumber();

    // 수를 생성한다 (추상)
    public abstract void execute();
}
