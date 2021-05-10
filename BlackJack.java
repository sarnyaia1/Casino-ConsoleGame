import java.util.*;

public class BlackJack extends Game { // az absztrakt Game oszt�lyunkat terjetszj�k ki extends-el, �r�kl�s, a Game �soszt�lyb�l egy �j oszt�ly sz�rmaztat�sa
        private Player computer; // player t�pus� oszt�, aki ellen j�tszunk
        private Player player; // a j�t�kos
        private boolean isStopped = false; // v�ltoz�, amiben t�roljuk, hogy meg�lltunk-e
        private FrenchCardDeck deck; // franciak�rtya pakli v�ltoz�ja
        private ArrayList<Card> playerCardList = new ArrayList<Card>(); // a mi paklink, ami a kez�nkben van
        private ArrayList<Card> computerCardList = new ArrayList<Card>(); // oszt� paklija
        private boolean rulesDone = false;
        
        public BlackJack(Player player) { // csak a mi player objektumunkat v�rja, mert az oszt�t a j�t�k gener�lja
                this.player = player;
                this.computer = new Player("Oszt�", 50);
                this.deck = new FrenchCardDeck(); // itt hozzunk l�tre az �j franciak�rtya pakli objektumunkat a j�t�khoz
                Collections.shuffle(this.deck.cards);
                
                System.out.println("  \n"
                                + "             **************************************\n"
                                + "             *                                    *\n"
                                + "             *     �dv a Black Jack j�t�kban!     *\n"
                                + "             *                                    *\n"
                                + "             **************************************\n");
                //System.out.println(" ");
        }
        
        public void run() { // run met�dus elind�tja a j�t�kot
                int result; // gy�ztes �llapot t�rol�sa
                int multiplier = 2; // gy�zelem eset�n a szorz�
                
                
                if(!this.rulesDone && this.readGameRules()) {
                        System.out.println("  A Black Jack l�nyege, hogy 21 pontot szerezz a k�rty�idb�l. \n"
                                                         + " - Az Oszt� ellen j�tszol.\n" 
                                                         + " - Akinek a k�rty�inak az �sszege 21, vagy k�zelebb van a 21-hez, az nyer.\n"
                                                         + " - 2 k�rty�t kapsz a j�t�k elej�n, ut�na te d�nt�d el, hogy k�rsz-e m�g, vagy meg�llsz.\n"
                                                         + " - Azonos pontsz�m eset�n, vagy ha mindketten besokalltok, d�ntetlen az eredm�ny, a t�ted visszakapod.\n"
                                                         + " - Gy�zelem eset�n a t�ted k�tszeres�t nyered vissza, Black Jack (21) eset�n a t�ted h�romszoros�t.\n"
                                                         + " - Veres�g eset�n elveszted a t�ted.\n"
                                                         + " \n"
                                                         + "  Sok sikert a j�t�khoz!");
                        Scanner in = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Nyomj entert, ha kezd�dhet a j�t�k!");
                        in.nextLine();
                        this.rulesDone = true;
                }
                
                this.getStake(this.player); // t�t bek�r�se
                
                System.out.println("  1. k�rty�d oszt�sa...\r"); // hely�re ugrik be a k�rtya
                this.delay(2000);
                this.handOut(this.player); //1. lap kioszt�sa
                this.deck.printCards(this.playerCardList);
                //System.out.println("Az 1. lapod: " + newCard.color+ ", " + newCard.type);
                System.out.println("  2. k�rty�d oszt�sa...\r");
                this.delay(2000);
                this.handOut(this.player); //2. lap kioszt�sa a j�t�kosnak
                //System.out.println("A 2. lapod: " + newCard.color + ", " + newCard.type);
                System.out.println("A lapjaid:");
                this.deck.printCards(this.playerCardList);

                //oszt� 2 k�rty�j�nak kioszt�sa:
                this.handOut(this.computer); // 1. lap kioszt�sa az oszt�nak
                this.handOut(this.computer); //2. lap az oszt�nak
                
                //System.out.println("");
                System.out.println("A k�rty�id �ssz�rt�ke: " + this.getCardsValue(this.player)); // getterrel lek�rj�k a lapok �ssz�rt�k�t
                //System.out.println("");
        
                while (!isStopped && this.getCardsValue(this.player) < 21 || this.getCardsValue(this.computer) <= 17) { // addig megy�nk m�g v�ge nincs a j�t�knak
                        if ( !isStopped && this.getCardsValue(this.player) < 21) {
                                int dontes;
                                do { 
                                        Scanner in = new Scanner(System.in);
                                 
                                        System.out.println("  \n"
                                                        + "             **************************************\n"
                                                        + "             *       K�rsz m�g vagy meg�llsz?     *\n"
                                                        + "             *             1. K�rek m�g!          *\n"
                                                        + "             *             2. Meg�llok!           *\n"
                                                        + "             **************************************\n");
                                        dontes = in.nextInt();
                                } while(dontes < 1 || dontes > 2); // am�g nem 1-est vagy 2-est �r, addig k�rj�k be a sz�mot
                                System.out.println("");
                                
                                if (dontes == 2) { // ha 2-est v�lasztunk, akkor meg�ll a j�t�k
                                        this.isStopped = true;
                                } else {
                                        System.out.println("  K�vetkez� k�rty�d oszt�sa...\r");
                                        this.delay(2000);
                                        this.handOut(this.player); // k�vetkez� lap kioszt�sa
                                        
                                }
                                System.out.println("A k�rty�id: "); 
                                this.deck.printCards(this.playerCardList); // k�rtyaki�rat�s
                        
                                if (this.getCardsValue(this.player) == 21) {
                                        System.out.println("  \n"
                                                        + "             **************************************\n"
                                                        + "             *        ! B L A C K  J A C K !      *\n"
                                                        + "             **************************************\n");
                                }
                                
                                if(this.getCardsValue(this.player) < 21 && !isStopped) {
                                        System.out.println("A jelenlegi pontsz�mod : " + this.getCardsValue(this.player)); // getter az �sszpontsz�m lek�rdez�s�re
                                }
                        }
                        
                        if (this.getCardsValue(this.computer) <= 17) { //az oszt� addig kap k�rty�t, am�g a lapjainak �ssz�rt�ke 17 vagy ann�l kisebb
                                this.handOut(this.computer);
                        }
                } 
                
                // addig megy a j�t�k am�g meg nem �llunk, vagy am�g el nem �rj�k a legal�bb 21-et
                System.out.println("Az �sszpontsz�mod: " + this.getCardsValue(this.player));
                System.out.println("");
                System.out.println("  Az oszt� k�rty�inak felfed�se...\r");
                this.delay(3000);
                System.out.println("");
                System.out.println("Az oszt� k�rty�i: ");
                this.deck.printCards(this.computerCardList);
                if (this.getCardsValue(this.computer) == 21) {
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *        ! B L A C K  J A C K !      *\n"
                                        + "             **************************************\n");
                }
                System.out.println("Az Oszt� �sszpontsz�ma: " + this.getCardsValue(this.computer));
                
