package CasinoGame;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

	Random generator = new Random();
	Scanner console = new Scanner(System.in);
	
	
	int input;
	int tokens = 100;
	
	int slot1; 
	int slot2;
	int slot3;
	
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
	
	public void felKaru() {
		do {
			
			System.out.println("Jelenlegi zsetonjaid: " + tokens + " tokens.");
			System.out.println("Nyomd meg az 1-est, ha elkezdenéd a játékot, 2-est, ha kilépnél");
			
			input = console.nextInt();
			
			slot1 = generator.nextInt(9) + 1;
			slot2 = generator.nextInt(9) + 1;
			slot3 = generator.nextInt(9) + 1;
			
			
			System.out.println("		------------------\n"
					+ "		|     |     |    |\n"
					+ "		|  " + slot1 + "  |  " + slot2 + "  |  " + slot3 + " |\n"
					+ "		|     |     |    |\n"
					+ "		------------------");
			
			
			if(slot1 == slot2 && slot1 == slot3) {
				System.out.println("You win!!");
				tokens += 10;
			} else if(slot1 == slot2 || slot1 == slot3 || slot2 == slot3) {
				System.out.println("You win!");
				tokens += 5;
			} else {
				System.out.println("You lose");
				tokens -= 3;
			}
		} while(input == 1);
	}

	
	
	
}
