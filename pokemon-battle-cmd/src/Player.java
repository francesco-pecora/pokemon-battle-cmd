import java.util.Random;
import java.util.Scanner;

public class Player {

	// class data
	private String name;
	private Pokemon[] pokemonList;
	private boolean isHuman;
	private int POKEMON_SIZE = 3;  // number of pokemon for each player
	
	Scanner input;
	
	// constructors
	public Player(String n) {
		name = n;
		pokemonList = new Pokemon[POKEMON_SIZE];
		for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
			pokemonList[i] = new Pokemon();
		}
		isHuman = true;
	}
	
	public Player() {
		name = "Computer";
		pokemonList = new Pokemon[POKEMON_SIZE];
		for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
			pokemonList[i] = new Pokemon();
		}
		isHuman = false;
	}
	
	// methods for class data
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	/** This function allows the user to choose a Pokemon from the pokemonList. It does it randomly for the computer.
	 * 
	 * @return a Pokemon object
	 */
	public Pokemon choosePokemon() {
		if(isHuman) {
			System.out.println("Welcome " + name + "! Choose your Pokemon from this list inserting the number...");
			int index = 1;
			for(Pokemon poke : pokemonList) {
				System.out.println(index++ + ") \t" + poke.getName() + "  " + poke.getType() + "  " + poke.getHealth());
			}
			input = new Scanner(System.in);
			int pokemonPicked = input.nextInt();
			return pokemonList[pokemonPicked - 1];
		} else {
			Random r = new Random();
			int pokemonPicked = r.nextInt((POKEMON_SIZE - 1) + 1) + 1;
			return pokemonList[pokemonPicked - 1];
		}
	}
	
	/** This function allows the user to select an Attack from the list of attacks of the just selected Pokemon. If computer user, it does it randomly.
	 * 
	 * @param poke -> Pokemon object from which to select the attacks
	 * @return Attack object selected
	 */
	public Attack chooseAttack(Pokemon poke) {
		if(isHuman) {
			System.out.println("\nChoose your Attack from this list inserting the number...");
			int index = 1;
			for(Attack att : poke.getAttackList()) {
				System.out.println(index++ + ") \t" + att.getName() + "  " + att.getType() + "  " + att.getDamage() + "  " + att.getPossibleHits());
			}
			input = new Scanner(System.in);
			int attackPicked = input.nextInt();
			return poke.getAttackList()[attackPicked - 1];
		} else {
			Random r = new Random();
			int attackPicked = r.nextInt((poke.getAttackList().length - 1) + 1) + 1;
			return poke.getAttackList()[attackPicked - 1];
		}
	}
	
	/** This function represents the attack from one pokemon to the other.
	 * 
	 * @param poke1 the pokemon which is attacking
	 * @param poke2 the Pokemon which is getting attacked
	 * @param att the attack used by poke1 to poke2
	 */
	public void attack(Pokemon poke1, Pokemon poke2, Attack att) {
		
	}
	
	// output function
	public String toString() {
		String s = "";
		s += "\n";
		s += "Player Name: ";
		s += name;
		s += "\n";
		for(Pokemon p : pokemonList) {
			s += "\n";
			s += p.getName();
			s += "\t";
			s += p.getType();
			s += "\t";
			s += Integer.toString(p.getHealth());
			s += "\n";
			for(Attack a : p.getAttackList()) {
				s += a.getName();
				s += "\n";
				s += a.getPossibleHits();
				s += "\n";
				s += a.getDamage();
				s += "\n";
			}
		}
		return s;
	}
	
}
