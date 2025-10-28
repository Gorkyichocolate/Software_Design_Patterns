import java.util.ArrayList;
import java.util.List;

public class Observered {
    public static void main(String[] args) {
        Observer observer = new Observer("one");
        Observer observer2 = new Observer("two");

        observer.setState("new state");
        observer2.setState("hello");

    }
}


interface Observerable {
    void update();
}

class Observer implements Observerable{
    static List<Observer> observers = new ArrayList<>();
    String name;
    String state;


    public Observer(String name){
        this.name = name;
        observers.add(this);
    }

    public void setState(String state){
        this.state = state;
        notifyAllObservers();
    }

    void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }

    public void update(){
        System.out.println("Observer: " + name + " has changed to " + state);
    }

}
