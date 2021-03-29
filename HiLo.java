package CasinoGame;

import java.util.Scanner;

public class HiLo extends Bank {
	protected String name;
	protected Player computer;
	private Player player;
	boolean first = true;
	
	public HiLo(Player player) {
		super();
		this.player = player;
	}

	public void run() {
		int tet = 0;
		HiLoCard card = null;
		HiLoCard newcard;
		Scanner be = new Scanner(System.in);
		while(tet==0){
			card = new HiLoCard();
			System.out.println("Jelenlegi kártyád: "+card.getSuit()+" "+card.getValue());
			System.out.println("Jelenlegi zsetonod: "+ this.player.getBalance());
			System.out.println("Kérek egy tétet!");
			tet = be.nextInt();
			if (tet<0 || tet>this.player.getBalance()) {
				tet = 0;
				System.out.println("Ez nem lesz elég..");
			}
		}
		this.player.addBalance(-tet);
		System.out.println("Jelenlegi zsetonod: "+this.player.getBalance());
		while(true){
			System.out.println("Jelenlegi kártyád: "+card.getSuit()+" "+card.getValue());
			System.out.println("Jelenlegi tét: "+ tet);
			System.out.println("Kisebb vagy nagyobb?");
			System.out.println("   1. Kisebb!");
			System.out.println("   2. Nagyobb!");
			if (first != true) {
				System.out.println("   3. Kiszállok!");
			}
			int dontes = be.nextInt();
			System.out.println(" - - - - - - - - - - - - - - - -");
			boolean nyert = false;
			newcard = new HiLoCard();
			System.out.println("Új kártyád: "+newcard.getSuit()+" "+newcard.getValue());
			if (dontes == 1) {
				if (card.getRealValue() > newcard.getRealValue()) {
					nyert = true;
				}
			}
			if (dontes == 2) {
				if (card.getRealValue() < newcard.getRealValue()) {
					nyert = true;
				}
			}
			if (dontes == 3 && !first) {
				this.player.addBalance(tet);
				break;
			}
			if (nyert){
				card = newcard;
				System.out.println("Nyertél!");
				tet = tet*2;
			}
			else {
				System.out.println("Vesztettél!");
				break;
			}
			first = false;
		}
	}
}