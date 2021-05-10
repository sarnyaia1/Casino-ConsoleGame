
public class Player {
        public String name;
        private int balance; // zsetonok �rt�ke, mennyis�ge
        
        
        public Player(String name, int balance) { // konstruktor, megadott n�vvel inicializ�ljuk, + fix 50 zseton kezd��rt�k
                this.name = name;
                this.balance = balance;
        }

        public int getBalance() { // getter, lek�rj�k a j�t�kos zsetonjait
                return this.balance;
        }

        public void addBalance(int amount) { // megadjuk, hogy mennyivel n�velj�k, vagy cs�kkentj�k a zsetonok �rt�keit
                this.balance += amount;
        }
        public void setBalance(int amount) { // setter, be�ll�tjuk hogy mennyi a zseton�rt�ke
                this.balance = amount;
        }
}
