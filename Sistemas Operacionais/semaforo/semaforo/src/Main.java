import java.util.concurrent.Semaphore;


public class Main {

    public static void main(String[] args) {
 
        Semaphore sem = new Semaphore(2);
        new Filosofo(sem, "Socrates").start();
        new Filosofo(sem,"Plato").start();
        new Filosofo(sem,"Aristotle").start();
        new Filosofo(sem, "Thales").start();
        new Filosofo(sem, "Pythagoras").start();
    }
 }