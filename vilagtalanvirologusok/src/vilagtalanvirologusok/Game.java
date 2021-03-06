package vilagtalanvirologusok;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;


/**
 * A játékot kezeli. A játék indításakor létrehozza a pályát.
 * A körök végén ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot.
 */
public class Game implements Serializable {
    private Virologist activeVirologist = null;
    private ArrayList<Virologist> virologists = new ArrayList<>();
    private boolean random = true;
    private int turnCount = 1;
    private int playercount=1;
    Map map;
    /**
     *  Inicializálja a játék kezdéséhez szükséges objektumokat.
     */
    public void StartGame()
    {
        map = new Map();
        map.GenerateGraph();
        Virologist v1 = new Virologist("Red",map.getCenter("3"),1);
        Virologist v2 = new Virologist("Blue",map.getCenter("5"),2);

        activeVirologist=v1;

    }

    /**
     *  Minden körben ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot,
     *  és ha van, meghívja az +EndGame(): void metódust.
     */
    public boolean CheckEndGame(){
        if (map.findVirologistByNum(1).getGeneticCode().size()==4 || map.findVirologistByNum(2).getGeneticCode().size()==4 || map.findVirologistByNum(1).getDead() || map.findVirologistByNum(2).getDead())
            return true;
        return false;
    }

    public Map getMap()
    {
        return this.map;
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

    /**
     * parancs kezeleseert felelos metodus
     * @param cmd
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws TransformerException
     */
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
                    map.findVirologist(parsed[1]).Touch(map.findVirologist(parsed[2]), null);
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
                    map.findVirologist(parsed[1]).Kill(map.findVirologist(parsed[2]));
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
                    //this.turnable.EndTurn();
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
            }
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
        }
        return false;
    }

    /**
     * aktulis allapot kiirasa
     */
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

    /**
     * XML file letrehozasa a game adatainak elmenteset vegzi
     * @param fileName
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws TransformerException
     */
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

    /**
     *      * XML file beolvasasa a game adatokert
     * @param fileName
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
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

    /**
     * aktualis jatekos kivalsztasa
     * @return
     */
    public Virologist getActiveVirologist() {
        return this.activeVirologist;
    }

    /**
     * aktualis jatekos beallitasa
     * @param v
     */
    public void setActiveVirologist(Virologist v) {
        this.activeVirologist = v;
    }
}
