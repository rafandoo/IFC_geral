package com.binarySemaphore;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaforoBinario {

    // ATRIBUTOS
    AtomicInteger count;
    ConcurrentLinkedQueue fila;

    // CONSTRUTOR
    public SemaforoBinario() {
        this.count = new AtomicInteger(1);
        this.fila = new ConcurrentLinkedQueue<>();
    }

    // GETTERS
    public AtomicInteger getCount() {
        return count;
    }

    public ConcurrentLinkedQueue getFila() {
        return fila;
    }

    // METODOS
    public void p() {
        if (!getCount().compareAndSet(1, 0)) {
            bloquear();
        }
    }

    public void v() {
        if (!getFila().isEmpty()) {
            desbloquear();
        } else {
            count.set(1);
        }
    }

    private void bloquear() {
        Thread thread = Thread.currentThread();
        fila.add(thread);
        thread.suspend();
    }

    private void desbloquear() {
        Thread thread = (Thread) fila.poll();
        if (thread != null) {
            thread.resume();
        }
    }
}