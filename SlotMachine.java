package CasinoGame;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine{

	int playerBalance;
	int input;
	String slot1; 
	String slot2;
	String slot3;
	String slot4;
	String slot5;
	private String[] slotSymbols = {"\u2660", "\u2661", "\u2662", "\u2663", "\u2664", "\u2665", "\u2666", "\u2667"};
	
	Random numGenerator = new Random();
	Scanner console = new Scanner(System.in);
	
	public SlotMachine(int playerBalance) {
		this.playerBalance = playerBalance;		//Játékos egyenlegének hozzáadása
	}

	public void welcome() {
		System.out.println("  \n"
				+ "		**************************************\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		*   Üdvözöl a félkarú rabló!!!!!!    *\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		**************************************\n");
	}
	
	public int startGame() {	
		System.out.println("Jelenlegi zsetonjaid: " + playerBalance + "$.");
		System.out.println("Egy pörgetés 10$");
		System.out.println("Nyomd meg az 1-est, ha elkezdenéd a játékot, 2-est, ha kilépnél");
		input = console.nextInt();
		do {
			if(input != 2 && input != 1){
				System.out.println("\nHelytelen válasz! 1: Játék indítás, 2: Kilépés");
				System.out.println("Nyomd meg az 1-est, ha elkezdenéd a játékot, 2-est, ha kilépnél"); // itt kellene egy javítás még!!!!!!!
				input = console.nextInt();
			} else if(input == 1) {
				slot1 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot2 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot3 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot4 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot5 = slotSymbols[numGenerator.nextInt(7) + 0];
				
				
				System.out.println("		------------------------------\n"
						+ "		|     |     |     |     |    |\n"
						+ "		|  " + slot1 + "  |  " + slot2 + "  |  " + slot3 + "  |  " + slot4 + "  |  " + slot5 + " |\n"
						+ "		|     |     |     |     |    |\n"
						+ "		------------------------------");
				
				playerBalance -= 10;
				
				if(slot1 == slot2 && slot1 == slot3 && slot4 == slot5 && slot1 == slot4) {	//5-ös egyezésnél +500$
					System.out.println("Megnyerted a Jackpotot!!");
					playerBalance += 500;
				} else if(	slot1 == slot2 && slot1 == slot3 && slot1 == slot4 || 
							slot1 == slot2 && slot1 == slot3 && slot1 == slot5 ||
							slot1 == slot2 && slot1 == slot4 && slot4 == slot5 ||
							slot1 == slot3 && slot1 == slot4 && slot4 == slot5 ||
							slot2 == slot3 && slot2 == slot4 && slot4 == slot5) {	//4-es egyezésnél +100$
					System.out.println("Nyertél!");
					playerBalance += 100;
					System.out.println("\nFennmaradt egyenleged: " + playerBalance + "\n");
					Scanner kerdes = new Scanner(System.in);
					System.out.println("Nyomd meg az 1-est, ha újra játszanál, és 2-est, ha kiszállnál!");
					int ujraJatszas = kerdes.nextInt();
					if(ujraJatszas == 1) {
						input = 1;
					} else if(ujraJatszas == 2) {
						input = 2;
					}
				} else if (	slot1 == slot2 && slot2 == slot3 ||
							slot1 == slot2 && slot2 == slot4 ||
							slot1 == slot2 && slot2 == slot5 ||
							slot1 == slot3 && slot3 == slot4 ||
							slot1 == slot3 && slot3 == slot5 ||
							slot2 == slot3 && slot3 == slot4 ||
							slot2 == slot3 && slot3 == slot5 ||
							slot2 == slot4 && slot4 == slot5 ||
							slot3 == slot4 && slot4 == slot5){	// 3-as egyezésnél +50$
					System.out.println("Nyertél");
					playerBalance += 50;
					System.out.println("\nFennmaradt egyenleged: " + playerBalance + "\n");
					Scanner kerdes = new Scanner(System.in);
					System.out.println("Nyomd meg az 1-est, ha újra játszanál, és 2-est, ha kiszállnál!");
					int ujraJatszas = kerdes.nextInt();
					if(ujraJatszas == 1) {
						input = 1;
					} else if(ujraJatszas == 2) {
						input = 2;
					}
				} else {
					System.out.println("Sajna ezt buktad");
					System.out.println("\nFennmaradt egyenleged: " + playerBalance + "\n");
					Scanner kerdes = new Scanner(System.in);
					System.out.println("Nyomd meg az 1-est, ha újra játszanál, és 2-est, ha kiszállnál!");
					int ujraJatszas = kerdes.nextInt();
					if(ujraJatszas == 1) {
						input = 1;
					} else if(ujraJatszas == 2) {
						input = 2;
					}
				}
			} else {
				System.out.println("Örülönk, hogy benéztél, további jó szórakozást!");
				input = 3;
			}
		} while(input != 3);
		
		return playerBalance; 		//visszatér a megmaradt zsetonok számával
	}

	
	
	
}
