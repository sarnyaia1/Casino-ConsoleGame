
public class GameFactory { // az azonos�t� sz�m alapj�n legy�rt egy Game t�pus� j�t�kobjektumot
	public static Game getGame(int gameNumber, Player player) {
		if (gameNumber == 1) { 
			return new BlackJack(player);
		} else if(gameNumber == 2) {
		        return new Rulett(player);
		} else if(gameNumber == 3) {
			return new Felkaru(player);
		} else if (gameNumber == 4) { 
			return new HiLo(player);
		} else {
			return null;
		}
		
		
	}
}