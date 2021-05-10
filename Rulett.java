import java.util.Scanner;

public class Rulett extends Game { 
    private Player player;  // j�t�kos
    private boolean rules = false; // szab�lyzat
      
    

    public Rulett(Player player) { // a j�t�k kezdet��l szolg�l� met�dus, mely mag�ba foglalja az �dv�zl�st, szab�lyzatot
        this.player = player;
                                             
        this.delay(2000); // k�sleltet�s
        System.out.println( "\n" // �dv�zl�s
                          + "\n             **************************************"
                          + "\n             *                                    *"
                          + "\n             *                                    *"
                          + "\n             *    �dv�z�llek a Rulett j�t�kban!   *"
                          + "\n             *                                    *"
                          + "\n             *                                    *"
                          + "\n             **************************************" );
        
        if(!this.rules && this.readGameRules()) { // szab�lyzat kezdete
            this.delay(2000);
            System.out.println( "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" 
                              + "\n - A rulett j�t�kban a c�l, hogy megtippeld �s eltal�ld azt a sz�mot amelyet a g�p kisorsol.   -"  
                              + "\n - A sz�mok megad�sa el�tt sz�ks�ges egy t�t megad�sa minden egyes k�rben.                     -"                    
                              + "\n - A sz�mok 0 �s 37 k�z�tt helyezkednek el, ezekb�l v�laszthatsz.                              -" 
                              + "\n - Amennyiben eltal�lod a sz�mot, nyersz, amennyiben nem, veszitesz.                           -" 
                              + "\n - A nyeres�ged a t�ted �tsz�r�se.                                                             -"
                              + "\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" 
                              + "\n" 
                              + "\n Mostm�r tudod hogyan kell j�tszani. Sok sikert a j�t�khoz!");
                                                                      
            Scanner in = new Scanner(System.in); // bek�rj�k az "Enter"-t a j�t�k indit�s�hoz
            System.out.println("");
            System.out.println(" Nyomd meg az entert, ha kezd�dhet a j�t�k!");
            in.nextLine();
            this.rules = true;
        } 
    }
   
    
        


    @Override
    public void run() { // a j�t�kot indito met�dus
           
        int tip; // tipp t�rol�sa 
        int result = 0; // gy�ztes �llapot t�rol�sa
        int multiplier = 6; // t�t szorz� t�rol�sa
        boolean winner = false; // gy�ztes �llapot t�rol�sa, alap esetben nem igaz, hogy gy�z�tt
        
        this.delay(2000);   
        this.getStake(this.player); // t�t bek�r�se
        System.out.println( "\n K�rlek v�lassz egy sz�mot:" );
            
        System.out.println( "\n        +---------------------------------------------------------------+" 
                          + "\n        |+---++--------------------------------------------------------+|" 
                          + "\n        ||   || 3 | 6 | 9 | 12 | 15 | 18 | 21 | 24 | 27 | 30 | 33 | 36 ||" 
                          + "\n        ||   ||--------------------------------------------------------||" 
                          + "\n        || 0 || 2 | 5 | 8 | 11 | 14 | 17 | 20 | 23 | 26 | 29 | 32 | 35 ||" 
                          + "\n        ||   ||--------------------------------------------------------||" 
                          + "\n        ||   || 1 | 4 | 7 | 10 | 13 | 16 | 19 | 22 | 25 | 28 | 31 | 34 ||" 
                          + "\n        |+---++--------------------------------------------------------+|" 
                          + "\n        +---------------------------------------------------------------+");
        
        Scanner be = new Scanner(System.in); // tippelt sz�m bek�r�se
        tip = be.nextInt();
       
        
        while( tip < 0 || tip > 36 ) { // tipp bek�r�s�nek a megszorit�sa
            if ( tip < 0 ) {
                this.delay(2500);
                System.out.println( "\n- - - - - - - - - - - - - - - - - - - - - - - -" 
                                  + "\n A megadott sz�m nem lehet negativ el�jel�.   -" 
                                  + "\n K�rlek v�lassz �jra!                        -" 
                                  + "\n- - - - - - - - - - - - - - - - - - - - - - - -");
                tip = be.nextInt(); // bek�rj�k a tippet �jra
            } else if ( tip > 36 ) {
                this.delay(2500);
                System.out.println( "\n- - - - - - - - - - - - - - - - - - - - - - - -" 
                                  + "\n A megadott sz�m nem lehet t�bb 36-n�l.       -" 
                                  + "\n K�rlek v�lassz �jra!                        -" 
                                  + "\n- - - - - - - - - - - - - - - - - - - - - - - -");
                tip = be.nextInt(); // bek�rj�k a tippet �jra
            } 
        }
        
        
             
        this.delay(1000);
        System.out.println( "\n             +----------------------------+" 
                          + "\n             |     V�lasztott sz�m:  | " + tip + " |"  // kiiratjuk a v�lasztott sz�mot
                          + "\n             +----------------------------+");
        
        this.delay(2500);
        double number = Math.random() * 100 * 0.36; // legener�ltatunk a g�ppel egy sz�mot
        int castedNumber = (int) number;
        System.out.println( "\n             +-------------------------+" 
                          + "\n             |     Sorsolt sz�m:  | " + castedNumber + " |" // kiiratjuk a g�p �ltal gener�lt sz�mot
                          + "\n             +-------------------------+");
        
        if ( tip == castedNumber ) { // �sszehasonlitsuk a tippet a g�p �ltal gener�lt sz�mmal
            winner = true; // ebben az esetben gy�z�tt
            result = 1; // ha egyezik a tipp �s a gener�lt sz�m, gy�z�tt a j�t�kos, megkapja a t�tet �s a szorzott �rt�k�t is
        } else if ( tip != castedNumber ) {
            winner = false; // ebben a zesetben vesztett
            result = 2; // ha elt�r a tipp �s a gener�lt sz�m, veszitett a j�t�kos, elveszitette a t�tet is
        }        
       
        
        this.handleStake(this.player, result, multiplier); // a t�t kezel�se, hozz�ad�dik, vagy levon�dik a zsetonokb�l
        this.delay(2500);
        boolean playAgain = this.playAgain(this.player); // bek�rj�k a j�t�kost�l, hogy �jra kiv�n-e j�tszani
        
        if (playAgain) { // ha �jra akar j�tszani, akkor a this.run() inditja a j�t�kot
            this.run();
        } 
    }
    
    
    private void delay( int delyaInMs ) { // k�sleltet�st v�grehajt� met�dus
        try {
            Thread.sleep(delyaInMs); // inditja a k�sleltet�s
        } catch (InterruptedException d) { // megszakitja, ha nem hajthat� v�gre a folyamat
            System.out.println(" Nem siker�lt a k�sleltet�s."); // kiirja, hogy nem siker�lt a k�sleltet�s
        }
    }
}

        