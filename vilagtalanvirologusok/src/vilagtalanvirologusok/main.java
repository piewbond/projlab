package vilagtalanvirologusok;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
		// Skeleton skeleton= new Skeleton();
		// skeleton.SkeletonMenu();
		new TestSkeleton();
		Game game = new Game();
		game.readCommands();
	}
}
