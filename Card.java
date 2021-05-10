
public class Card {
        public String color;
        public String type;
        
        public Card(String color, String type) {
                this.color = color;
                this.type = type;
        }
        
        public int getValue() { 
                //getter, az aktu�lis k�rty�nak mennyi az �rt�ke J,D,K=10
                if(this.type == "J" || this.type == "Q" || this.type == "K") {
                        return 10;
                }else if (this.type == "A") { // fixen 11 az �sz �rt�ke :(
                        return 11;
                } else {
                        return Integer.parseInt(this.type); // ahanyas sz�m van a k�rty�n annyi az �rt�ke, int-be �t�rt v�ltozat
                }
                        
        }
}
