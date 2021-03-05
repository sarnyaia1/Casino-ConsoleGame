package CasinoGame;

public class MainPage {

	public static void main(String[] args) {
		 
		Design welcome = new Design();
		welcome.greeting();
		
		Bank myBalance= new Bank();
		System.out.println(myBalance.toString(myBalance.beszalloOsszeg()));
		System.out.println("");
		
		Design casinoGame = new Design();
		BlackJack blackJack = new BlackJack();
		
		if(casinoGame.gamesMenu() == 1) {
			blackJack.kartyaOsztas();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
