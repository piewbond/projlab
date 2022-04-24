package vilagtalanvirologusok;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A játékot kezeli. A játék indításakor létrehozza a pályát.
 * A körök végén ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot.
 */
public class Game {
    private Virologist activeVirologist = null;
    private ArrayList<Virologist> virologists;
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

            // auto active virologist detection
            if (activeVirologist == null && virologists.size() > 0) {
                activeVirologist = virologists.get(0);
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
                    System.out.println("Game started\n");
                case "createMap":
                case "removeVirologist":
                    Virologist remove = findVirologist(parsed[1]);
                    virologists.remove(remove);
                    break;
                case "addVirologist":
                    Virologist v = new Virologist(parsed[1], parsed[2]);   // TODO position
                    virologists.add(v);
                    break;
                case "addEntity":
                case "learnGC":
                    Virologist learner = findVirologist(parsed[1]);
                    Laboratory loc = (Laboratory) learner.getLocation();
                    GeneticCode gc = loc.getGC();
                    findVirologist(parsed[1]).LearnGeneticCode(gc);
                    break;
                case "pickupMaterial":
                    findVirologist(parsed[1]).PickupMaterial(null); // TODO material
                    break;
                case "removeMaterial":
                    findVirologist(parsed[1]).RemoveMaterial(null);
                    break;
                case "pickupEquipment":
                    findVirologist(parsed[1]).PickupEquipment(null);
                    break;
                case "removeEquipment":
                    findVirologist(parsed[1]).RemoveEquipment(null);
                    break;
                case "touch":
                    findVirologist(parsed[1]).Touch(findVirologist(parsed[2]), null);
                    break;
                case "load":
                case "move":
                    findVirologist(parsed[1]).Move();
                    break;
                case "craftAgent":
                    GeneticCode geneticCode = (GeneticCode) findVirologist(parsed[1]).getGeneticCode();
                    findVirologist(parsed[1]).CraftAgent(geneticCode);
                    break;
                case "useAgent":
                    findVirologist(parsed[1]); // TODO
                    break;
                case "useEquipment":
                    findVirologist(parsed[1]);
                    break;
                case "steal":
                    findVirologist(parsed[1]).StealEquipment(findVirologist(parsed[2]));
                    break;
                case "nextTurn":
                    this.turnable.EndTurn();
                    break;
                case "save":
                case "list":
                case "setActive":
                    this.activeVirologist = findVirologist(parsed[1]);
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

    public void printState() {

    }

    public Virologist findVirologist(String name) {
        Virologist res = null;
        for (int i = 0; i < virologists.size(); i++) {
            if (virologists.get(i).getName().equals(name)) {
                res = virologists.get(i);
            }
        }
        return res;
    }
}
