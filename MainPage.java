package CasinoGame;

public class MainPage {

	public static void main(String[] args) {
		
		Menu welcome = new Menu();  
		welcome.greeting();			//Játékost köszöntő felület megjelenítése
		
		Bank myBalance = new Bank();
		int userBalance = myBalance.beszalloOsszeg();
		System.out.println("\nA rendelkezésedre álló pénzösszeg: " + userBalance + "$\n");	// Beszálló egyenleg megadás és kiíratása
		
		Menu addPlayerName = new Menu();
		Player playerOne = new Player(addPlayerName.nameInput());	//Játékos nevének megadása és tárolása?
		playerOne.setplayerBalance(userBalance);		//Játékos egyenlegének megadása
		int gameEnd = 0;
		
		do {
			Menu selectedGame = new Menu();
			int gamePick = selectedGame.gamesMenu(); //Játékok menüjének megjelenése, kiválasztott játék elindítása
			
			
			Game currentGame; //változó, ami tárolja, hogy mivel játszik aktuálisan a játékos
			currentGame = GameFactory.getGame(gamePick, playerOne); // bekért számnak megfelelően legyártja a játék objektumot
			
			BlackJack blackJack = new BlackJack(playerOne);
			SlotMachine slotMachine = new SlotMachine(userBalance);
			Roulette rulett = new Roulette(userBalance);
			HiLo HiLo = new HiLo(playerOne);
			
			if(gamePick == 1) {
				blackJack.run();
				// System.out.println("Teszt blackjack");
				
			} else if(gamePick == 2) {
				rulett.turn(10, "13");
			} else if (gamePick == 3) {
				slotMachine.welcome();
				userBalance = slotMachine.startGame();
			} else if (gamePick == 4) {
				HiLo.run();
			} else if (gamePick == 10) {
				System.out.println("Várunk legközelebb is!");
				gameEnd = 1;
				System.out.println(gameEnd);
			}
		} while(gameEnd == 0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
