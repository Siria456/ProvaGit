package it.begear.utility;

import java.util.Scanner;

import it.begear.entity.Personaggio;

public class Combattimento {
		
		public int numeroDestino() {
			
			Scanner scan = new Scanner(System.in);
			int numero = 0;
			
			do {
				System.out.print("Scegli numero del destino da 0 a 9:  ");
				numero = scan.nextInt();
				if(numero<0 || numero>9) {
					System.out.println("Numero non valido");
				}
			}while(numero<0 || numero>9);
			
			return numero;
		}
		
		public void puntiComb(Personaggio per, int c) {
			
			if(c == 100) {
				per.setResistenza(-1);
			}else {
				per.setResistenza(per.getResistenza() - c);
			}
		}
		
		public boolean stampaPerdente(Personaggio lupo, Personaggio nemico) {
			
			if(lupo.getResistenza()<1) {
				System.out.println("Il lupo è morto");
				return false;
			}else if(nemico.getResistenza()<1){
				System.out.println("Il nemico è morto");
				return false;
			}
			
			return true;
		}
}
