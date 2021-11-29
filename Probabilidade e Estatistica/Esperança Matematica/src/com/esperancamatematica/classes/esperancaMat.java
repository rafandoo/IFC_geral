package com.esperancamatematica.classes;
import java.util.List;
import java.util.ArrayList;

public class esperancaMat {

	// ATRIBUTOS			
	private int possibilidades;				
	private int jogadas;	
	private int tipo;	
	
	// INSTANCIAS
	List<Integer> x = new ArrayList<>();
	List<Integer> y = new ArrayList<>();
	
	// GETTERS E SETTERS
	public int getPossibilidades() {
		return possibilidades;
	}
	public void setPossibilidades(int possibilidades) {
		this.possibilidades = possibilidades;
	}
	
	public int getJogadas() {
		return jogadas;
	}
	public void setJogadas(int jogadas) {
		this.jogadas = jogadas;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    // METODOS 
	public boolean addList(int num) {
		return(x.add(num));
	}
	
	public int getFromList(int index) {
		return x.get(index);
	}
	
	public int possibilidadeTotal(int ps, int j) {
		return ((int) Math.pow(ps, j));
	}
	
	public int continuidade(int num) {	
		return ((x.size() * (getJogadas() - 1)) + num);
	}
	
	public void gerarList() {
		for(int i = 0; i < getJogadas(); i++) {
			for(int c = 0; c < x.size(); c++) {
				y.add(x.get(c));
			}
		}
	}
	
	//BLOCOS DE COMPARACAO
	public int espDado() {
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(i) == y.get(continuidade(c))) {
					cont++;
				} 
			}
		}
		return cont;
	}

	//1=cara 2=coroa
	public int espMoeda() {
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(continuidade(c)) == 1) {
					cont++;
				}
			}
		}
		return 0;
	}

	public String tipoEntrada() {

	}

	
	@Override
	public String toString() {
		gerarList();
		possibilidadeTotal(getPossibilidades(), getJogadas());

		StringBuilder builder = new StringBuilder();
		builder.append("==== RESULTADOS ====\n");
		builder.append("\nJogadas: ");
		builder.append(getJogadas());
		builder.append("\nPossibilidades: ");
		builder.append(possibilidadeTotal(getPossibilidades(), getJogadas()));
		builder.append("\nEsperanca: ");
		builder.append(espDado() + "/" + possibilidadeTotal(getPossibilidades(), getJogadas()));

		return builder.toString();
	}
}
