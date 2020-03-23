import java.util.Scanner; 
import java.io.File;
import java.util.Random;

public class Pokemon {

	// class data
	private String name;
	private String type;
	private int health;
	private Attack[] attackList;
	
	Scanner input;
	
	private int POKEMON_SIZE = 3;
	private int ATTACK_SIZE = 4;
	
	
	// class constructors
	public Pokemon() {
		
		// calculating a random number between 1 and POKEMON_SIZE(3)
		Random r = new Random();
		int randomNumber = r.nextInt((POKEMON_SIZE - 1) + 1) + 1;
		
		try {
			// picking a random pokemon between the three starters
			if(randomNumber == 1) input = new Scanner(new File("./Bulbasaur.txt"));
			else if(randomNumber == 2) input = new Scanner(new File("./Charmender.txt"));
			else if(randomNumber == 3) input = new Scanner(new File("./Squirtle.txt"));
			else throw new IllegalStateException("Random number is not in the right range...");
		}
		 catch (Exception e) {
			 System.out.println("Error opening the file...");
			 e.printStackTrace();
			 System.exit(0);	 
		 }
		
		// CODE TO INITIALIZE THE ATTACK LIST
		
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
	
	public void setHealth(int h) {
		health = h;
	}
	public int getHealth() {
		return health;
	}
}
