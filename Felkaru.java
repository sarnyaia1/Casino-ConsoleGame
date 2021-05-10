import java.util.Random;
import java.util.Scanner;

public class Felkaru extends Game{

	int input;
	private Player player;
	String slot1; 
	String slot2;
	String slot3;
	String slot4;
	String slot5;
	// private String[] slotSymbols = {"\u2660", "\u2661", "\u2662", "\u2663", "\u2664", "\u2665", "\u2666", "\u2667"}; 
	//UTF-8 mentéshez át kellene javítani a teljes dokumentum ékezetes karaktereit
	private String[] slotSymbols = {"0" , "1", "2", "3", "4", "5", "6", "7", "8", "9"};
			
	Random numGenerator = new Random();
	Scanner console = new Scanner(System.in);
	
	public Felkaru(Player player) { //játék példányosítása
		super();
		this.player = player;
	}

	public void welcome() {  //Üdvözlõ felület fogadja a játékost
		System.out.println("  \n"
				+ "		**************************************\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		*   Üdvözöl a félkarú rabló!!!!!!    *\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		**************************************\n");
	}
	
	
	@Override
	public void run() {	//játék futtatása
		System.out.println("Jelenlegi zsetonjaid: " + player.getBalance() + "$.");
		System.out.println("Egy pörgetés 3$");
		System.out.println("Nyomd meg az 1-est, ha elkezdenéd a játékot, 2-est, ha kilépnél");
		int playerBalance = player.getBalance();	//külsõ forrásból egyenleg lekérdetése
		input = console.nextInt();
		do {
			if(playerBalance < 3) {	//elsõ ellenõrzésként megvizsgálja, hogy van-e elég zsetonja ahhoz, hogy játszani tudjon
				System.out.println("Sajnos kevés a zsozsó, itt nem játszhatsz!");
				input = 2;
			}
			if(input != 2 && input != 1){ //ha nem az adott menüpontok közül választ akkor újra megkéri a rendszer, hogy azok közül döntsön
				System.out.println("\nHelytelen válasz! 1: Játék indítás, 2: Kilépés");
				System.out.println("Nyomd meg az 1-est, ha elkezdenéd a játékot, 2-est, ha kilépnél");
				input = console.nextInt();
			} else if(input == 1) {	//ha elindította a játékot, már meg is húzza azt a bizonyos metaforikus kart
				slot1 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot2 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot3 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot4 = slotSymbols[numGenerator.nextInt(7) + 0];
				slot5 = slotSymbols[numGenerator.nextInt(7) + 0];
				
				
				System.out.println("		------------------------------\n"
						+ "		|     |     |     |     |    |\n"
						+ "		|  " + slot1 + "  |  " + slot2 + "  |  " + slot3 + "  |  " + slot4 + "  |  " + slot5 + " |\n"
						+ "		|     |     |     |     |    |\n"
						+ "		------------------------------");	//A félkrarú rablón való pörgetés eredménye egy kis vizuális huncutsággal
				
				playerBalance -= 3;	//minden pörgetés zsetonba kerül, ez itt atomatikusan levonódik
				
				if(slot1 == slot2 && slot1 == slot3 && slot4 == slot5 && slot1 == slot4) {	//5-ös egyezésnél +200$
					System.out.println("Megnyerted a Jackpotot!!");
					playerBalance += 200;  //esetleges nyeremény hozzáadása
					System.out.println("\nFennmaradt egyenleged: " + playerBalance + "\n");
					Scanner kerdes = new Scanner(System.in);	// A rendszer rákérdez, hogy játszana-e tovább, vagy kiszállna
					System.out.println("Nyomd meg az 1-est, ha újra játszanál, és 2-est, ha kiszállnál!");
					int ujraJatszas = kerdes.nextInt();
					if(ujraJatszas == 1) {
						input = 1;
					} else if(ujraJatszas == 2) {
						input = 2;
					}
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
							slot3 == slot4 && slot4 == slot5){	// 3-as egyezésnél +30$
					System.out.println("Nyertél");
					playerBalance += 30;
					System.out.println("\nFennmaradt egyenleged: " + playerBalance + "\n");
					Scanner kerdes = new Scanner(System.in);
					System.out.println("Nyomd meg az 1-est, ha újra játszanál, és 2-est, ha kiszállnál!");
					int ujraJatszas = kerdes.nextInt();
					if(ujraJatszas == 1) {
						input = 1;
					} else if(ujraJatszas == 2) {
						input = 2;
					}
				} else {	//Ha nincs legalább 3-as egyezés, akkor bukta a kört, levonódik a pörgetés ára, és eldöntheti, hogy pörget-e újra
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
			} else {	//Ha a menüben a 2-est választja akkor befejezõdik a játék és visszatér a fõmenübe, ahol a játékok közül választhat
				System.out.println("Örülönk, hogy benéztél, további jó szórakozást!");
				input = 3;
			}
		} while(input == 1 || input == 2); //addig fut a játék amíg a megfelelõ menüpontokat választja és ki nem lép
		
		
	}
}
	