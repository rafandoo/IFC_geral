package com.esperancamatematica.classes;
import java.util.List;
import java.util.ArrayList;

public class esperancaMat {

	// ATRIBUTOS			
	private int possibilidades;				
	private int jogadas;			
	
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
	public int esp() {
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

/*
	public int esp1() {
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(i) + y.get(continuidade(c)) >= 10) {
					cont++;
				} 
			}
		}
		return cont;
	}
	
	public int esp2() {
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			if(y.get(i) + y.get(continuidade(i)) <= 5) {
				cont++;
			}
		}
		return cont;
	}
	
	public int esp3() {	
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(i) < y.get(continuidade(c))) {
					cont++;
				} 
			}
		}
		return cont;
	}
	
	public int esp4() {
		int cont = 0;

		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(i) == 4 || y.get(continuidade(c)) == 4) {
					cont++;
				} 
			}
		}
		return cont;
	}

	public int esp5() {
		int cont = 0;
		for(int i = 0; i < x.size(); i++) {
			for(int c = 0; c < x.size(); c++) {
				if(y.get(i) == 1 || y.get(continuidade(c)) == 1) {
					cont++;
				}
			}
		}
		return cont;
	}
*/
	
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
		builder.append(esp() + "/" + possibilidadeTotal(getPossibilidades(), getJogadas()));

		return builder.toString();
	}
}
