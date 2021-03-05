package CasinoGame;

public class BlackJack {
	
	public void kartyaOsztas(){
		char[] kartyaTipusok = {'♣', '♠', '♢', '♡'};
		char[] kartyaPakli = {'1', '2', '3', '4' , '5', '6', '7', '8', '9', 'X', 'J', 'Q', 'K', 'A'};
		
		System.out.println("----------     ----------");
		System.out.println("|        |     |        |");
		System.out.println("|   "+kartyaPakli[5]+"    |     |   "+kartyaPakli[10]+"    |");
		System.out.println("|   "+kartyaTipusok[1]+"    |     |   "+kartyaTipusok[3]+"    |");
		System.out.println("|   "+kartyaPakli[5]+"    |     |   "+kartyaPakli[10]+"    |");
		System.out.println("|        |     |        |");
		System.out.println("----------     ----------");
	
		System.out.println("----------     ----------");
		System.out.println("|        |     |        |");
		System.out.println("|   "+kartyaPakli[2]+"    |     |        |");
		System.out.println("|   "+kartyaTipusok[0]+"    |     |        |");
		System.out.println("|   "+kartyaPakli[2]+"    |     |        |");
		System.out.println("|        |     |        |");
		System.out.println("----------     ----------");
	}
 
}
