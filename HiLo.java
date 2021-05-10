import java.util.Scanner;

public class HiLo extends Game {
        protected String name;
        protected Player computer;
        private Player player;
        boolean first = false;
        boolean stophilo = false;
        boolean replay = true;
        public HiLo(Player player) {
                super();
                this.player = player;
        }
public void replay(){
        System.out.println(" - - - - - - - - - - - - - - - -");
        System.out.println("Szeretnél újra játszani?");
        System.out.println("   1. Újra játszok!");
        System.out.println("   2. Kilépek!");
        System.out.println(" - - - - - - - - - - - - - - - -");
        Scanner dontes = new Scanner(System.in);
        replay = true;
        int replaydontes = dontes.nextInt();
        if (replaydontes == 1){
                replay = true;
                run();
        }
        if (replaydontes == 2){
                stophilo = true;
        }
}

        public void run() { 
                int tet = 0;
                HiLoCard card = null;
                HiLoCard newcard;
                Scanner be = new Scanner(System.in);
                while(tet==0){
                        card = new HiLoCard();
                        System.out.println("Jelenlegi kártyád: "+card.getSuit()+" "+card.getValue());
                        System.out.println("Jelenlegi zsetonod: "+this.player.getBalance());
                        System.out.println("Kérek egy tétet!");
                        tet = be.nextInt();
                        if (tet<0 || tet>this.player.getBalance()) {
                                tet = 0;
                                System.out.println("Ez nem lesz elég..");
                        }
                }
                this.player.addBalance(-tet);
                System.out.println("Jelenlegi zsetonod: "+this.player.getBalance());
                while(true && replay != false){
                        if (stophilo == true) {
                                break;
                        }
                        System.out.println("Jelenlegi kártyád: "+card.getSuit()+" "+card.getValue());
                        System.out.println("Jelenlegi tét: "+ tet);
                        System.out.println("Kisebb vagy nagyobb?");
                        System.out.println("   1. Kisebb!");
                        System.out.println("   2. Nagyobb!");
                        if (first != true) {
                                System.out.println("   3. Kiszállok!");
                        }
                        System.out.println(" - - - - - - - - - - - - - - - -");
                        boolean nyert = false;
                        newcard = new HiLoCard();
                        System.out.println("Új kártyád: "+newcard.getSuit()+" "+newcard.getValue());
                        int dontes = be.nextInt();
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
                                replay = true;
                                replay();
                        }
                        first = false;
                }
        }
}