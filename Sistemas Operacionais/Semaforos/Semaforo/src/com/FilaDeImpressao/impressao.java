package com.FilaDeImpressao;

public class impressao implements Runnable {

    private FilaDeImpressao filaDeImpressao;

    public impressao(FilaDeImpressao filaDeImpressao) {
        this.filaDeImpressao = filaDeImpressao;
    }

    @Override
    public void run() {
        System.out.printf("#%s: iniciado a impressao \n", Thread.currentThread().getName());
        filaDeImpressao.trabalhoDeImpressao(new Object());
    }
}