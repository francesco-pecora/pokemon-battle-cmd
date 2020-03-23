
public class Attack {
	
	// class data
	private String name;
	private String type;
	private int possibleHits;
	
	// class constructors
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
