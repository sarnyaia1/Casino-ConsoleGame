package CasinoGame;

public class Card {
	public String color;
	public String type;
	
	public Card(String color, String type) {
		this.color = color;
		this.type = type;
	}
	
	public int getValue() { 
		//getter, az aktuális kártyának mennyi az értéke X,J,D,K=10
		if(this.type == "X" || this.type == "J" || this.type == "Q" || this.type == "K") {
			return 10;
		}else if (this.type == "A") { // fixen 11, változhat, 1 v. 11 lehet, és bármikor módosítható
			//a pakli összértékétől függően
			return 11;
		} else {
			return Integer.parseInt(this.type); // ahanyas szám van a kártyán annyi az értéke, int-be változat
		}
			
	}
}
