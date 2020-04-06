import java.awt.image.*;
import java.awt.*;
import java.awt.Font;

public class PokemonRunner {

	public static void main(String[] args) {
		//printTitle("POKEMON", "|");
		
		Attack att1;
		Attack att2;
		
		Player computer = new Player();
		Player user = new Player("Francesco");
		
		int POKEMON_SIZE_USER = user.getPOKEMON_SIZE();
		int POKEMON_SIZE_COMPUTER = computer.getPOKEMON_SIZE();
		
		boolean isBattleOver;
		
		start:
			
		while(POKEMON_SIZE_USER > 0 && POKEMON_SIZE_COMPUTER > 0) {
			
			isBattleOver = false;
			
			Pokemon poke1 = user.choosePokemon();
			Pokemon poke2 = computer.choosePokemon();
			
			System.out.println();
			System.out.println();
			
			System.out.println("User Pokemon: ");
			System.out.println(poke1);
			System.out.println("Computer Pokemon: ");
			System.out.println(poke2);
			
			System.out.println();
			System.out.println();
			
			while(true) {
				System.out.println("Choose your attack!");
				att1 = user.chooseAttack(poke1);
				att2 = computer.chooseAttack(poke2);
				
				System.out.println();
				System.out.println();
				
				System.out.println("User Attack: ");
				System.out.println(att1);
				
				System.out.println();
				System.out.println();
				
				System.out.println("Computer Attack: ");
				System.out.println(att2);
				
				System.out.println();
				System.out.println();
				
				isBattleOver = user.attack(poke1, poke2, att1);
				System.out.println("\nYour pokemon is using " + att1.getName() + " on the computer's pokemon...\n");
				if(isBattleOver) {
					System.out.println("\nYour pokemon killed the computer's pokemon! The computer pokemon does not have any more HPs");
					POKEMON_SIZE_COMPUTER -= 1;
					continue start;
				}
				
				isBattleOver = computer.attack(poke2, poke1, att2);
				System.out.println("\nComputer's pokemon is using " + att2.getName() + " on the your pokemon...\n");
				if(isBattleOver) {
					System.out.println("\nThe computer's pokemon killed your pokemon! Your pokemon does not have any more HPs");
					POKEMON_SIZE_USER -= 1;
					continue start;
				}
				System.out.println("\nInfo about the two pokemons after the attacks:\n");
				System.out.println(poke1);
				System.out.println(poke2);
			}
		}
		if(POKEMON_SIZE_USER == 0) System.out.println("You lost the battle. Try again next time...");
		else if(POKEMON_SIZE_COMPUTER == 0) System.out.println("You won! Go heal you pokemon now!");
	}
	
	/** Function that prints the title in a more artistic way using a symbol passed from the user as a parameter.
	 * 	More information about this code at https://www.baeldung.com/ascii-art-in-java
	 * 
	 * @param text -> string that we want to display on the artwork
	 * @param artChar -> character that we want to use to fill the spaces
	 * @param settings -> sets the width, height and font of the art
	 */
	public static void printTitle(String text, String artChar) {
		Font f = new Font("SansSerif,", Font.BOLD, 25); // 25 is the size of the text
		Settings settings = new Settings(f, 145, 25);	// 145 width of the title, 25 height of the title
		BufferedImage image = new BufferedImage(settings.width, settings.height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D graphics2D = getGraphics2D(image.getGraphics(), settings);
        graphics2D.drawString(text, 6, ((int) (settings.height * 0.85))); // second and third parameter passed are the position of the text in the title (width and height)

        for (int y = 0; y < settings.height; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = 0; x < settings.width; x++) {
                stringBuilder.append(image.getRGB(x, y) == -16777216 ? artChar : " ");
            }
            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            
            System.out.println(stringBuilder);
            
        }
	}
	
	/** Function that returns a Graphics2D object in which the text is going to be drawn.
	 * 
	 * @param graphics object
	 * @param settings -> specifies the font, width and height of the text
	 * @return Graphics2D object
	 */
	public static Graphics2D getGraphics2D(Graphics graphics, Settings settings) {
		graphics.setFont(settings.font);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        return graphics2D;
	}
}
