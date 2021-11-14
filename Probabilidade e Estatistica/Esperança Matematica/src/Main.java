
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {    
        
    	Scanner ent = new Scanner(System.in);
    	esperancaMat em = new esperancaMat();
    	
    	System.out.print("\n==== ESPERANCA MATEMATICA ====");
        System.out.print("\n\nDigite o numero total de possibilidades: ");
        em.setPs(ent.nextInt());
    	
        System.out.print("\n== ENTRADA DAS POSSIBILIDADES ==");
        for(int i = 0; i < em.getPs(); i++) {
            System.out.print("\nDigite um numero: ");
            em.addList(ent.nextInt());
        }
        
        System.out.print("\nDigite o numero de jogadas: ");
        em.setJ(ent.nextInt());
        
        System.out.println("\n"+em);
        ent.close();
    }
}
