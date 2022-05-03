package com.tiposDeSemaforos;

public class SemaforoBinario {

    private boolean bloqueado = false;

    public SemaforoBinario(int inicial) {
        this.bloqueado = (inicial == 0);
    }

    public synchronized void waitForNotify() throws InterruptedException {
        while (bloqueado) {
            wait();
        }
        bloqueado = true;
    }

    public synchronized void notifyToWakeup() {
        if (bloqueado) {
            notify();
        }
        bloqueado = false;
    }

}
