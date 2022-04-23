package vilagtalanvirologusok;

import java.util.Scanner;

/**
 * A játékot kezeli. A játék indításakor létrehozza a pályát.
 * A körök végén ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot.
 */
public class Game {
    public Turnable turnable;
    /**
     *  Inicializálja a játék kezdéséhez szükséges objektumokat.
     */
    public void StartGame()
    {
        System.out.println("Game: StartGame()");
    }

    /**
     * Leállítja a játékot, nyereség vagy veszteség hatására hívódik meg.
     */
    public void EndGame(){
        System.out.println("Game: EndGame()");
    }

    /**
     *  Minden körben ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot,
     *  és ha van, meghívja az +EndGame(): void metódust.
     */
    public void CheckEndGame(){
        System.out.println("Game: CheckEndGame()");
    }


    public void readCommands() {
        for(;;) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }
            parse(command);
        }
        System.exit(0);

    }

    public void parse(String cmd) {
        String[] parsed = cmd.split("");

        if (argCount(parsed)) {
            switch (parsed[0]) {
                case "start":
                case "createMap":
                case "removeVirologist":
                case "addVirologist":
                    Virologist v = new Virologist(parsed[1]);   // TODO position
                    break;
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
            }
            ;
        }
    }


    public boolean argCount(String[] cmd) {
        switch(cmd[0])
        {
            case "start": 				if (cmd.length == 1) {return true;}
            case "createMap":			if (cmd.length == 1) {return true;}
            case "removeVirologist":	if (cmd.length == 2) {return true;}
            case "addVirologist":		if (cmd.length == 3) {return true;}
            case "addEntity":			if (cmd.length == 3) {return true;}
            case "learnGC":				if (cmd.length == 2) {return true;}
            case "pickupMaterial":		if (cmd.length == 3) {return true;}
            case "removeMaterial":		if (cmd.length == 3) {return true;}
            case "pickupEquipment":		if (cmd.length == 3) {return true;}
            case "removeEquipment":		if (cmd.length == 3) {return true;}
            case "touch":				if (cmd.length == 1) {return true;}
            case "load":				if (cmd.length == 2) {return true;}
            case "move":				if (cmd.length == 3) {return true;}
            case "craftAgent":			if (cmd.length == 3) {return true;}
            case "useAgent":			if (cmd.length == 3) {return true;}
            case "useEquipment":		if (cmd.length == 4) {return true;}
            case "steal":				if (cmd.length == 4) {return true;}
            case "nextTurn":			if (cmd.length == 1) {return true;}
            case "save":				if (cmd.length == 2) {return true;}
            case "list":				if (cmd.length == 2) {return true;}
            case "setActive":			if (cmd.length == 2) {return true;}
            case "rand":				if (cmd.length == 2) {return true;}
        };
        return false;
    }
}
