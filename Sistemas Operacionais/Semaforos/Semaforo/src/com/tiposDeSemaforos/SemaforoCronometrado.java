package com.tiposDeSemaforos;

public class SemaforoCronometrado {
    private TimedSemaphore semaphore;

    TimedSemaphoreExample(long period, int slotLimit) {  
        semaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);  
    }

    boolean tryAdd() {
        return semaphore.tryAcquire();
    }

    int availableSlots() {
        return semaphore.getAvailablePermits();
    }

}
