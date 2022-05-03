package com.impressao;

public class Main {
    public static void main(String[] args) {
        FilaDeImpressao filaDeImpressao = new FilaDeImpressao();
        Thread thread[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Impressora(filaDeImpressao), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}