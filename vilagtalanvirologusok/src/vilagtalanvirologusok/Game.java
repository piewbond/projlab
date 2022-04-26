package vilagtalanvirologusok;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
public class Game implements Serializable {
    private Virologist activeVirologist = null;
    private ArrayList<Virologist> virologists = new ArrayList<Virologist>();
    private ArrayList<Material> materials = new ArrayList<Material>();
    private ArrayList<Equipment> equipments = new ArrayList<Equipment>();
    private ArrayList<Agent> agents = new ArrayList<Agent>();
    private boolean random = true;
    private int turnCount = 1;
    public Turnable turnable = new Turnable();
    private int playercount=1;
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
                    map.findVirologist(parsed[1]).getLocation().RemoveVirologist(map.findVirologist(parsed[1]));
                    break;
                case "addVirologist":
                    if (playercount <= 2) {
                        Virologist v = new Virologist(parsed[1], map.getCenter(parsed[2]), playercount);
                        map.getCenter(parsed[2]).AddVirologist(v);
                        this.activeVirologist = v;
                        virologists.add(v);
                        playercount++;
                    }
                    else {
                        System.out.println("You have reached maximum player number...");
                    }
                    break;
                case "touch":
                    map.findVirologist(parsed[1]).Touch(map.findVirologist(parsed[2]), null); // TODO
                    break;
                case "load":
                    this.map = readXML(parsed[1]);
                    break;
                case "move":
                    map.findVirologist(parsed[1]).Move(false);
                    break;
                case "craftAgent":

                    ArrayList<GeneticCode> geneticCodes = map.findVirologist(parsed[1]).getGeneticCode();
                    if (geneticCodes != null) {
                        System.out.println(geneticCodes);
                        Scanner sc = new Scanner(System.in);
                        String ans = sc.nextLine();
                        map.findVirologist(parsed[1]).CraftAgent(geneticCodes.get(Integer.parseInt(ans)));
                    }
                    break;
                case "useAgent":
                    map.findVirologist(parsed[1]).Kill(map.findVirologist(parsed[2])); // TODO
                    break;
                case "add":
                    map.findVirologist(parsed[1]).LearnGeneticCode(new ProtectorCode());
                    map.findVirologist(parsed[1]).PickupMaterial(new Aminoacid());
                    map.findVirologist(parsed[1]).PickupMaterial(new Nucleotide());
                case "useEquipment":
                    map.findVirologist(parsed[1]).Kill(map.findVirologist(parsed[2]));
                    break;
                case "steal":
                    map.findVirologist(parsed[1]).StealEquipment(map.findVirologist(parsed[2]));
                    break;
                case "nextTurn":
                    this.turnable.EndTurn();
                    if (playercount == 1) {playercount = 2;}
                    else {playercount = 1;}
                    this.activeVirologist = map.findVirologistByNum(playercount);
                    this.turnCount++;
                    break;
                case "save":
                    writeXML(parsed[1]);
                    break;
                case "list":
                    break;
                case "setActive":
                    this.activeVirologist = map.findVirologist(parsed[1]);
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
            case "touch":
                if (cmd.length == 1) {return true;}
                break;
            case "load":
                if (cmd.length == 2) {return true;}
                break;
            case "move":
                if (cmd.length == 2) {return true;}
                break;
            case "craftAgent":
                if (cmd.length == 2) {return true;}
                break;
            case "useAgent":
                if (cmd.length == 3) {return true;}
                break;
            case "useEquipment":
                if (cmd.length == 3) {return true;}
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
                if (cmd.length == 1) {return true;}
                break;
            case "add":
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

        for (Center center : map.centers) {
            List<Virologist> vir = center.getVirologists();
            for (Virologist v : vir) {
                System.out.println(v.toString());
            }
        }
    }


    public void writeXML(String fileName) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // File file = new File(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream obj = new ObjectOutputStream(fos);

            obj.writeObject(map);
            obj.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public Map readXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream obj = new ObjectInputStream(fis);

            Map loaded = (Map) obj.readObject();
            obj.close();
            return loaded;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
