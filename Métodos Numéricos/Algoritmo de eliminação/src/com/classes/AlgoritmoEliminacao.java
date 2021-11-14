package com.classes;

import java.util.Scanner;

public class AlgoritmoEliminacao {
	
	// ATRIBUTOS
	static int n;
	static double[][] A = new double[6][6];
	static double[] y = new double[6];
	static double[] x = new double[6];
	
	// MAIN
	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		
		System.out.print("==== ALGORITMO DE ELIMINACAO ====");
		System.out.print("\n\nDigite a ordem da matriz: ");
		n = ent.nextInt();
		
		if(!(n >= 2 && n <= 5)) {
			System.out.println("MATRIZ NAO SUPORTADA, OU ENTRADA INVALIDA!");
			System.exit(0);
		}
		
		System.out.print("\n* Inserindo os dados na matriz *\n\n");
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.printf("Digite o valor de A[%d][%d]: ", i, j);
				A[i][j] = ent.nextDouble();
			}
			System.out.printf("Digite o valor de y[%d]: ", i);
			y[i] = ent.nextDouble();
		}		
		
		System.out.print("\n==== MATRIZ ANTES DA ELIMINACAO ====");
		System.out.print("\n" + imprimeMatriz(A, y, n));
		
		eliminacao(n, A, y);
		
		System.out.print("\n==== MATRIZ DEPOIS DA ELIMINACAO ====");
		System.out.print("\n" + imprimeMatriz(A, y, n));
	
		System.out.print("\n==== RESOLUCAO ====");
		
		resolucao(n, A, y, x);
		
		System.out.print("\n\nS = {");
		for(int i = 1; i <= n; i++) {
			System.out.print(x[i]);
			if(i != n) {
				System.out.print(", ");
			} else {
				System.out.print("}");
			}
		}
		ent.close();
	}
	
	// METODOS
	public static double[][] eliminacao(int n, double[][] A, double[] y) {
		double m;
		for(int k = 1;k <= n-1;k++) {
			for(int i = k+1; i <= n;i++) {
				m = A[i][k] / A[k][k];
				A[i][k] = 0;
				for(int j = k+1; j <= n;j++) {
					A[i][j] = A[i][j] - m * A[k][j];
				}
				y[i] = y[i] - m * y[k];
			}
		}
		return A;
	}
	
	public static double[] resolucao(int n, double[][] A, double[] y, double[] x) {
		x[n] = y[n]/A[n][n];
		
		for(int k = n-1; k >= 1; k--) {
			double s = 0;
			for(int j = k+1; j <= n; j++) {
				s = s + A[k][j] * x[j];
			}
			x[k] = (y[k] - s)/A[k][k];
		}
		return x;
	}
	
	public static String imprimeMatriz(double[][] A, double[] y, int n) {
		String msg = "\n";
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				msg += "\t" + A[i][j] + "";
			}
			msg += "\t" + y[i] + "\n";
		}
		return msg;	
	}
}
