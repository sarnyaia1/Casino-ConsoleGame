import java.util.Scanner;

public class Casino {
        
        public static void main(String[] args) {
                AccountManager accountManager = new AccountManager();
                Game currentGame; //v�ltoz�, ami t�rolja, hogy mivel j�tszik aktu�lisan a j�t�kos
                Scanner be = new Scanner(System.in);
                System.out.println("\n"
                                + "             **************************************\n"
                                + "             *                                    *\n"
                                + "             *                                    *\n"
                                + "             *   �dv�z�llek a Casino j�t�kban!    *\n"
                                + "             *                                    *\n"
                                + "             *                                    *\n"
                                + "             **************************************\n"
                                + ""); 
                String name;
                do {
                        System.out.println(" K�rj�k add meg a neved:");
                        name = be.nextLine();
                } while(name.length() < 1);
                
                int balance = accountManager.getAccount(name);
                Player player = new Player(name, balance == 0 ? 50 : balance); // �j j�t�kos l�trhoz�sa, 50 zseton, ha nincs zseton be�ll�tva az AccountManagerben
                
                
                
                System.out.println("");
                System.out.println(" J�, hogy itt vagy "+ player.name +"! A kezd� egyenleged: " + player.getBalance() + " zseton.");
                System.out.println("");
                
                Casino.delay(2000);
                // Addig j�tszunk am�g van zseton, vagy am�g akarunk j�tszani
                int gameNumber;

                do {
                        System.out.println(" K�rlek v�lassz egy j�t�kot:" );
                        System.out.println("   1. Black Jack");
                        System.out.println("   2. Rulett");
                        System.out.println("   3. F�lkar� rabl�");
                        System.out.println("   4. Hi-Lo");
                        System.out.println("   5. Kil�p�s");
                        
                        gameNumber = be.nextInt();
                        
                        if (gameNumber == 5) {
                                break;
                        }

                        currentGame = GameFactory.getGame(gameNumber, player); // bek�rt sz�mnak megfelel�en legy�rtja a j�t�k objektumot
                        currentGame.run(); // elind�tja a j�t�kot a bek�rt sz�m alapj�n
                } while(player.getBalance() > 0); //�jraj�tsz�s lehet�s�ge
                
                System.out.println(" K�sz�nj�k, hogy itt volt�l " + player.name + "! V�runk vissza!");
                accountManager.saveAccount(player);
                be.close();
        }
        
        private static void delay(int delayInMs) {
                try {
                        Thread.sleep(delayInMs);
                } catch (InterruptedException e) {
                        System.out.println(" Nem siker�lt a k�sleltet�s.");
                }
        }
}
