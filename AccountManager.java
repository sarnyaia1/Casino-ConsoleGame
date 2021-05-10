import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManager { // a j�t�kosok nev�nek �s zsetonj�nak �r�sa, olvas�sa
	private ArrayList<String[]> accountList = new ArrayList<String[]>(); // Ebben t�roljuk a m�r mentett j�t�kosokat zsetonjaikkal
	
	public void saveAccount (Player player) { // ha elhagyta a kaszin�t, akkor elmenteni a j�t�kost a zsetonjainak sz�m�val
		this.updateAccount(player); // fel�l�rni a m�r megl�v� zseton�sszeget az adott j�t�koshoz

		try { 
			FileWriter writer = new FileWriter("accounts.txt");
			
			for(int i=0;i<this.accountList.size();i++) { // v�gigmegy az �sszes m�r elmentett j�t�koson
				//sz�k�zzel elv�lasztva a nev�t �s zsetonj�t
				String accountLine = this.accountList.get(i)[0] + " " + this.accountList.get(i)[1];
				// f�lj k�vetkez� sor�ba �rja a fent �sszerakott stringet
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
			yourFile.createNewFile(); // nem csin�l semmit, ha m�r l�tezik a f�jl, egy�bk�nt meg l�trehozza

			FileReader fileReader = new FileReader("accounts.txt"); // beolvassuk az accounts.txt tartalm�t
			BufferedReader buffer = new BufferedReader(fileReader);
			
			String line = null;
			// am�g van beolvasnival�, addig olvass be soronk�nt
			while((line = buffer.readLine()) != null) {
				String[] account = line.split(" "); // az aktu�lis sort kett�szedj�k a sz�k�zn�l, hogy megkapjuk a nev�t �s a zsetonj�t is
				this.accountList.add(account);
				
				if (name.toLowerCase().equals(account[0].toLowerCase())) { // ha megvan a j�t�kos,
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

		return balance; // visszat�r�nk a j�t�kos zsetonjaival ( ha nem tal�ljuk meg, akkor 0 az alap�rt�k
	}
	
	private void updateAccount(Player player) { // a j�t�k v�gezt�vel a zsetonjait friss�tj�k
		boolean found = false;

		for(int i=0; i<this.accountList.size();i++) { // v�gigmegy�nk az �sszes eddig t�rolt j�t�koson
			if(player.name.toLowerCase().equals(accountList.get(i)[0].toLowerCase())) { // ha megvan a mostani j�t�kos k�zt�k, 
				this.accountList.get(i)[1] = String.valueOf(player.getBalance()); // akkor friss�tj�k az �j zsetonjainak sz�m�val
				found = true;
				
				break;
			}
		}
		
		if (!found) { // ha nem tal�ltuk meg
			String[] account = {player.name, String.valueOf(player.getBalance())}; // akkor hozz�adjuk az elmentett j�t�kosokhoz
			this.accountList.add(account);
		}
	}
}

