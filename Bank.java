package CasinoGame;

import java.util.Scanner;

public class Bank {
	
	public double beszalloOsszeg() {
		Scanner bet = new Scanner(System.in);
		double beszallo;
		
		do {
			System.out.println("Add meg mekkorra �sszeggel szeretn�l besz�llni (min. 5$ - max. 1000$)");
			beszallo = bet.nextDouble();
		} while(beszallo < 5 || beszallo > 1000);
		
		
		//System.out.println("A besz�ll� �sszeg: " + beszallo);
		return beszallo;
	}
	
	public String toString(double dealer){
		System.out.println("");
		return "A rendelkez�sedre �ll� p�nz�sszeg: " + dealer + "$";
	}

}
