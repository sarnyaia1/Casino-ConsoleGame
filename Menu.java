package CasinoGame;

import java.util.Scanner;

import CasinoGame.Player;

public class Menu {

	
	public void greeting() {
		System.out.println("\n"
				+ "		**************************************\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		*   Üdvözöllek a Casino játékban!    *\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		**************************************\n"
				+ "");
	}
	
	public String nameInput() {
		Scanner be = new Scanner(System.in);
		String userName = "";
		
		do {		// Ne mehessen tovább név nélkül
			System.out.println("Kérlek add meg a neved:");
			userName = be.nextLine();		// ezt majd eltárolnánk fájlban, jelszóval, zsetonnal együtt, és így vezetve lenne, hogy ki játszik
									//Player player = new Player(userName);	//így onnan tudná folytatni a játékos, ahol abbahagyta a zsetongyűjtést)
		} while(userName == "");
		
												
		System.out.println("\nJó, hogy itt vagy " + userName + "! Csináljunk egy kis pénzt!\n"); // +"! A kezdő egyenleged: " + player.getBalance() + " zseton.");
		// Addig játszunk amég van zseton, vagy amég akarunk játszani, de még csak 1x fut le
		
		return userName;
	}
	
	
	public int gamesMenu() {
		Scanner jatek = new Scanner(System.in);
		int kivalasztottJatek;
		
		System.out.println("Elérhető játékok:");
		System.out.println("1:	BlackJack");
		System.out.println("2:	Rulett");
		System.out.println("3:	Félkarú rabló");
		System.out.println("4:	Hi-Lo");
		System.out.println("5:	Kilépés a Casinóból!\n");
		
		do { 
			System.out.println("Kérlek válaszd ki melyik játékkal szeretnél játszani");
			kivalasztottJatek = jatek.nextInt();
			if(kivalasztottJatek < 1 || kivalasztottJatek > 5) { //Amíg nem létező játékot ad meg nem mehet tovább
				System.out.println("\nNem jó számot adtál meg, kérlek a felsoroltak közül válassz!!!");
				kivalasztottJatek = 0;
			} else if (kivalasztottJatek == 1) {
				kivalasztottJatek = 1;
				System.out.println("Akkor vágjunk bele a BlackJack-be!!");
			} else if(kivalasztottJatek == 2){
				kivalasztottJatek = 2;
				System.out.println("Akkor pörgessük meg azt a kereket!!");
			} else if (kivalasztottJatek == 3){
				kivalasztottJatek = 3;
				System.out.println("Akkor fosszuk ki azt a Félkarú rablót!!");
			} else if (kivalasztottJatek == 4) {
				kivalasztottJatek = 4;
				System.out.println("Akkor tippeljünk egyet!");
			} else if (kivalasztottJatek == 5) {
				System.out.println("Viszlát!");
				kivalasztottJatek = 10;
			}
		} while (kivalasztottJatek <= 1);
		
		return kivalasztottJatek;
	}
	
	
	
	
}
