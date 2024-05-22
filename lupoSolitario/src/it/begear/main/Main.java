package it.begear.main;

import java.util.Scanner;
import it.begear.utility.Combattimento;

import it.begear.entity.Personaggio;

public class Main {

	public static void main(String[] args) {
		
		int[][][] tCombattimento = {
				//		<=11	 -10/-9  -8/-7 -6/-5 -4/-3  -2/-1  0/0    +1/+2  +3/+4  +5/+6  +7/+8   +9/+10  >=11
				/*0*/	{{6,0},  {7,0},  {8,0},{9,0},{10,0},{11,0},{12,0},{14,0},{16,0},{18,0},{100,0},{100,0},{100,0}},
				/*1*/	{{0,100},{0,100},{0,8},{0,6},{1,6}, {2,5}, {3,5}, {4,5}, {5,4}, {6,4}, {8,3},  {8,3},  {9,3}},
				/*2*/	{{0,100},{0,8},  {0,7},{1,6},{2,5}, {3,5}, {4,4}, {5,4}, {6,3}, {7,3}, {9,3},  {9,3},  {10,2}},
				/*3*/	{{0,8},  {0,7},  {1,6},{2,5},{3,5}, {4,4}, {5,4}, {6,3}, {7,3}, {8,3}, {10,2}, {10,2}, {11,2}},
				/*4*/	{{0,8},  {1,7},  {2,6},{3,5},{4,4}, {5,4}, {6,3}, {7,3}, {8,2}, {9,2}, {11,2}, {11,2}, {12,2}},
				/*5*/	{{1,7},  {2,6},  {3,5},{4,4},{5,4}, {6,3}, {7,2}, {8,2}, {9,2}, {10,2},{12,2}, {12,2}, {14,1}},
				/*6*/	{{2,6},  {3,6},  {4,5},{5,4},{6,3}, {7,2}, {8,2}, {9,2}, {10,2},{11,1},{14,1}, {14,1}, {16,1}},
				/*7*/	{{3,5},  {4,5},  {5,4},{6,3},{7,2}, {8,2}, {9,1}, {10,1},{11,1},{12,0},{16,0}, {16,0}, {18,0}},
				/*8*/	{{4,4},  {5,4},  {6,3},{7,2},{8,1}, {9,1}, {10,0},{11,0},{12,0},{14,0},{18,0}, {18,0}, {100,0}},
				/*9*/	{{5,3},  {6,3},  {7,2},{8,0},{9,0}, {10,0},{11,0},{12,0},{14,0},{16,0},{100,0},{100,0},{100,0}},
				};  
		
		int [][] forza = {
				{-12,-11},{-10,-9},{-8,-7},{-6,-5},{-4,-3},{-2,-1},{0,0},{1,2},{3,4},{5,6},{7,8},{9,10},{11,12},
		};
		
		Personaggio nemico = new Personaggio(20,50);
		Scanner scan = new Scanner(System.in);
		System.out.print("Inserisci combattività e resistenza del lupo: ");
		int comb = scan.nextInt();
		int res = scan.nextInt();
		Personaggio lupo = new Personaggio(comb,res);
		int puntiForza = lupo.getCombattivita() - nemico.getCombattivita();
		int indice = 0;
		for(int i=0; i<13; i++) {
			for(int k=0; k<2; k++) {
				if(puntiForza == forza[i][k] || (puntiForza<-12 && i==0) || (puntiForza>12 && i==12)) {
					indice = i;
				}
			}
		}
		
		Combattimento combat = new Combattimento();
		int numero = combat.numeroDestino();
		boolean vit = true;
		
		do{
			for(int i=0; i<=numero; i++) {
				for(int k=0; k<=indice; k++) {
					if(k==indice && i==numero) { 
						for(int j=0; j<2; j++) {
								switch(j) {
									case 0: 
										combat.puntiComb(nemico, tCombattimento[i][k][j]);
										System.out.println("Resistenza nemico: " + nemico.getResistenza());
										break;
									case 1:
										combat.puntiComb(lupo, tCombattimento[i][k][j]);
										System.out.println("Resistenza lupo: " + lupo.getResistenza());
										break;
								}
						}
						vit = combat.stampaPerdente(lupo, nemico);
						System.out.println("\n");
						if(vit) {
							numero = combat.numeroDestino();
						}
					}
				}
			}
		}while(vit);
		
		
	
	}
}
