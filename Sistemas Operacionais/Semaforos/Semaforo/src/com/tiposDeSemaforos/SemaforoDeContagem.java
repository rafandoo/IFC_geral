package com.tiposDeSemaforos;

public class SemaforoDeContagem {

    private int count = 0;

    public synchronized void take() {
        this.count++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while(this.count == 0) {
            wait();
            this.count--;
        }
    }
    
}