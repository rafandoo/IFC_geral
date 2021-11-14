import java.util.List;
import java.util.ArrayList;

public class esperancaMat {

	// ATRIBUTOS
	private int e; 			
	private int ps;			
	private int pst;		
	private int j;			
	
	// INSTANCIAS
	List<Integer> x = new ArrayList<>();
	List<Integer> y = new ArrayList<>();
	
	// GETTERS E SETTERS
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
	public int getPst() {
		return pst;
	}
	public void setPst(int pst) {
		this.pst = pst;
	}
	
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
    // METODOS 
	public boolean addList(int num) {
		return(x.add(num));
	}
	
	public int getFromList(int index) {
		return x.get(index);
	}
	
	public void possibilidadeTotal(int ps, int j) {
		setPst((int) Math.pow(ps, j));
	}
	
	public int continuidade(int num) {	
		setE(x.size() * (getJ() - 1));
		return (getE() + num);
	}
	
	public void gerarList() {
		for(int i = 0; i < getJ(); i++) {
			for(int c = 0; c < x.size(); c++) {
				y.add(x.get(c));
			}
		}
	}
	
	//BLOCOS DE COMPARAÇÂO
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
	
	@Override
	public String toString() {
		gerarList();
		possibilidadeTotal(getPs(), getJ());

		StringBuilder builder = new StringBuilder();
		builder.append("==== RESULTADOS ====\n\n");
		builder.append("1- Esperanca: ");
		builder.append(esp1() + "/" + getPst());
		builder.append("\n2- Esperanca: ");
		builder.append(esp2() + "/" + getPst());
		builder.append("\n3- Esperanca: ");
		builder.append(esp3() + "/" + getPst());
		builder.append("\n4- Esperanca: ");
		builder.append(esp4() + "/" + getPst());

		return builder.toString();
	}

}