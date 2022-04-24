package vilagtalanvirologusok;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * A játékot kezeli. A játék indításakor létrehozza a pályát.
 * A körök végén ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot.
 */
public class Game {
    private Virologist activeVirologist = null;
    private ArrayList<Virologist> virologists = new ArrayList<Virologist>();
    private boolean random = true;
    private int turnCount = 1;
    public Turnable turnable = new Turnable();
    Map map = new Map();
    /**
     *  Inicializálja a játék kezdéséhez szükséges objektumokat.
     */
    public void StartGame()
    {
        // System.out.println("Game: StartGame()");
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

    public boolean getRand() {
        return this.random;
    }


    public void readCommands() throws ParserConfigurationException, IOException, SAXException, TransformerException {
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

            parsecmd(command);
        }
        System.exit(0);

    }

    public void parsecmd(String cmd) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String[] parsed = cmd.split(" ");

        if (argCount(parsed)) {
            switch (parsed[0]) {
                case "start":
                    System.out.println("Game started\n");
                    break;
                case "createMap":
                    map.GenerateGraph();
                    break;
                case "removeVirologist":
                    Virologist remove = findVirologist(parsed[1]);
                    virologists.remove(remove);
                    break;
                case "addVirologist":
                    Virologist v = new Virologist(parsed[1], map.getCenter(parsed[2]));   // TODO position
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
                    readXML(parsed[1]);
                    break;
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
                    this.turnCount++;
                    break;
                case "save":
                    writeXML(parsed[1]);
                    break;
                case "list":
                case "setActive":
                    this.activeVirologist = findVirologist(parsed[1]);
                    break;
                case "rand":
                    if (parsed[1].equals("on")) {
                        this.random = true;
                    }
                    if (parsed[1].equals("off")) {
                        this.random = false;
                    }
                    else {
                        System.out.println("Wrong argument");
                    }
                    break;
                default:
                    System.out.println("Wrong command");
            };
            printState();

        }
        else {
            System.out.println("Wrong command");
        }
    }


    public boolean argCount(String[] cmd) {
        switch(cmd[0])
        {
            case "start":
                if (cmd.length == 1) {return true;}
                break;
            case "createMap":
                if (cmd.length == 1) {return true;}
                break;
            case "removeVirologist":
                if (cmd.length == 2) {return true;}
                break;
            case "addVirologist":
                if (cmd.length == 3) {return true;}
                break;
            case "addEntity":
                if (cmd.length == 3) {return true;}
                break;
            case "learnGC":
                if (cmd.length == 2) {return true;}
                break;
            case "pickupMaterial":
                if (cmd.length == 3) {return true;}
                break;
            case "removeMaterial":
                if (cmd.length == 3) {return true;}
                break;
            case "pickupEquipment":
                if (cmd.length == 3) {return true;}
                break;
            case "removeEquipment":
                if (cmd.length == 3) {return true;}
                break;
            case "touch":
                if (cmd.length == 1) {return true;}
                break;
            case "load":
                if (cmd.length == 2) {return true;}
                break;
            case "move":
                if (cmd.length == 3) {return true;}
                break;
            case "craftAgent":
                if (cmd.length == 3) {return true;}
                break;
            case "useAgent":
                if (cmd.length == 3) {return true;}
                break;
            case "useEquipment":
                if (cmd.length == 4) {return true;}
                break;
            case "steal":
                if (cmd.length == 4) {return true;}
                break;
            case "nextTurn":
                if (cmd.length == 1) {return true;}
                break;
            case "save":
                if (cmd.length == 2) {return true;}
                break;
            case "list":
                if (cmd.length == 2) {return true;}
                break;
            case "setActive":
                if (cmd.length == 2) {return true;}
                break;
            case "rand":
                if (cmd.length == 2) {return true;}
                break;
        };
        return false;
    }

    public void printState() {
        System.out.println("Evaluation of Turn " + turnCount + "\n");
        if (this.activeVirologist != null) {
            System.out.println("Active virologist: " + activeVirologist.getName() + "\n");
        }
        System.out.println("Virologists:\n");

        if (this.virologists.size() > 0) {
            for (Virologist virologist : virologists) {
                System.out.println(virologist.toString());
            }
        }
    }

    public Virologist findVirologist(String name) {
        Virologist res = null;
        for (Virologist virologist : virologists) {
            if (virologist.getName().equals(name)) {
                res = virologist;
            }
        }
        return res;
    }


    public void writeXML(String fileName) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File file = new File(fileName);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element root = doc.createElement("virologists");
        doc.appendChild(root);

        for (Virologist v : virologists) {
            Element virologist = doc.createElement(v.getName());
            root.appendChild(virologist);
            virologist.setAttribute("name", v.getName());
            virologist.setAttribute("equipments", v.getEquipments().toString());
            virologist.setAttribute("agents", v.getActiveAgents().toString());
            virologist.setAttribute("materials", v.getMaterials().toString());
        }

        Element entities = doc.createElement("entities");
        doc.appendChild(entities);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(fileName));
        transformer.transform(source, result);

    }


    public void readXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(fileName);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);


    }
}
