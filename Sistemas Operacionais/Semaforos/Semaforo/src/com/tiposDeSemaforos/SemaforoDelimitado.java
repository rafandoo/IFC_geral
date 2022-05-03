package com.tiposDeSemaforos;

public class SemaforoDelimitado {

    private int count = 0;
    private int limite = 0;

    public SemaforoDelimitado(int limiteSuperior) {
        this.limite = limiteSuperior;
    }

    public synchronized void take() throws InterruptedException {
        while (this.count == limite) {
            wait();
            this.count++;
            this.notify();
        }
    }

    public synchronized void release() throws InterruptedException {
        while (this.count == 0) {
            wait();
            this.count--;
        }
    }
}