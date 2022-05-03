package com.impressao;

public class Main {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Iniciar(impressora), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}