package ro.ulbs.proiectaresoftware.lab11;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}
