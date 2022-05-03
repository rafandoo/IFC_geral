package com.processador;

import java.util.concurrent.Semaphore;

public class Processador extends Thread {
    private int id;
    private Semaphore semaforo;

    public Processador(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    private void processar() {
        try {
            System.out.println("Thread @" + id + " processando");
            Thread.sleep(3000);
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
        }
    }

    private void regiaoNaoCritica() {
        System.out.println("Thread @" + id + " em região não crítica");
        processar();
    }

    private void regiaoCritica() {
        System.out.println("Thread @" + id + " em região crítica");
        processar();
        System.out.println("Thread @" + id + " saindo da região crítica");
    }

    public void run() {
        try {
            semaforo.acquire();
            regiaoCritica();
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
        } finally {
            semaforo.release();
        }
    }

    public static void main(String[] args) {
        int numeroPermissoes = 2;
        int numeroProcessos = 200;

        Semaphore semaforo = new Semaphore(numeroPermissoes);
        Processador[] processos = new Processador[numeroProcessos];

        for(int i = 0; i < numeroProcessos; i++) {
            processos[i] = new Processador(i, semaforo);
            processos[i].start();
        }
    } 
}
