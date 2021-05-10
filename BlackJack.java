import java.util.*;

public class BlackJack extends Game { // az absztrakt Game osztályunkat terjetszjük ki extends-el, öröklés, a Game õsosztályból egy új osztály származtatása
        private Player computer; // player típusú osztó, aki ellen játszunk
        private Player player; // a játékos
        private boolean isStopped = false; // változó, amiben tároljuk, hogy megálltunk-e
        private FrenchCardDeck deck; // franciakártya pakli változója
        private ArrayList<Card> playerCardList = new ArrayList<Card>(); // a mi paklink, ami a kezünkben van
        private ArrayList<Card> computerCardList = new ArrayList<Card>(); // osztó paklija
        private boolean rulesDone = false;
        
        public BlackJack(Player player) { // csak a mi player objektumunkat várja, mert az osztót a játék generálja
                this.player = player;
                this.computer = new Player("Osztó", 50);
                this.deck = new FrenchCardDeck(); // itt hozzunk létre az új franciakártya pakli objektumunkat a játékhoz
                Collections.shuffle(this.deck.cards);
                
                System.out.println("  \n"
                                + "             **************************************\n"
                                + "             *                                    *\n"
                                + "             *     Üdv a Black Jack játékban!     *\n"
                                + "             *                                    *\n"
                                + "             **************************************\n");
                //System.out.println(" ");
        }
        
        public void run() { // run metódus elindítja a játékot
                int result; // gyõztes állapot tárolása
                int multiplier = 2; // gyõzelem esetén a szorzó
                
                
                if(!this.rulesDone && this.readGameRules()) {
                        System.out.println("  A Black Jack lényege, hogy 21 pontot szerezz a kártyáidból. \n"
                                                         + " - Az Osztó ellen játszol.\n" 
                                                         + " - Akinek a kártyáinak az összege 21, vagy közelebb van a 21-hez, az nyer.\n"
                                                         + " - 2 kártyát kapsz a játék elején, utána te döntöd el, hogy kérsz-e még, vagy megállsz.\n"
                                                         + " - Azonos pontszám esetén, vagy ha mindketten besokalltok, döntetlen az eredmény, a téted visszakapod.\n"
                                                         + " - Gyõzelem esetén a téted kétszeresét nyered vissza, Black Jack (21) esetén a téted háromszorosát.\n"
                                                         + " - Vereség esetén elveszted a téted.\n"
                                                         + " \n"
                                                         + "  Sok sikert a játékhoz!");
                        Scanner in = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Nyomj entert, ha kezdõdhet a játék!");
                        in.nextLine();
                        this.rulesDone = true;
                }
                
                this.getStake(this.player); // tét bekérése
                
                System.out.println("  1. kártyád osztása...\r"); // helyére ugrik be a kártya
                this.delay(2000);
                this.handOut(this.player); //1. lap kiosztása
                this.deck.printCards(this.playerCardList);
                //System.out.println("Az 1. lapod: " + newCard.color+ ", " + newCard.type);
                System.out.println("  2. kártyád osztása...\r");
                this.delay(2000);
                this.handOut(this.player); //2. lap kiosztása a játékosnak
                //System.out.println("A 2. lapod: " + newCard.color + ", " + newCard.type);
                System.out.println("A lapjaid:");
                this.deck.printCards(this.playerCardList);

                //osztó 2 kártyájának kiosztása:
                this.handOut(this.computer); // 1. lap kiosztása az osztónak
                this.handOut(this.computer); //2. lap az osztónak
                
                //System.out.println("");
                System.out.println("A kártyáid összértéke: " + this.getCardsValue(this.player)); // getterrel lekérjük a lapok összértékét
                //System.out.println("");
        
                while (!isStopped && this.getCardsValue(this.player) < 21 || this.getCardsValue(this.computer) <= 17) { // addig megyünk még vége nincs a játéknak
                        if ( !isStopped && this.getCardsValue(this.player) < 21) {
                                int dontes;
                                do { 
                                        Scanner in = new Scanner(System.in);
                                 
                                        System.out.println("  \n"
                                                        + "             **************************************\n"
                                                        + "             *       Kérsz még vagy megállsz?     *\n"
                                                        + "             *             1. Kérek még!          *\n"
                                                        + "             *             2. Megállok!           *\n"
                                                        + "             **************************************\n");
                                        dontes = in.nextInt();
                                } while(dontes < 1 || dontes > 2); // amég nem 1-est vagy 2-est ír, addig kérjük be a számot
                                System.out.println("");
                                
                                if (dontes == 2) { // ha 2-est választunk, akkor megáll a játék
                                        this.isStopped = true;
                                } else {
                                        System.out.println("  Következõ kártyád osztása...\r");
                                        this.delay(2000);
                                        this.handOut(this.player); // következõ lap kiosztása
                                        
                                }
                                System.out.println("A kártyáid: "); 
                                this.deck.printCards(this.playerCardList); // kártyakiíratás
                        
                                if (this.getCardsValue(this.player) == 21) {
                                        System.out.println("  \n"
                                                        + "             **************************************\n"
                                                        + "             *        ! B L A C K  J A C K !      *\n"
                                                        + "             **************************************\n");
                                }
                                
                                if(this.getCardsValue(this.player) < 21 && !isStopped) {
                                        System.out.println("A jelenlegi pontszámod : " + this.getCardsValue(this.player)); // getter az összpontszám lekérdezésére
                                }
                        }
                        
                        if (this.getCardsValue(this.computer) <= 17) { //az osztó addig kap kártyát, amég a lapjainak összértéke 17 vagy annál kisebb
                                this.handOut(this.computer);
                        }
                } 
                
                // addig megy a játék amég meg nem állunk, vagy amég el nem érjük a legalább 21-et
                System.out.println("Az összpontszámod: " + this.getCardsValue(this.player));
                System.out.println("");
                System.out.println("  Az osztó kártyáinak felfedése...\r");
                this.delay(3000);
                System.out.println("");
                System.out.println("Az osztó kártyái: ");
                this.deck.printCards(this.computerCardList);
                if (this.getCardsValue(this.computer) == 21) {
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *        ! B L A C K  J A C K !      *\n"
                                        + "             **************************************\n");
                }
                System.out.println("Az Osztó összpontszáma: " + this.getCardsValue(this.computer));
                
