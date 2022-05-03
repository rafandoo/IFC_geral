package com.impressao;

public class Impressora implements Runnable {

    private FilaDeImpressao filaDeImpressao;

    public Impressora(FilaDeImpressao filaDeImpressao) {
        this.filaDeImpressao = filaDeImpressao;
    }

    @Override
    public void run() {
        System.out.printf("#%s: iniciado a impressao \n", Thread.currentThread().getName());
        filaDeImpressao.trabalhoDeImpressao(new Object());
    }
}