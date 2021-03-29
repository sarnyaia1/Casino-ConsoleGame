package CasinoGame;


public class Roulette {
    // üdvözlünk a roulette játékban
    // össze integrálás Casinoval.java és a GameFactory.java
    // válaszd ki a ++szint és a számot
    // addig pörögjön a játék, amég van pénze, vagy amég ki nem akar szállni -----> zsetonra átirni a játékot, mivel a casino fő fizetőeszköze a zseton lesz
    // --- a játék véget ért, elfogyott a zsetonod, köszönjük, hogy velünk játszottál --- <- valami ilyesmi szöveg
    
	private int bankRoll;
	private int spinCount;
	
	public Roulette(int bankRoll) {
	    this.bankRoll = bankRoll;
	    this.spinCount = 0;
	}
	
	public void turn (int bet, String selectedNumber) {
	    int betWinnings = bet * 36;
	    if (this.bankRoll >= bet) {
	         this.bankRoll -= bet;
	         int spinNumber = spin();
	             System.out.println(toString());
	         if ((spinNumber == Integer.parseInt(selectedNumber)) || (spinNumber == 37 && Integer.parseInt(selectedNumber) == 00)) {
	             System.out.println("Az általad válaszott szám nyert, ami nem más mint: " + spinNumber + ".");
	             System.out.println("A nyereményed összege: " + betWinnings + "$.");
	             this.bankRoll += betWinnings;
	         } else {
	             System.out.println("Az általad választott számmal sajnos veszitettél.");
	         }
	         
	    } else {
	        System.out.println("Sajnos nincs elég pénzed a játék folytatásához.");
	    }
	}
	
	private int spin() {
	  
	    this.spinCount++;
	    return (int) Math.floor(Math.random()*10)%38;       
	}
	
	public String toString() {
	    return ("\nRulett:\n" + "Egyenleg = $" + this.bankRoll + "\nJelenlegi kör: " + this.spinCount);
	}
	
	public static void main(String[] args) {
	    Roulette rg1 = new Roulette(20);
	    rg1.turn(10, "10");
	    rg1.turn(20, "20");
	}
	

}
