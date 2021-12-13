package com.analisecombinatoria.classes;

public class AnaliseCombinatoria {

    // ATRIBUTOS
    private int objetos;
    private int posicoes;

    // CONSTRUTORES
    public AnaliseCombinatoria() {

    }

    public AnaliseCombinatoria(int objetos, int posicoes){
        setObjetos(objetos);
        setPosicoes(posicoes);
    }

    // GETTERS E SETTERS
    public int getObjetos() {
        return objetos;
    }
    public void setObjetos(int objetos) {
        this.objetos = objetos;
    }

    public int getPosicoes() {
        return posicoes;
    }
    public void setPosicoes(int posicoes) {
        this.posicoes = posicoes;
    }

    // METODOS
    public int permutacao(int num) {
        int fatorial = 1;
        for(int i = 2; i <= num; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public int arranjo(int objetos, int posicoes) {
        return (permutacao(objetos) / (permutacao(objetos - posicoes)));
    }

    public int combinacao(int objetos, int posicoes) {
        return (permutacao(objetos) / (permutacao(objetos - posicoes) * permutacao(posicoes)));
    }

}


