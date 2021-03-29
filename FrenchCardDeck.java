package CasinoGame;

import java.util.ArrayList;

public class FrenchCardDeck { // franciakártya osztály, paklit tartalmazza
	public ArrayList<Card> cards = new ArrayList<Card>(); //pakli
	private String[] colors = {"\u2663", "\u2660", "\u2665", "\u2666"}; // Sorban: treff, pikk, kőr, káró
	private String[] types = {"2", "3", "4" , "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A"}; //X = 10 design miatt
	
	
	public FrenchCardDeck() { // dupla for-ral legyártjuk az összes színhez tartozó összes számot (4db minden számból, 52db-os pakli)
		for(int i=0; i<this.colors.length; i++) { 
			for(int j=0; j<this.types.length; j++) { 
				// a paklihoz hozzáadunk egy új kártya objektumot az aktuális szín és aktuális típusból 
				this.cards.add(new Card(this.colors[i], this.types[j]));
			}
		}
	}
	
	/*  LAPOK GENERÁLÁSA
	int szam1 = (int)((Math.random() * (10 - 0)) + 0);  // Lapokon lévő számok és szimbólumok
	int szam2 = (int)((Math.random() * (10 - 0)) + 0);
	int szam3 = (int)((Math.random() * (10 - 0)) + 0);
	int symbol1 = (int)((Math.random() * (4 - 0)) + 0);
	int symbol2 = (int)((Math.random() * (4 - 0)) + 0);
	int symbol3 = (int)((Math.random() * (4 - 0)) + 0);
	*/
	
	
}
