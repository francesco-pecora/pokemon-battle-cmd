
public class Player {

	// class data
	private String name;
	private Pokemon[] pokemonList;
	private boolean isHuman;
	private int POKEMON_SIZE = 3;
	
	// constructor
	public Player(String n) {
		name = n;
		pokemonList = new Pokemon[POKEMON_SIZE];
		for(int i = 0; i < POKEMON_SIZE; i++) {		// random pokemonList for computer using Pokemon constructor
			pokemonList[i] = new Pokemon();
		}
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
			throw new IllegalStateException("If a human player, pass the name as a String to the constructor...");
		}
	}
	
	// methods for class data
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	// battling methods
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
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
		}
		return s;
	}
	
}
