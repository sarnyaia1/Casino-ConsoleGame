import java.util.*;

public class FrenchCardDeck { // franciakártya osztály, paklit tartalmazza
        public ArrayList<Card> cards = new ArrayList<Card>(); //pakli
        private String[] colors = {"Treff", "Kõr", "Pikk", "Káró"}; // összes létezõ szín
        private String[] types = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}; //összes létezõ szám
        
        
        public FrenchCardDeck() { // dupla for-ral legyártjuk az összes színhez tartozó összes számot (4db minden számból, 52db-os pakli)
                for(int i=0; i<this.colors.length; i++) { 
                        for(int j=0; j<this.types.length; j++) { 
                                // a paklihoz hozzáadunk egy új kártyaobjektumot az aktuális szín és aktuális típusból 
                                this.cards.add(new Card(this.colors[i], this.types[j]));
                        }
                }
                
        }
        
        public void printCards(ArrayList<Card> cards) { // kártyák egymás melletti kiíratásáért felelõs metódus
                String face = ""; // face = a kártyák összeillesztése stringként
                ArrayList<String[]> cardLines = new ArrayList<String[]>(); // az összes kártyát az összes sorával együtt tárolja

                for(int i = 0; i < cards.size(); i++) { // végigmegy az összes kártyán
                        cardLines.add(new String[7]); // látrehoz egy új 7 elemû tömböt az új kártyának 7 elem = 7 sor egy kártya, minden sor egy elem a tömbben
                        for(int j = 0; j < 7; j++) { // végigmegy a 7 soron
                                String type = cards.get(i).type; // aktuális kártya típusa
                                String suit = cards.get(i).color; // az aktuális kártya színe
                                String lastCardLineBreak = ""; 
                                if (i == cards.size() - 1) { 
                                        // ha az utolsó kártya a pakliban, akkor \n-t rakunk minden kártyasor végére, hogy új sorban kezdõdjön a következõ
                                        lastCardLineBreak = "\n";
                                }
                                if (j == 0) { // elsõ sor ( kárta teteje)
                                        cardLines.get(i)[j] = "+--------+  " + lastCardLineBreak;
                                } else if(j == 1) { // második sor(balfelsõ sarokban a típus kiíratás)
                        if(type.length() > 1) { // ha a típus 2 karakteres, akkor eggyel kevesebb space van a végén
                                cardLines.get(i)[j] = ("|" + type + "      |  " + lastCardLineBreak);
                        } else { // ha egy karakteres, akkor eggyel több space van a kártya sorának végén, hogy ugyanolyan hosszú legyen a sor minden esetben
                                cardLines.get(i)[j] = ("|" + type + "       |  " + lastCardLineBreak);
                        }
                    } else if (j == 2 || j == 4 ) { // ha a 3. vagy 5. sor, akkor egy üres sort szúr be (a kártya színe, és típusa közötti sorok
                        cardLines.get(i)[j] = ("|        |  " + lastCardLineBreak);
                    } else if (j == 5) { // ha az utolsó elõtti sor, akkor a jobb alsó sarokban van a kártya típusa
                        if(type.length() > 1) { // ha 2 karakteres, akkor eggyel kevesebb a space
                                cardLines.get(i)[j] = ("|      " + type + "|  " + lastCardLineBreak);
                        } else {
                                cardLines.get(i)[j] = ("|       " + type + "|  " + lastCardLineBreak);
                        }
                    } else if (j == 3) { // ha a 4. sor, akkor a szín karakterhosszúságának megfelelõen írja ki a kártya sorát
                        if(suit.equals("Treff")) {
                                cardLines.get(i)[j] = ("|  Treff |  " + lastCardLineBreak);
                        } else if(suit.equals("Káró")) {
                                cardLines.get(i)[j] = ("|  Káró  |  " + lastCardLineBreak);
                        } else if(suit.equals("Kõr")) {
                                cardLines.get(i)[j] = ("|  Kõr   |  " + lastCardLineBreak);
                        } else if(suit.equals("Pikk")) {
                                cardLines.get(i)[j] = ("|  Pikk  |  " + lastCardLineBreak);
                        }
                    } else { // az utolsó sor ( a kártya legalja)
                        cardLines.get(i)[j] = ("+--------+  " + lastCardLineBreak);                     
                    }
                }
                }
                // ha össze van rakva az összes kártya összes sora, akkor végigmegyünk soronként 
                for (int i = 0; i < 7; i++) { 
                        //és minden sorban végigmegyünk az összes kártya aktuális során
                        for (int j = 0; j < cards.size(); j++) {
                                face += cardLines.get(j)[i];
                        }
                }

        System.out.println(face); // kiírja az összes kártya összes sorát
        }   
}