                //d�ntetlen: ha a 2 pontsz�m megegyezik, vagy mindketten besokalltunk
                if(this.getCardsValue(this.player) == this.getCardsValue(this.computer)
                                || (this.getCardsValue(this.player)> 21 && this.getCardsValue(this.computer) > 21)) {
                        result = 3; // Game oszt�ly handleStake met�dus�nak �tadott �rt�k
                }
                else if ((this.getCardsValue(this.computer) > 21 && this.getCardsValue(this.player) <= 21) 
                        || (this.getCardsValue(this.player) <= 21 && 21 - this.getCardsValue(this.player) < 21 - this.getCardsValue(this.computer))) {
                        // ha az oszt� lapjainak �rt�ke t�bb, mint 21, �s nek�nk nincs t�bb, mint 21, akkor nyert�nk
                        //ha kevesebb�nk van, mint 21, �s k�zelebb vagyunk a 21-hez mint az oszt�, akkor is nyert�nk
                        if (this.getCardsValue(this.player) == 21) {
                                multiplier = 3;
                        }
                        System.out.println(" ");
                        result = 1;
                } else { // minden m�s esetben veszt�nk
                        System.out.println(" ");
                        result = 2;
                }
                
                
                this.handleStake(this.player, result, multiplier); // t�t kezel�se, hozz�ad�dik, vagy levon�dik a zsetonjainkb�l
                this.delay(2000); // k�sleltet�s
                boolean playAgain = this.playAgain(this.player); //j�t�kost�l bek�rni, hogy akar-e �jraj�tszani

                if (playAgain) { // ha �jraj�tsz�s van, akkor a resetGame met�dust h�vja, illetve a run()-t
                        this.resetGame();
                        this.run();
                }
        }
        
        public void handOut(Player player) { // k�vetkez� k�rtya kioszt�sa met�dus
                Card newCard = this.deck.cards.get(0);
                this.deck.cards.remove(0); // a kiosztott lapot kiveszz�k a paklib�l, �gy mindig 1-gyel kevesebb lesz benne
        
                if (player.name=="Oszt�") { // ha oszt� a player�nk, akkor az � paklij�hoz adjunk hozz�
                        this.computerCardList.add(newCard);
                } else { // m�s esetben a saj�tunkhoz
                        this.playerCardList.add(newCard);               
                }
        }
        private int getCardsValue(Player player) { // aktu�lis j�t�kos kez�ben l�v� k�rty�k �sszeg�vel t�r�nk vissza
                ArrayList<Card> cardsDeck; 
                if (player.name == "Oszt�") { // ha oszt� a j�t�kos, akkor az � paklij�t vessz�k alapul
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
        
        private void resetGame() { // minden ami a j�t�khoz kell alaphelyzetbe �ll�t�sa
                this.deck = new FrenchCardDeck();
                Collections.shuffle(this.deck.cards);
                this.playerCardList.clear();
                this.computerCardList.clear();
                this.isStopped = false;
        }
        
        private void delay(int delayInMs) { // k�sleltet�s
                try {
                        Thread.sleep(delayInMs);
                } catch (InterruptedException e) {
                        System.out.println("Nem siker�lt a k�sleltet�s.");
                }
        }
}
