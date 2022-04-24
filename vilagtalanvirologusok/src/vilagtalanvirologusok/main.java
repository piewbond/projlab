package vilagtalanvirologusok;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		// Skeleton skeleton= new Skeleton();
		// skeleton.SkeletonMenu();
		Game game = new Game();
		game.readCommands();
	}
}
