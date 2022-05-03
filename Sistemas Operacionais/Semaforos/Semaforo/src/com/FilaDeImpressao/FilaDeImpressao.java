package com.FilaDeImpressao;

import java.util.concurrent.Semaphore;

public class FilaDeImpressao {

    private final Semaphore s;

    public FilaDeImpressao() {
        s = new Semaphore(1);
    }

    public void trabalhoDeImpressao(Object documento) {
        try {
            s.acquire();
            Long duracao = (long) (Math.random() * 10000);
            System.out.println("#" + Thread.currentThread().getName()
                    + " Fila de impressao: imprimindo um documento durante " + (duracao / 1000) + " segundos");
            Thread.sleep(duracao);
        } catch (InterruptedException e) {
            System.out.println("Erro: " + e.toString());
        } finally {
            System.out.printf("#%s: o documento foi impresso \n", Thread.currentThread().getName());
            s.release();
        }
    }
}