package CasinoGame;

import java.util.Scanner;

public class Bank {
	
	public int beszalloOsszeg() {	
		Scanner bet = new Scanner(System.in);	//Valamiért nem tudom lezárni scannereket...
		int beszallo;
		
		do {
			System.out.println("Add meg mekkorra összeggel szeretnél beszállni (min. 50$ - max. 1000$)");
			beszallo = bet.nextInt();
		} while(beszallo < 50 || beszallo > 1000);	// Esetleg kiírni, hogy túl nagy/ túl kicsi az összeg
		
		return beszallo;
	}
	
	/*  
	public String toString(int dealer){
		return "\nA rendelkezésedre álló pénzösszeg: " + dealer + "$\n";		//Lecseréltem másik módszerre
	}
	*/
	
}
