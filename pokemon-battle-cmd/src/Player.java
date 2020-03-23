
public class Player {

	// class data
	private String name;
	private Pokemon[] pokemonList;
	private boolean isHuman;
	private int POKEMON_SIZE = 3;
	
	// constructor
	public Player(String n, Pokemon[] p) {
		name = n;
		pokemonList = p;
		isHuman = true;
	}
	
	public Player(boolean isIt) {
		if(isIt == false) {
			name = "Computer";
			pokemonList = new Pokemon[POKEMON_SIZE];
			for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
				pokemonList[i] = new Pokemon();
			}
		}
		else {
			throw new IllegalStateException("If a human player, pass the name (String) and an array of Pokemon...");
		}
	}
	
	// methods for class data
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
}
