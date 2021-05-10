
public class Player {
        public String name;
        private int balance; // zsetonok értéke, mennyisége
        
        
        public Player(String name, int balance) { // konstruktor, megadott névvel inicializáljuk, + fix 50 zseton kezdõérték
                this.name = name;
                this.balance = balance;
        }

        public int getBalance() { // getter, lekérjük a játékos zsetonjait
                return this.balance;
        }

        public void addBalance(int amount) { // megadjuk, hogy mennyivel növeljük, vagy csökkentjük a zsetonok értékeit
                this.balance += amount;
        }
        public void setBalance(int amount) { // setter, beállítjuk hogy mennyi a zsetonértéke
                this.balance = amount;
        }
}
