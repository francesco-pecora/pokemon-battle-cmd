import java.awt.image.*;
import java.awt.*;
import java.awt.Font;

public class PokemonRunner {

	public static void main(String[] args) {
		
		printTitle("POKEMON", "|");
		
		Player computer = new Player(false);
		Player user = new Player("Francesco");
		System.out.println(computer);
		System.out.println(user);

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
