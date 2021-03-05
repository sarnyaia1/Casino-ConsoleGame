package CasinoGame;

import java.util.Scanner;

public class Design {
	
	public void cardDesign(){
		char[] kartyaTipusok = {'♣', '♠', '♢', '♡'};
		char[] kartyaPakli = {'1', '2', '3', '4' , '5', '6', '7', '8', '9', 'X', 'J', 'Q', 'K', 'A'};
		
		System.out.println("----------     ----------");
		System.out.println("|        |     |        |");
		System.out.println("|   "+kartyaPakli[5]+"    |     |   "+kartyaPakli[10]+"    |");
		System.out.println("|   "+kartyaTipusok[1]+"    |     |   "+kartyaTipusok[3]+"    |");
		System.out.println("|   "+kartyaPakli[5]+"    |     |   "+kartyaPakli[10]+"    |");
		System.out.println("|        |     |        |");
		System.out.println("----------     ----------");
	
		System.out.println("----------     ----------");
		System.out.println("|        |     |        |");
		System.out.println("|   "+kartyaPakli[2]+"    |     |        |");
		System.out.println("|   "+kartyaTipusok[0]+"    |     |        |");
		System.out.println("|   "+kartyaPakli[2]+"    |     |        |");
		System.out.println("|        |     |        |");
		System.out.println("----------     ----------");
	}
	
	public void greeting() {
		System.out.println("		**************************************");
		System.out.println("		*                                    *");
		System.out.println("		*                                    *");
		System.out.println("		*   Üdvözöllek a casino játékban!    *");
		System.out.println("		*                                    *");
		System.out.println("		*                                    *");
		System.out.println("		**************************************");
		System.out.println("");
	}
	
	public int gamesMenu() {
		Scanner jatek = new Scanner(System.in);
		int kivalasztottJatek;
		
		System.out.println("Elérhető játékok:");
		System.out.println("1:	BlackJack");
		System.out.println("2:	Rulett");
		System.out.println("3:	Félkarú rabló");
		
		do {
			System.out.println("Kérlek válaszd ki melyik játékkal szeretnél játszani");
			kivalasztottJatek = jatek.nextInt();
		} while(kivalasztottJatek < 1 || kivalasztottJatek > 3);
		
		
		if(kivalasztottJatek == 1) {
			System.out.println("Akkor vágjunk bele a BlackJack-be!!");
		} else if(kivalasztottJatek == 2){
			System.out.println("Akkor pörgessük meg azt a kereket!!");
		} else {
			System.out.println("Akkor fosszuk ki azt a Félkarú rablót!!");
		}
		
		return kivalasztottJatek;
	}
	

}
