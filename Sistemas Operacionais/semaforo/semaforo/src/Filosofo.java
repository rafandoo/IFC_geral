import java.util.concurrent.Semaphore;

class Filosofo extends Thread {

    private Semaphore sem;
 
    // Did the philosopher eat?
    private boolean full = false;
 
    private String name;
 
    Filosofo(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }
 
    public void run()
    {
        try
        {
            // If the philosopher has not eaten
            if (! full) {
                // Ask the semaphore for permission to run
                sem.acquire();
                System.out.println(name + " takes a seat at the table");
 
                // The philosopher eats
                sleep(300);
                full = true;
 
                System.out.println(name + " has eaten! He leaves the table");
                sem.release();
 
                // The philosopher leaves, making room for others
                sleep(300);
            }
        }
        catch(InterruptedException e) {
            System.err.println("Something went wrong! Erro: " + e.getMessage());
        }
    }
 }

 