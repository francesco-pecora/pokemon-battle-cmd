import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Attack {
	
	// class data
	private String name;
	private String type;
	private int possibleHits;
	
	Scanner input;
	
	private String PATH = "C:\\Users\\franc\\Desktop\\gitHubRepositories\\pokemon-battle-cmd\\pokemon-battle-cmd\\src\\attacks\\";
	
	// class constructors
	public Attack(String pokeType) {
		try {
			pokeType = pokeType.toLowerCase().strip();
			if(pokeType.equals("fire")) input = new Scanner(new File(PATH + "FireAttacks"));
			else if(pokeType.equals("grass")) input = new Scanner(new File(PATH + "GrassAttacks"));
			else if(pokeType.equals("water")) input = new Scanner(new File(PATH + "WaterAttacks"));
			else throw new IllegalStateException("Wrong Pokemon type passed to the Attack Constructor...");
		}
		catch (Exception e) {
			 System.out.println("Error opening the file...");
			 e.printStackTrace();
			 System.exit(0);	 
		}
		
		// getting the data from the file into an Array List of Strings
		ArrayList<String> attacks = new ArrayList<String>();
		ArrayList<String> hits = new ArrayList<String>();
		while(input.hasNextLine()){
			attacks.add(input.next());
			hits.add(input.next());
		}
		
		// select a random attack from the list
		Random r = new Random();
		int randomNumber = r.nextInt(attacks.size());
		
		// initializing class data
		name = attacks.get(randomNumber);
		type = pokeType;
		possibleHits = Integer.parseInt(hits.get(randomNumber));
	}
	
	public Attack(String n, String t, int p) {
		name = n;
		type = t;
		possibleHits = p;
	}
	
	// methods for class data
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void setType(String t) {
		type = t;
	}
	public String getType() {
		return type;
	}
	
	public void setPossibleHits(int p) {
		possibleHits = p;
	}
	public int getPossibleHits() {
		return possibleHits;
	}
	
}
