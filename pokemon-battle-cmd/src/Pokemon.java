import java.util.Scanner; 
import java.io.File;
import java.util.Random;
import java.util.ArrayList;

public class Pokemon {

	// class data
	private String name;
	private String type;
	private double health;
	private Attack[] attackList;
	
	Scanner input;
	
	private int POKEMON_SIZE = 3;  // number of pokemon available
	private int ATTACK_SIZE = 4;   // number of attacks each pokemon has
	private String PATH = "C:\\Users\\franc\\Desktop\\gitHubRepositories\\pokemon-battle-cmd\\pokemon-battle-cmd\\src\\pokemon\\";
	
	
	// class constructors
	public Pokemon() {
		
		// calculating a random number between 1 and POKEMON_SIZE(3)
		Random r = new Random();
		int randomNumber = r.nextInt((POKEMON_SIZE - 1) + 1) + 1;
		
		try {
			// picking a random pokemon between the three starters
			if(randomNumber == 1) input = new Scanner(new File(PATH + "Bulbasaur"));
			else if(randomNumber == 2) input = new Scanner(new File(PATH + "Charmender"));
			else if(randomNumber == 3) input = new Scanner(new File(PATH + "Squirtle"));
			else throw new ArrayIndexOutOfBoundsException("Random number is not in the right range...");
		}
		 catch (Exception e) {
			 System.out.println("Error opening the file...");
			 e.printStackTrace();
			 System.exit(0);	 
		 }
		
		// initializing class data
		ArrayList<String> pokemonData = new ArrayList<String>();
		while(input.hasNext()) {
			pokemonData.add(input.next());
		}
		name = pokemonData.get(0);
		type = pokemonData.get(1);
		health = Integer.parseInt(pokemonData.get(2));
		
		// initializing attackList
		attackList = new Attack[ATTACK_SIZE];
		for(int i = 0; i < ATTACK_SIZE; i++) {
			attackList[i] = new Attack(type);
		}
		
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
	
	public void setHealth(double h) {
		health = h;
	}
	public double getHealth() {
		return health;
	}
	
	public Attack[] getAttackList() {
		return attackList;
	}
	
	public String toString() {
		String s = "";
		s += "\nPokemon Name: ";
		s += name;
		s += "\nPokemon Type: ";
		s += type;
		s += "\nPokemon Health: ";
		s += health;
		return s;
	}
}
