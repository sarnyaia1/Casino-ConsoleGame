import java.util.*;

public class FrenchCardDeck { // franciak�rtya oszt�ly, paklit tartalmazza
        public ArrayList<Card> cards = new ArrayList<Card>(); //pakli
        private String[] colors = {"Treff", "K�r", "Pikk", "K�r�"}; // �sszes l�tez� sz�n
        private String[] types = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}; //�sszes l�tez� sz�m
        
        
        public FrenchCardDeck() { // dupla for-ral legy�rtjuk az �sszes sz�nhez tartoz� �sszes sz�mot (4db minden sz�mb�l, 52db-os pakli)
                for(int i=0; i<this.colors.length; i++) { 
                        for(int j=0; j<this.types.length; j++) { 
                                // a paklihoz hozz�adunk egy �j k�rtyaobjektumot az aktu�lis sz�n �s aktu�lis t�pusb�l 
                                this.cards.add(new Card(this.colors[i], this.types[j]));
                        }
                }
                
        }
        
        public void printCards(ArrayList<Card> cards) { // k�rty�k egym�s melletti ki�rat�s��rt felel�s met�dus
                String face = ""; // face = a k�rty�k �sszeilleszt�se stringk�nt
                ArrayList<String[]> cardLines = new ArrayList<String[]>(); // az �sszes k�rty�t az �sszes sor�val egy�tt t�rolja

                for(int i = 0; i < cards.size(); i++) { // v�gigmegy az �sszes k�rty�n
                        cardLines.add(new String[7]); // l�trehoz egy �j 7 elem� t�mb�t az �j k�rty�nak 7 elem = 7 sor egy k�rtya, minden sor egy elem a t�mbben
                        for(int j = 0; j < 7; j++) { // v�gigmegy a 7 soron
                                String type = cards.get(i).type; // aktu�lis k�rtya t�pusa
                                String suit = cards.get(i).color; // az aktu�lis k�rtya sz�ne
                                String lastCardLineBreak = ""; 
                                if (i == cards.size() - 1) { 
                                        // ha az utols� k�rtya a pakliban, akkor \n-t rakunk minden k�rtyasor v�g�re, hogy �j sorban kezd�dj�n a k�vetkez�
                                        lastCardLineBreak = "\n";
                                }
                                if (j == 0) { // els� sor ( k�rta teteje)
                                        cardLines.get(i)[j] = "+--------+  " + lastCardLineBreak;
                                } else if(j == 1) { // m�sodik sor(balfels� sarokban a t�pus ki�rat�s)
                        if(type.length() > 1) { // ha a t�pus 2 karakteres, akkor eggyel kevesebb space van a v�g�n
                                cardLines.get(i)[j] = ("|" + type + "      |  " + lastCardLineBreak);
                        } else { // ha egy karakteres, akkor eggyel t�bb space van a k�rtya sor�nak v�g�n, hogy ugyanolyan hossz� legyen a sor minden esetben
                                cardLines.get(i)[j] = ("|" + type + "       |  " + lastCardLineBreak);
                        }
                    } else if (j == 2 || j == 4 ) { // ha a 3. vagy 5. sor, akkor egy �res sort sz�r be (a k�rtya sz�ne, �s t�pusa k�z�tti sorok
                        cardLines.get(i)[j] = ("|        |  " + lastCardLineBreak);
                    } else if (j == 5) { // ha az utols� el�tti sor, akkor a jobb als� sarokban van a k�rtya t�pusa
                        if(type.length() > 1) { // ha 2 karakteres, akkor eggyel kevesebb a space
                                cardLines.get(i)[j] = ("|      " + type + "|  " + lastCardLineBreak);
                        } else {
                                cardLines.get(i)[j] = ("|       " + type + "|  " + lastCardLineBreak);
                        }
                    } else if (j == 3) { // ha a 4. sor, akkor a sz�n karakterhossz�s�g�nak megfelel�en �rja ki a k�rtya sor�t
                        if(suit.equals("Treff")) {
                                cardLines.get(i)[j] = ("|  Treff |  " + lastCardLineBreak);
                        } else if(suit.equals("K�r�")) {
                                cardLines.get(i)[j] = ("|  K�r�  |  " + lastCardLineBreak);
                        } else if(suit.equals("K�r")) {
                                cardLines.get(i)[j] = ("|  K�r   |  " + lastCardLineBreak);
                        } else if(suit.equals("Pikk")) {
                                cardLines.get(i)[j] = ("|  Pikk  |  " + lastCardLineBreak);
                        }
                    } else { // az utols� sor ( a k�rtya legalja)
                        cardLines.get(i)[j] = ("+--------+  " + lastCardLineBreak);                     
                    }
                }
                }
                // ha �ssze van rakva az �sszes k�rtya �sszes sora, akkor v�gigmegy�nk soronk�nt 
                for (int i = 0; i < 7; i++) { 
                        //�s minden sorban v�gigmegy�nk az �sszes k�rtya aktu�lis sor�n
                        for (int j = 0; j < cards.size(); j++) {
                                face += cardLines.get(j)[i];
                        }
                }

        System.out.println(face); // ki�rja az �sszes k�rtya �sszes sor�t
        }   
}
