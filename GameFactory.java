package CasinoGame;

public class GameFactory { // az azonosító szám alapján legyárt egy Game típusú objektumot
	
	public static Game getGame(int gameNumber, Player player) {
		if (gameNumber == 1) { 				//Blackjack
			return new BlackJack(player);
		} else if (gameNumber == 2) {		//Rulett
			//return new Roulette(player);
		} else if (gameNumber == 3) {		//Félkarú rabló
			//return SlotMachine(player);
		} else {							//Alsó-Felső
			//return HiLo(player);
		}
		
		return null;
	}
}