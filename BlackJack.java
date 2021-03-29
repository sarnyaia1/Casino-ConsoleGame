package CasinoGame;

import java.util.Scanner;

import CasinoGame.Card;
import CasinoGame.Game;

import java.util.*;

public class BlackJack extends Game { // az absztrakt Game osztályunkat terjetszjük ki extends-el, öröklés, a Game osztályból egy új osztály származtatása
	private Player computer; // player típusú osztály, aki ellen játszunk
	private Player player; // mi
	private boolean isStopped = false; // változó, amiben tároljuk, hogy megálltunk-e
	private FrenchCardDeck deck; // franciakártya pakli változója
	private ArrayList<Card> playerCardList = new ArrayList<Card>(); // a mi paklink, ami a kezünkben van
	private ArrayList<Card> computerCardList = new ArrayList<Card>(); // osztó paklija

	public BlackJack(Player player) { // csak a mi player objektumunkat várja, mert az osztót a játék generálja
		this.player = player;
		this.computer = new Player("PC Osztó");
		this.deck = new FrenchCardDeck(); // itt hozzunk létre az új franciakártya pakli objektumunkat a játékhoz
		
		/*
		System.out.println("  \n"
				+ "		**************************************\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		*   Üdv a BlackJack játékban!!!!!    *\n"
				+ "		*                                    *\n"
				+ "		*                                    *\n"
				+ "		**************************************\n"); //üdvözlő felület*/
	
	}
	
	/*
	public void cardHand(){
		char[] kartyaTipusok = {'\u2663', '\u2660', '\u2665', '\u2666'}; // Sorban: treff, pikk, kőr, káró
		char[] kartyaPakli = {'2', '3', '4' , '5', '6', '7', '8', '9', 'X', 'J', 'Q', 'K', 'A'}; //X = 10 és így csak karakter tömb kell
		int szam1 = (int)((Math.random() * (10 - 0)) + 0);
		int szam2 = (int)((Math.random() * (10 - 0)) + 0);
		int szam3 = (int)((Math.random() * (10 - 0)) + 0);
		int symbol1 = (int)((Math.random() * (4 - 0)) + 0);
		int symbol2 = (int)((Math.random() * (4 - 0)) + 0);
		int symbol3 = (int)((Math.random() * (4 - 0)) + 0);
		
		
		System.out.println("----------     ----------\n"
				+ "|        |     |        |\n"
				+ "|   " + kartyaPakli[szam1] + "    |     |   " + kartyaPakli[szam2] + "    |\n"
				+ "|   " + kartyaTipusok[symbol1] + "    |     |   " + kartyaTipusok[symbol2] + "    |\n"
				+ "|   " + kartyaPakli[szam1] + "    |     |   " + kartyaPakli[szam2] + "    |\n"
				+ "|        |     |        |\n"
				+ "----------     ----------");

	
		System.out.println("----------     ----------\n"
				+ "|        |     |        |\n"
				+ "|   " + kartyaPakli[szam3] + "    |     |        |\n"
				+ "|   " + kartyaTipusok[symbol3] + "    |     |        |\n"
				+ "|   " + kartyaPakli[szam3] + "    |     |        |\n"
				+ "|        |     |        |\n"
				+ "----------     ----------");
	}
	*/
	
