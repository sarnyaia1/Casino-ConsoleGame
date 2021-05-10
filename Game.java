import java.util.Scanner;

public abstract class Game { // ebb�l nem p�ld�nyos�tunk k�zvetlen, t�pusk�nt funkcion�l minden j�t�khoz
        protected int stake;
        
        public abstract void run();
        
        protected boolean readGameRules() {
                Scanner in = new Scanner(System.in);
                System.out.println("  \n"
                                + "            ****************************************\n"
                                + "            * Szeretn�d elolvasni a j�t�kszab�lyt? *\n"
                                + "            *                1. Igen               *\n"
                                + "            *                2. Nem                *\n"
                                + "            ****************************************\n");
                int answer = in.nextInt();
                
                return answer == 1;
        }
        
        protected void setStake(int stake) { //t�t
                this.stake = stake;
                System.out.println(" Az �ltalad megrakott t�t " + this.stake + " zseton.");
                System.out.println("");
        }
        
        protected void getStake(Player player) { // run met�dus els� h�v�s�nak kell lennie, miel�tt elkezd�dik a j�t�k, bek�rj�nk a t�tet
                int stake; //a j�t�kost�l bek�rt t�tet t�roljuk
                String error = ""; // visszajelz�st t�rol� v�ltoz�

                do {
                        System.out.println(error);
                        System.out.println(" Add meg a t�ted (" + player.getBalance() + " zsetonod van):"); // t�t bek�r�s
                        Scanner stakeIn = new Scanner(System.in);
                        stake = stakeIn.nextInt();
                        if (stake > player.getBalance()) { // ha t�bb zsetont �r be, mint amennyi van n�la, akkor bek�ri m�gegyszer
                                error = " Nincs ennyi zsetonod!";
                        } else if (stake < 1) {
                                error = " Nem adhatsz meg null�t!";
                        } else {
                                error = "";
                        }
                } while (error.length() > 1); // addig am�g van valamilyen hiba, addig k�rj�k be a t�tet
                
                this.setStake(stake);// t�t t�nyleges be�ll�t�sa
                player.addBalance(-stake); // a t�tet levonjuk a zseton�sszegb�l
        }

        protected void handleStake(Player player, int result, int multiplier) { //nyerem�ny�sszeg kioszt�s, vagy zsetonlevon�s, multiplier: szorz�
                // ha megvan a gy�ztes�nk a j�t�k v�g�n, akkor ezt a met�dust kell megh�vni, hogy kezelje a feltett zseton�sszeget
                if (result == 1) { // a j�t�k run met�dus�nak v�g�n megkapott �rt�k alapj�n kezel
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *               Nyert�l!             *\n"
                                        + "             *             Gratul�lunk!           *\n"
                                        + "             *         Zseton �ti a markod!       *\n"
                                        + "             **************************************\n");
                        
                        player.addBalance(this.stake * multiplier); // j�t�kszorz�t�l f�gg�en hozz�ad�dik a megnyert zseton�sszeg
                } else if (result == 2){ //
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *              Vesztett�l!           *\n"
                                        + "             *         �gy elbuktad a t�ted!      *\n"
                                        + "             **************************************\n");
                } else {
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *              D�ntetlen!            *\n"
                                        + "             *         Szoros k�zdelem volt!      *\n"
                                        + "             *         Visszakapod a t�ted!       *\n"
                                        + "             **************************************\n");
                        player.addBalance(this.stake);
                }
                
                System.out.println(" Az �j egyenleged " + player.getBalance() + " zseton.");
        }
        
        protected boolean playAgain(Player player) { // �jraj�tsz�s lehet�s�g�nek felk�n�l�sa, j�t�kok run met�dus�nak utols� sor�ban ezzel a met�dussal kell visszat�rni
                Scanner playAgainIn = new Scanner(System.in);

                if (player.getBalance() > 0) { // csak akkor k�rdezi meg, ha m�g van zseton
                        System.out.println("  \n"
                                        + "             **************************************\n"
                                        + "             *        Akarsz �jra j�tszani?       *\n"
                                        + "             *              1. Igen               *\n"
                                        + "             *              2. Nem                *\n"
                                        + "             **************************************\n");                     
                        return playAgainIn.nextInt() == 1;
                }
                
                System.out.println(" Sajnos elvesztetted az �sszes zsetonodat!");
                return false;
        }
}
