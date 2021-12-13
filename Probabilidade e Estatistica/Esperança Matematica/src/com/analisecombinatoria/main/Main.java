package com.analisecombinatoria.main;
import java.util.Scanner;
import com.analisecombinatoria.classes.AnaliseCombinatoria;

public class Main {
    
    public static void main (String [] args) {

        // INSTANCIAS
        AnaliseCombinatoria ac = new AnaliseCombinatoria();
        Scanner ent = new Scanner(System.in);

        // VARIAVEIS
        int objetos = 0;
        int posicoes = 0;

        // ENTRADAS
        System.out.print("\nDigite o numero de objetos: ");
        objetos = ent.nextInt();

        System.out.print("\nDigite o numero de posicoes: ");
        posicoes = ent.nextInt();

        if(objetos == posicoes) {
            System.out.println("\nPERMUTACAO: " + ac.permutacao(objetos));
        } else {
            System.out.println("\nA ordem importa (S/N)? ");
            String opc = ent.nextLine();
            opc = ent.nextLine();
            if(opc.toUpperCase().equals("S")){
                System.out.println("\nARRANJO: " + ac.arranjo(objetos, posicoes));
            } else {
                System.out.println("\nCOMBINACAO: " + ac.combinacao(objetos, posicoes));
            }
        }
        ent.close();
    }
}
