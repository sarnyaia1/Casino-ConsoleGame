import java.util.Scanner;

public class Casino {
        
        public static void main(String[] args) {
                AccountManager accountManager = new AccountManager();
                Game currentGame; //változó, ami tárolja, hogy mivel játszik aktuálisan a játékos
                Scanner be = new Scanner(System.in);
                System.out.println("\n"
                                + "             **************************************\n"
                                + "             *                                    *\n"
                                + "             *                                    *\n"
                                + "             *   Üdvözöllek a Casino játékban!    *\n"
                                + "             *                                    *\n"
                                + "             *                                    *\n"
                                + "             **************************************\n"
                                + ""); 
                String name;
                do {
                        System.out.println(" Kérjük add meg a neved:");
                        name = be.nextLine();
                } while(name.length() < 1);
                
                int balance = accountManager.getAccount(name);
                Player player = new Player(name, balance == 0 ? 50 : balance); // új játékos létrhozása, 50 zseton, ha nincs zseton beállítva az AccountManagerben
                
                
                
                System.out.println("");
                System.out.println(" Jó, hogy itt vagy "+ player.name +"! A kezdõ egyenleged: " + player.getBalance() + " zseton.");
                System.out.println("");
                
                Casino.delay(2000);
                // Addig játszunk amég van zseton, vagy amég akarunk játszani
                int gameNumber;

                do {
                        System.out.println(" Kérlek válassz egy játékot:" );
                        System.out.println("   1. Black Jack");
                        System.out.println("   2. Rulett");
                        System.out.println("   3. Félkarú rabló");
                        System.out.println("   4. Hi-Lo");
                        System.out.println("   5. Kilépés");
                        
                        gameNumber = be.nextInt();
                        
                        if (gameNumber == 5) {
                                break;
                        }

                        currentGame = GameFactory.getGame(gameNumber, player); // bekért számnak megfelelõen legyártja a játék objektumot
                        currentGame.run(); // elindítja a játékot a bekért szám alapján
                } while(player.getBalance() > 0); //újrajátszás lehetõsége
                
                System.out.println(" Köszönjük, hogy itt voltál " + player.name + "! Várunk vissza!");
                accountManager.saveAccount(player);
                be.close();
        }
        
        private static void delay(int delayInMs) {
                try {
                        Thread.sleep(delayInMs);
                } catch (InterruptedException e) {
                        System.out.println(" Nem sikerült a késleltetés.");
                }
        }
}
