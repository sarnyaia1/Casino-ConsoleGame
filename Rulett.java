import java.util.Scanner;

public class Rulett extends Game { 
    private Player player;  // játékos
    private boolean rules = false; // szabályzat
      
    

    public Rulett(Player player) { // a játék kezdetéül szolgáló metódus, mely magába foglalja az üdvözlést, szabályzatot
        this.player = player;
                                             
        this.delay(2000); // késleltetés
        System.out.println( "\n" // üdvözlés
                          + "\n             **************************************"
                          + "\n             *                                    *"
                          + "\n             *                                    *"
                          + "\n             *    Üdvözöllek a Rulett játékban!   *"
                          + "\n             *                                    *"
                          + "\n             *                                    *"
                          + "\n             **************************************" );
        
        if(!this.rules && this.readGameRules()) { // szabályzat kezdete
            this.delay(2000);
            System.out.println( "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" 
                              + "\n - A rulett játékban a cél, hogy megtippeld és eltaláld azt a számot amelyet a gép kisorsol.   -"  
                              + "\n - A számok megadása elõtt szükséges egy tét megadása minden egyes körben.                     -"                    
                              + "\n - A számok 0 és 37 között helyezkednek el, ezekbõl választhatsz.                              -" 
                              + "\n - Amennyiben eltalálod a számot, nyersz, amennyiben nem, veszitesz.                           -" 
                              + "\n - A nyereséged a téted ötszöröse.                                                             -"
                              + "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" 
                              + "\n" 
                              + "\n Mostmár tudod hogyan kell játszani. Sok sikert a játékhoz!");
                                                                      
            Scanner in = new Scanner(System.in); // bekérjük az "Enter"-t a játék inditásához
            System.out.println("");
            System.out.println(" Nyomd meg az entert, ha kezdõdhet a játék!");
            in.nextLine();
            this.rules = true;
        } 
    }
   
    
        


    @Override
    public void run() { // a játékot indito metódus
           
        int tip; // tipp tárolása 
        int result = 0; // gyõztes állapot tárolása
        int multiplier = 6; // tét szorzó tárolása
        boolean winner = false; // gyõztes állapot tárolása, alap esetben nem igaz, hogy gyõzött
        
        this.delay(2000);   
        this.getStake(this.player); // tét bekérése
        System.out.println( "\n Kérlek válassz egy számot:" );
            
        System.out.println( "\n        +---------------------------------------------------------------+" 
                          + "\n        |+---++--------------------------------------------------------+|" 
                          + "\n        ||   || 3 | 6 | 9 | 12 | 15 | 18 | 21 | 24 | 27 | 30 | 33 | 36 ||" 
                          + "\n        ||   ||--------------------------------------------------------||" 
                          + "\n        || 0 || 2 | 5 | 8 | 11 | 14 | 17 | 20 | 23 | 26 | 29 | 32 | 35 ||" 
                          + "\n        ||   ||--------------------------------------------------------||" 
                          + "\n        ||   || 1 | 4 | 7 | 10 | 13 | 16 | 19 | 22 | 25 | 28 | 31 | 34 ||" 
                          + "\n        |+---++--------------------------------------------------------+|" 
                          + "\n        +---------------------------------------------------------------+");
        
        Scanner be = new Scanner(System.in); // tippelt szám bekérése
        tip = be.nextInt();
       
        
        while( tip < 0 || tip > 36 ) { // tipp bekérésének a megszoritása
            if ( tip < 0 ) {
                this.delay(2500);
                System.out.println( "\n- - - - - - - - - - - - - - - - - - - - - - - -" 
                                  + "\n A megadott szám nem lehet negativ elõjelû.   -" 
                                  + "\n Kérlek válassz újra!                        -" 
                                  + "\n- - - - - - - - - - - - - - - - - - - - - - - -");
                tip = be.nextInt(); // bekérjük a tippet újra
            } else if ( tip > 36 ) {
                this.delay(2500);
                System.out.println( "\n- - - - - - - - - - - - - - - - - - - - - - - -" 
                                  + "\n A megadott szám nem lehet több 36-nál.       -" 
                                  + "\n Kérlek válassz újra!                        -" 
                                  + "\n- - - - - - - - - - - - - - - - - - - - - - - -");
                tip = be.nextInt(); // bekérjük a tippet újra
            } 
        }
        
        
             
        this.delay(1000);
        System.out.println( "\n             +----------------------------+" 
                          + "\n             |     Választott szám:  | " + tip + " |"  // kiiratjuk a választott számot
                          + "\n             +----------------------------+");
        
        this.delay(2500);
        double number = Math.random() * 100 * 0.36; // legeneráltatunk a géppel egy számot
        int castedNumber = (int) number;
        System.out.println( "\n             +-------------------------+" 
                          + "\n             |     Sorsolt szám:  | " + castedNumber + " |" // kiiratjuk a gép által generált számot
                          + "\n             +-------------------------+");
        
        if ( tip == castedNumber ) { // összehasonlitsuk a tippet a gép által generált számmal
            winner = true; // ebben az esetben gyõzött
            result = 1; // ha egyezik a tipp és a generált szám, gyõzött a játékos, megkapja a tétet és a szorzott értékét is
        } else if ( tip != castedNumber ) {
            winner = false; // ebben a zesetben vesztett
            result = 2; // ha eltér a tipp és a generált szám, veszitett a játékos, elveszitette a tétet is
        }        
       
        
        this.handleStake(this.player, result, multiplier); // a tét kezelése, hozzáadódik, vagy levonódik a zsetonokból
        this.delay(2500);
        boolean playAgain = this.playAgain(this.player); // bekérjük a játékostól, hogy újra kiván-e játszani
        
        if (playAgain) { // ha újra akar játszani, akkor a this.run() inditja a játékot
            this.run();
        } 
    }
    
    
    private void delay( int delyaInMs ) { // késleltetést végrehajtó metódus
        try {
            Thread.sleep(delyaInMs); // inditja a késleltetés
        } catch (InterruptedException d) { // megszakitja, ha nem hajtható végre a folyamat
            System.out.println(" Nem sikerült a késleltetés."); // kiirja, hogy nem sikerült a késleltetés
        }
    }
}

        