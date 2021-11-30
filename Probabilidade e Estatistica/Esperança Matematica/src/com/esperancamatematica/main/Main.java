package com.esperancamatematica.main;

import java.util.Scanner;

import com.esperancamatematica.classes.esperancaMat;

public class Main {
        
    public static void main(String[] args) {    
        
    	Scanner ent = new Scanner(System.in);
    	esperancaMat em = new esperancaMat();
    	
    	System.out.print("\n==== ESPERANCA MATEMATICA ====");
        System.out.print("\n\nDeseja calcular com um dado(1) ou uma moeda(2)? ");
        int opc = ent.nextInt();
        if(opc == 1 || opc == 2) {
            em.setTipo(opc);
        } else {
            System.out.println("Opcao invalida!");
            System.exit(0);
        }
        
        System.out.print("\nDigite o numero de jogadas: ");
        em.setJogadas(ent.nextInt());
        
        System.out.println("\n"+em);
        ent.close();
        
        System.out.println("\n\nx:");
        em.imprimex();
        System.out.println("\ny:");
        em.imprimey();
    }
}
