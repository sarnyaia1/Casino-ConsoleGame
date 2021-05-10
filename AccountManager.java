import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManager { // a játékosok nevének és zsetonjának írása, olvasása
	private ArrayList<String[]> accountList = new ArrayList<String[]>(); // Ebben tároljuk a már mentett játékosokat zsetonjaikkal
	
	public void saveAccount (Player player) { // ha elhagyta a kaszinót, akkor elmenteni a játékost a zsetonjainak számával
		this.updateAccount(player); // felülírni a már meglévõ zsetonösszeget az adott játékoshoz

		try { 
			FileWriter writer = new FileWriter("accounts.txt");
			
			for(int i=0;i<this.accountList.size();i++) { // végigmegy az összes már elmentett játékoson
				//szóközzel elválasztva a nevét és zsetonját
				String accountLine = this.accountList.get(i)[0] + " " + this.accountList.get(i)[1];
				// fálj következõ sorába írja a fent összerakott stringet
				writer.write(i == this.accountList.size()-1 ? accountLine : accountLine + "\n");
			}
			
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	public int getAccount (String name) {
		int balance = 0;
		try {
			File yourFile = new File("accounts.txt");
			yourFile.createNewFile(); // nem csinál semmit, ha már létezik a fájl, egyébként meg létrehozza

			FileReader fileReader = new FileReader("accounts.txt"); // beolvassuk az accounts.txt tartalmát
			BufferedReader buffer = new BufferedReader(fileReader);
			
			String line = null;
			// amíg van beolvasnivaló, addig olvass be soronként
			while((line = buffer.readLine()) != null) {
				String[] account = line.split(" "); // az aktuális sort kettészedjük a szóköznél, hogy megkapjuk a nevét és a zsetonját is
				this.accountList.add(account);
				
				if (name.toLowerCase().equals(account[0].toLowerCase())) { // ha megvan a játékos,
					balance = Integer.parseInt(account[1]); // akkor kiolvassuk a zsetonjait 
				}
			}
			buffer.close();
			fileReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return balance; // visszatérünk a játékos zsetonjaival ( ha nem találjuk meg, akkor 0 az alapérték
	}
	
	private void updateAccount(Player player) { // a játék végeztével a zsetonjait frissítjük
		boolean found = false;

		for(int i=0; i<this.accountList.size();i++) { // végigmegyünk az összes eddig tárolt játékoson
			if(player.name.toLowerCase().equals(accountList.get(i)[0].toLowerCase())) { // ha megvan a mostani játékos köztük, 
				this.accountList.get(i)[1] = String.valueOf(player.getBalance()); // akkor frissítjük az új zsetonjainak számával
				found = true;
				
				break;
			}
		}
		
		if (!found) { // ha nem találtuk meg
			String[] account = {player.name, String.valueOf(player.getBalance())}; // akkor hozzáadjuk az elmentett játékosokhoz
			this.accountList.add(account);
		}
	}
}

