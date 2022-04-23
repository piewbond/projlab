package vilagtalanvirologusok;

import java.util.Scanner;

public class main {

	public void main(String[] args) {
		// Skeleton skeleton= new Skeleton();
		// skeleton.SkeletonMenu();
		readCommands();
	}

	public void readCommands() {
		for(;;) {
			Scanner scanner = new Scanner(System.in);
			String command = scanner.nextLine();
			parse(command);
		}
	}

	public void parse(String cmd) {
		String[] parsed = cmd.split("");

		switch(parsed[0])
		{
			case "start":
			case "createMap":
			case "removeVirologist":
			case "addVirologist":
			case "addEntity":
			case "learnGC":
			case "pickupMaterial":
			case "removeMaterial":
			case "pickupEquipment":
			case "removeEquipment":
			case "touch":
			case "load":
			case "move":
			case "craftAgent":
			case "useAgent":
			case "useEquipment":
			case "steal":
			case "nextTurn":
			case "save":
			case "list":
			case "setActive":
			case "rand":
		};
	}

}
