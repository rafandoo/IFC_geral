package com.impressao;

public class Iniciar implements Runnable {

    private Impressora impressora;

    public Iniciar(Impressora impressora) {
        this.impressora = impressora;
    }

    @Override
    public void run() {
        System.out.printf("#%s: iniciado a impressao \n", Thread.currentThread().getName());
        impressora.trabalhoDeImpressao(new Object());
    }
}