	public void run() { // run metódus elindítja a játokot
		Card newCard; // a newCard változó az újonnan kiosztott kártyát tárolja

		newCard = this.handOut(this.player); //1. lap kiosztása
		System.out.println("Az 1. lapod: " + newCard.color+ ", " + newCard.type);
		newCard = this.handOut(this.player); //2. lap kioszt�sa a j�t�kosnak
		System.out.println("A 2. lapod: " + newCard.color + ", " + newCard.type);

		//oszt� 2 k�rty�j�nak kioszt�sa:
		newCard = this.handOut(this.computer); // 1. lap kioszt�sa az oszt�nak
		newCard = this.handOut(this.computer); //2. lap az oszt�nak
		
		System.out.println("- - - - - - - - - - - - - - - - -");
		System.out.println("A kártyáid összértéke: " + this.getCardsValue(this.player)); // getterrel lek�rj�k a lapok �ssz�rt�k�t
		System.out.println(" - - - - - - - - - - - - - - - - -");

		do { // addig megyünk még vége nincs a játéknak
			Scanner in = new Scanner(System.in);
			System.out.println("Kérsz még vagy megállsz?");
			System.out.println("   1. Kérek még!");
			System.out.println("   2. Megállok!");
			int dontes = in.nextInt();
			System.out.println(" - - - - - - - - - - - - - - - -");
			
			if (dontes == 2) { // ha 2-est v�lasztunk, akkor meg�ll a j�t�k
				this.isStopped = true;
			} else {
				newCard = this.handOut(this.player); // k�vetkez� lap kioszt�sa
				System.out.println("A következő lapod: " + newCard.color + ", " + newCard.type);
			}
			
			if (this.getCardsValue(this.computer) <= 17) { //az oszt� addig kap k�rty�t, am�g a lapjainak �ssz�rt�ke 17 vagy ann�l kisebb
				newCard = this.handOut(this.computer);
			}

			System.out.println(" - - - - - - - - - - - - - - - -");
			System.out.println("Az eddigi kártyáid: " + this.getCards()); //getter a k�rty�k lek�rdez�s�re
			System.out.println("Az összpontszámod: " + this.getCardsValue(this.player)); // getter az �sszpontsz�m lek�rdez�s�re
			
			
			
		} while (!isStopped && this.getCardsValue(this.player) < 21); 
		// addig megy a j�t�k am�g meg nem �llunk, vagy am�g el nem �rj�k a legal�bb 21-et
		System.out.println(" - - - - - - - - - - - - - - - -");
		System.out.println("Az Osztó összpontszáma: " + this.getCardsValue(this.computer));
		
		if ((this.getCardsValue(this.computer) > 21 && this.getCardsValue(this.player) <= 21) 
			|| (this.getCardsValue(this.player) <= 21 && 21 - this.getCardsValue(this.player) < 21 - this.getCardsValue(this.computer))) {
			// ha az oszt� lapjainak �rt�ke t�bb, mint 21, �s nek�nk nincs t�bb, mint 21, akkor nyert�nk
			//ha kevesebb�nk van, mint 21, �s k�zelebb vagyunk a 21-hez mint az oszt�, akkor is nyert�nk
			//-d�ntetlen m�g hi�nyzik (kell bele?)
			System.out.println("Gratulálok, nyertél!");
		} else { // minden m�s esetben veszt�nk
			System.out.println("Sajnos vesztettél! :(");
		}
	}
	
	public Card handOut(Player player) { // k�vetkez� k�rtya kioszt�sa met�dus
		//random indexet gener�lunk 0 �s a pakliban l�v� k�rty�k sz�ma k�z�tt (52 lapos a pakli kezdetben)
		int randomIndex = 0 + (int)(Math.random() * (this.deck.cards.size() - 0));
		Card newCard = this.deck.cards.get(randomIndex); //random index� k�rty�t kiv�lasztjuk a paklib�l
		this.deck.cards.remove(randomIndex); // a kiosztott lapot kiveszz�k a paklib�l, �gy mindig 1-gyel kevesebb lesz benne
		Player playerName = player;
	
		if (playerName == computer) { // ha oszt� a olayer�nk, akkor az � paklij�hoz adjunk hozz�
			this.computerCardList.add(newCard);
		} else { // m�s esetben a saj�tunkhoz
			this.playerCardList.add(newCard);		
		}
		
		return newCard; // �jonnan kiosztott k�rty�val t�r�nk vissza
	}
	
	private int getCardsValue(Player player) { // aktu�lis j�t�kos kez�ben l�v� k�rty�k �sszeg�vel t�r�nk vissza
		ArrayList<Card> cardsDeck; 
		Player playerName = player;
		if (playerName == computer) { // ha oszt� a j�t�kos, akkor az � paklij�t vessz�k alapul
			cardsDeck = this.computerCardList;
		}else { // a j�t�kos paklij�t vessz�k alapul
			cardsDeck = this.playerCardList;
		}
		
		int sum = 0; // a sum t�rolja a pakli k�rty�inak az �sszeg�t
		for(int i=0; i<cardsDeck.size(); i++) { // v�gig megy�nk a paklin
			sum += cardsDeck.get(i).getValue(); // minden egyes k�rty�nak hozz�adjuk az �rt�k�t a sum-hoz
		}
		
		return sum; // visszat�r�nk az �sszpontsz�mmal
	}
	
	private String getCards() {	// a mi k�rty�inknak a ki�rat�s�hoz kell a met�dus	
		String cards = "";
		for(int i=0; i<this.playerCardList.size(); i++) { // v�gigmegy�nk az �sszes k�rty�nkon, ami a kez�nkben van
			cards += this.playerCardList.get(i).color + " " + this.playerCardList.get(i).type; // sz�n �s sz�m ki�rat�shoz kell a getter
			if(i < this.playerCardList.size() - 1) { // ha nem az utols� k�rtya a paklinkban,
				cards += ", "; //  akkor m�g egy vessz�t rakunk a v�g�re
			}
		}
		
		return cards; // visszat�r a ki�r�shoz sz�ks�ges sz�n �s sz�m kombin�ci�kkal
	}
}
