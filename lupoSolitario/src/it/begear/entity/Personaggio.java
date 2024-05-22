package it.begear.entity;

public class Personaggio {
		
		private int combattivita;
		private int resistenza;
		
		public int getCombattivita() {
			return combattivita;
		}
		public void setCombattivita(int combattivita) {
			this.combattivita = combattivita;
		}
		public int getResistenza() {
			return resistenza;
		}
		public void setResistenza(int resistenza) {
			this.resistenza = resistenza;
		}
		
		public Personaggio(int combattivita, int resistenza) {
			super();
			this.combattivita = combattivita;
			this.resistenza = resistenza;
		}
		
		public String toString() {
			return "Personaggio [combattivita=" + combattivita + ", resistenza=" + resistenza + "]";
		}
}