                //döntetlen: ha a 2 pontszám megegyezik, vagy mindketten besokalltunk
                if(this.getCardsValue(this.player) == this.getCardsValue(this.computer)
                                || (this.getCardsValue(this.player)> 21 && this.getCardsValue(this.computer) > 21)) {
                        result = 3; // Game osztály handleStake metódusának átadott érték
                }
                else if ((this.getCardsValue(this.computer) > 21 && this.getCardsValue(this.player) <= 21) 
                        || (this.getCardsValue(this.player) <= 21 && 21 - this.getCardsValue(this.player) < 21 - this.getCardsValue(this.computer))) {
                        // ha az osztó lapjainak értéke több, mint 21, és nekünk nincs több, mint 21, akkor nyertünk
                        //ha kevesebbünk van, mint 21, és közelebb vagyunk a 21-hez mint az osztó, akkor is nyertünk
                        if (this.getCardsValue(this.player) == 21) {
                                multiplier = 3;
                        }
                        System.out.println(" ");
                        result = 1;
                } else { // minden más esetben vesztünk
                        System.out.println(" ");
                        result = 2;
                }
                
                
                this.handleStake(this.player, result, multiplier); // tét kezelése, hozzáadódik, vagy levonódik a zsetonjainkból
                this.delay(2000); // késleltetés
                boolean playAgain = this.playAgain(this.player); //játékostól bekérni, hogy akar-e újrajátszani

                if (playAgain) { // ha újrajátszás van, akkor a resetGame metódust hívja, illetve a run()-t
                        this.resetGame();
                        this.run();
                }
        }
        
        public void handOut(Player player) { // következõ kártya kiosztása metódus
                Card newCard = this.deck.cards.get(0);
                this.deck.cards.remove(0); // a kiosztott lapot kiveszzük a pakliból, így mindig 1-gyel kevesebb lesz benne
        
                if (player.name=="Osztó") { // ha osztó a playerünk, akkor az õ paklijához adjunk hozzá
                        this.computerCardList.add(newCard);
                } else { // más esetben a sajátunkhoz
                        this.playerCardList.add(newCard);               
                }
        }
        private int getCardsValue(Player player) { // aktuális játékos kezében lévõ kártyák összegével térünk vissza
                ArrayList<Card> cardsDeck; 
                if (player.name == "Osztó") { // ha osztó a játékos, akkor az õ pakliját vesszük alapul
                        cardsDeck = this.computerCardList;
                }else { // a játékos pakliját vesszük alapul
                        cardsDeck = this.playerCardList;
                }
                
                int sum = 0; // a sum tárolja a pakli kártyáinak az összegét
                for(int i=0; i<cardsDeck.size(); i++) { // végig megyünk a paklin
                        sum += cardsDeck.get(i).getValue(); // minden egyes kártyának hozzáadjuk az értékét a sum-hoz
                }
                
                return sum; // visszatérünk az összpontszámmal
        }
        
        private void resetGame() { // minden ami a játékhoz kell alaphelyzetbe állítása
                this.deck = new FrenchCardDeck();
                Collections.shuffle(this.deck.cards);
                this.playerCardList.clear();
                this.computerCardList.clear();
                this.isStopped = false;
        }
        
        private void delay(int delayInMs) { // késleltetés
                try {
                        Thread.sleep(delayInMs);
                } catch (InterruptedException e) {
                        System.out.println("Nem sikerült a késleltetés.");
                }
        }
}
