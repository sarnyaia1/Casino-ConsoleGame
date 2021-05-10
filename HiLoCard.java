
public class HiLoCard {
        private String suit;
        private String value;
        public static String[] values = {"ász", "2", "3", "4", "5", "6", "7", "8", "9", "10", "bubi", "dáma", "király"};
        public static String[] suits = {"Treff", "Kõr", "Pikk", "Káró"};
        public HiLoCard() {
                this.value = HiLoCard.values[(int)(Math.random() * HiLoCard.values.length)];
                this.suit = HiLoCard.suits[(int)(Math.random() * HiLoCard.suits.length)];
        }
        public int getRealValue(){
                for (int i=0; i<=values.length; i++){
                        if (HiLoCard.values[i] == this.value) {
                                return i+1;
                        }
                }
                return 0;
        }
        public String getSuit(){
                return this.suit;
        }
        public String getValue() {
                return value;
        }
        
        
        
        
}
