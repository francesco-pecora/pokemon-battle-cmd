import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Player {

	// class data
	private String name;
	private Pokemon[] pokemonList;
	private boolean isHuman;
	private int POKEMON_SIZE = 1;  // number of pokemon for each player
	
	public HashMap<String, String> damageRelations;
	Scanner input;
	
	// constructors
	// an HashMap stores the types of the attacks to the relates types for which the first type is more effective
	// this makes it easier to modify the damage depending on the type of the attack and the type of the pokemon
	public Player(String n) {
		name = n;
		pokemonList = new Pokemon[POKEMON_SIZE];
		for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
			pokemonList[i] = new Pokemon();
		}
		isHuman = true;
		damageRelations = new HashMap<String, String>();
		damageRelations.put("fire", "grass");
		damageRelations.put("water", "fire");
		damageRelations.put("grass", "water");
	}
	public Player() {
		name = "Computer";
		pokemonList = new Pokemon[POKEMON_SIZE];
		for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
			pokemonList[i] = new Pokemon();
		}
		isHuman = false;
		damageRelations = new HashMap<String, String>();
		damageRelations.put("fire", "grass");
		damageRelations.put("water", "fire");
		damageRelations.put("grass", "water");
	}
	
	// methods for class data
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public int getPOKEMON_SIZE() {
		return POKEMON_SIZE;
	}
	
	/** This function allows the user to choose a Pokemon from the pokemonList. It does it randomly for the computer.
	 * 
	 * @return a Pokemon object
	 */
	public Pokemon choosePokemon() {
		
		int pokemonPicked;
		
		if(isHuman) {
			System.out.println(name + "! Choose your Pokemon from this list inserting the number...");
			int index = 1;
			for(Pokemon poke : pokemonList) {
				if(!(poke.getHealth() <= 0)) System.out.println(index++ + ") \t" + poke.getName() + "  " + poke.getType() + "  " + poke.getHealth());
				else index++;
			}
			input = new Scanner(System.in);
			pokemonPicked = input.nextInt();
			return pokemonList[pokemonPicked - 1];
		} else {
			Random r = new Random();
			pokemonPicked = r.nextInt((POKEMON_SIZE - 1) + 1) + 1;
			while(pokemonList[pokemonPicked - 1].getHealth() <= 0) {
				pokemonPicked = r.nextInt((POKEMON_SIZE - 1) + 1) + 1;
			}
			return pokemonList[pokemonPicked - 1];
		}
	}
	
	/** This function allows the user to select an Attack from the list of attacks of the just selected Pokemon. If computer user, it does it randomly.
	 * 
	 * @param poke -> Pokemon object from which to select the attacks
	 * @return Attack object selected
	 */
	public Attack chooseAttack(Pokemon poke) {
		while(true) {
			if(isHuman) {
				System.out.println("\nChoose your Attack from this list inserting the number...");
				int index = 1;
				for(Attack att : poke.getAttackList()) {
					System.out.println(index++ + ") \t" + att);
				}
				input = new Scanner(System.in);
				int attackPicked = input.nextInt();
				//making sure the attack as enough possible hits
				if (poke.getAttackList()[attackPicked - 1].getPossibleHits() > 0) return poke.getAttackList()[attackPicked - 1];
				else continue;
			} else {
				Random r = new Random();
				int attackPicked = r.nextInt((poke.getAttackList().length - 1) + 1) + 1;
				//making sure the attack as enough possible hits
				if (poke.getAttackList()[attackPicked - 1].getPossibleHits() > 0) return poke.getAttackList()[attackPicked - 1];
				else continue;
			}
		}
	}
	
	/** This function represents the attack from one pokemon to the other.
	 * 
	 * @param poke1 the pokemon which is attacking
	 * @param poke2 the Pokemon which is getting attacked
	 * @param att the attack used by poke1 to poke2
	 */
	public boolean attack(Pokemon poke1, Pokemon poke2, Attack att) {

		double coeff; // this value is gonna multiply the damage. If the type of Poke1 is super efficient against the type of Poke2 the damage will be higher
		
		//retrieving types of pokemons
		String typePoke1 = poke1.getType();
		String typePoke2 = poke2.getType();
		String mostEfficientEnemyType = damageRelations.get(typePoke1);
		
		if(typePoke1.equals(typePoke2)) coeff = 1.0;
		else if (typePoke2.equals(mostEfficientEnemyType)) coeff = 1.5;
		else coeff = 0.5;
		
		//updating health of pokemon attacked and possible hits of the attack used
		poke2.setHealth(poke2.getHealth() - (coeff * att.getDamage()));
		att.setPossibleHits(att.getPossibleHits() - 1);
		
		if(poke2.getHealth() <= 0) return true; //if this function returns 1 we know the battle is ended
		else return false; // if the function returns 0, then the battle is still continuing
	}
	
	// output function
	public String toString() {
		String s = "";
		s += "\n";
		s += "Player Name: ";
		s += name;
		s += "\n";
		for(Pokemon p : pokemonList) {
			s += "\nPokemon Name: ";
			s += p.getName();
			s += "\tPokemon Type: ";
			s += p.getType();
			s += "\tPokemon Health: ";
			s += Double.toString(p.getHealth());
			s += "\n";
			for(Attack a : p.getAttackList()) {
				s += "Attack Name: ";
				s += a.getName();
				s += "\nPossible Hits: ";
				s += a.getPossibleHits();
				s += "\nDamage: ";
				s += a.getDamage();
				s += "\n";
			}
		}
		return s;
	}
	
}
