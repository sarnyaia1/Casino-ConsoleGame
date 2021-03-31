package CasinoGame;

public class Player {
	
	private String playerName;
	private int playerBalance;		// zsetonok mennyisége
	//public String password;		// ha meglesz a fájl beolvasás akkor még lesz egy private jelszó
	
	public Player(String playerName) { // konstruktor, megadott névvel inicializáljuk, + a megadott pénzösszeg
		this.playerName = playerName;
		//this.playerBalance = playerBalance;
	}
	

	public int getplayerBalance() { // getter, lekérjük a játékos zsetonjait
		return this.playerBalance;
	}
	
	public void addBalance(int amount) { // nem setter, megadjuk, hogy mennyivel növeljük, vagy csökkentjük a zsetonok értékeit
		this.playerBalance += amount;
	}

	public void setplayerBalance(int playerBalance) { // setter, megadjuk, hogy mennyivel növeljük, vagy csökkentjük a zsetonok mennyiségét
		this.playerBalance = playerBalance;
	}
}
