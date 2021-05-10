import java.util.Scanner;

public abstract class Game { // ebbõl nem példányosítunk közvetlen, típusként funkcionál minden játékhoz
        protected int stake;
        
        public abstract void run();
        
        protected boolean readGameRules() {
                Scanner in = new Scanner(System.in);
                System.out.println("  \n"
                                + "            ****************************************\n"
                                + "            * Szeretnéd elolvasni a játékszabályt? *\n"
                                + "            *                1. Igen               *\n"
                                + "            *                2. Nem                *\n"
                                + "            ****************************************\n");
                int answer = in.nextInt();
                
                return answer == 1;
        }
        
        protected void setStake(int stake) { //tét
                this.stake = stake;
                System.out.println(" Az általad megrakott tét " + this.stake + " zseton.");
                System.out.println("");
        }
        
        protected void getStake(Player player) { // run metódus elsõ hívásának kell lennie, mielõtt elkezdõdik a játék, bekérjünk a tétet
                int stake; //a játékostól bekért tétet tároljuk
                String error = ""; // visszajelzést tároló változó

                do {
                        System.out.println(error);
                        System.out.println(" Add meg a téted (" + player.getBalance() + " zsetonod van):"); // tét bekérés
                        Scanner stakeIn = new Scanner(System.in);
                        stake = stakeIn.nextInt();
                        if (stake > player.getBalance()) { // ha több zsetont ír be, mint amennyi van nála, akkor bekéri mégegyszer
                                error = " Nincs ennyi zsetonod!";
                        } else if (stake < 1) {
                                error = " Nem adhatsz meg nullát!";
                        } else {
                                error = "";
                        }
                } while (error.length() > 1); // addig amég van valamilyen hiba, addig kérjük be a tétet
                
                this.setStake(stake);// tét tényleges beállítása
                player.addBalance(-stake); // a tétet levonjuk a zsetonösszegbõl
        }

        protected void handleStake(Player player, int result, int multiplier) { //nyereményösszeg kiosztás, vagy zsetonlevonás, multiplier: szorzó
                // ha megvan a gyõztesünk a játék végén, akkor ezt a metódust kell meghívni, hogy kezelje a feltett zsetonösszeget
                if (result == 1) { // a játék run metódusának végén megkapott érték alapján kezel
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *               Nyertél!             *\n"
                                        + "             *             Gratulálunk!           *\n"
                                        + "             *         Zseton üti a markod!       *\n"
                                        + "             **************************************\n");
                        
                        player.addBalance(this.stake * multiplier); // játékszorzótól függõen hozzáadódik a megnyert zsetonösszeg
                } else if (result == 2){ //
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *              Vesztettél!           *\n"
                                        + "             *         Így elbuktad a téted!      *\n"
                                        + "             **************************************\n");
                } else {
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *              Döntetlen!            *\n"
                                        + "             *         Szoros küzdelem volt!      *\n"
                                        + "             *         Visszakapod a téted!       *\n"
                                        + "             **************************************\n");
                        player.addBalance(this.stake);
                }
                
                System.out.println(" Az új egyenleged " + player.getBalance() + " zseton.");
        }
        
        protected boolean playAgain(Player player) { // újrajátszás lehetõségének felkínálása, játékok run metódusának utolsó sorában ezzel a metódussal kell visszatérni
                Scanner playAgainIn = new Scanner(System.in);

                if (player.getBalance() > 0) { // csak akkor kérdezi meg, ha még van zseton
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *        Akarsz újra játszani?       *\n"
                                        + "             *              1. Igen               *\n"
                                        + "             *              2. Nem                *\n"
                                        + "             **************************************\n");                     
                        return playAgainIn.nextInt() == 1;
                }
                
                System.out.println(" Sajnos elvesztetted az összes zsetonodat!");
                return false;
        }
}
