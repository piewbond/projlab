package vilagtalanvirologusok;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Kirajzolasert felelos osztaly
 */
public class GameFrame extends JFrame implements PolygonChecker
{
    JFrame frame = new JFrame();
    JPanel menupanel = new JPanel();
    JPanel contentpanel = new JPanel();
    JPanel gamepanel = new JPanel();
    JLabel active = new JLabel();
    CardLayout cl = new CardLayout();
    Game game = new Game();
    JPanel mappanel;
    int playerNumber = 1;
    int endTurnCount = 0;
    // PolygonChecker polygonChecker;

    List<Polygon> mappolygon;
    /**
    A mapot megvalosito jpanel osztaly ami felrajzolja a mapot es a rajta levo virologusokat
     */
    class PolygonsJPanel extends JPanel
    {
        /**
         * kirajzolja a poligonokat es a virologusokat a modellnek megfeleloen
         * @param g
         */
        public void paintComponent( Graphics g )
        {
            super.paintComponent( g ); // call superclass's paintComponent
            for (int i=0;i<mappolygon.size();i++) {
                Center c = new Center(0,0);
                Virologist v1 = new Virologist("v1",c,1);
                Virologist v2 = new Virologist("v2,",c,2);
                c = game.getMap().centers.get(i);
                Street str = new Street(0,0);
                Storage sto = new Storage(0,0);
                Shelter she = new Shelter(0,0);
                Laboratory lab = new Laboratory(0,0);
                if(c.getClass() == sto.getClass())
                {
                    g.setColor(new Color(102, 51, 0));
                }
                if(c.getClass() == she.getClass())
                {
                    g.setColor(Color.magenta);
                }
                if(c.getClass() == lab.getClass())
                {
                    g.setColor(Color.ORANGE);
                }
                if(c.getClass() == str.getClass())
                {
                    g.setColor(Color.gray);
                }

                g.fillPolygon( mappolygon.get(i));
                //virologusok kirajzolasa ha 1 van egy locationon
                if(c.getVirologists().size() == 1)
                {
                    for(int k = 0; k < c.getVirologists().size(); k++)
                    {
                        if(c.getVirologists().get(k).getPlayerNumber() == 1)
                        {
                            v1 = c.getVirologists().get(k);
                            if (game.map.findVirologistByNum(1).getDead())
                            {
                                g.setColor(Color.BLACK);
                            }
                            else {
                                g.setColor(Color.red);
                            }
                            g.fillOval(v1.getLocation().getCordx(),v1.getLocation().getCordy(), 15,15);
                        }

                        else
                        {
                            v2 = c.getVirologists().get(k);

                            if (game.map.findVirologistByNum(2).getDead())
                            {
                                g.setColor(Color.BLACK);
                            }
                            else {
                                g.setColor(Color.blue);
                            }
                            g.fillOval(v2.getLocation().getCordx(),v2.getLocation().getCordy(), 15,15);
                        }
                    }

                }
                //virologusok kirajzolasa ha 2 van egy locationon
                if(c.getVirologists().size() == 2)
                {
                    v1 = c.getVirologists().get(0);
                    v2 = c.getVirologists().get(1);

                    if (game.map.findVirologistByNum(1).getDead())
                    {
                        g.setColor(Color.BLACK);
                    }
                    else {
                        g.setColor(Color.red);
                    }
                    g.fillOval(v1.getLocation().getCordx(),v1.getLocation().getCordy(),15,15);

                    if (game.map.findVirologistByNum(2).getDead())
                    {
                        g.setColor(Color.BLACK);
                    }
                    else {
                        g.setColor(Color.blue);
                    }
                    g.fillOval(v2.getLocation().getCordx(),v2.getLocation().getCordy() + 10,15,15);
                }
            }

            //korvonalak kirajzolasa
            g.setColor(Color.black);
            for (Polygon polygon : mappolygon) g.drawPolygon(polygon);
            repaint();
        }

    }

    /**
     * Konstruktor letrehozza az elemeket es elinditja az inicializalast
     */
    public GameFrame()
    {
        mappolygon = new ArrayList<>();
        game.StartGame();
        readPolygons();
        contentpanel.setLayout(cl);

        createMenu();
        createGame();
        contentpanel.add(menupanel,"menu");
        contentpanel.add(gamepanel,"game");
        cl.show(contentpanel,"menu");
        frame.add(contentpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500,1000));
        frame.setResizable(false);
        frame.setTitle("Vilvir");
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * letrehozza a menu paneljet
     * bekoti a listenereket
     */
    private void createMenu()
    {
        JButton start= new JButton("Start game");
        start.addActionListener(new StartListener());

        JButton load= new JButton("Load game");
        load.addActionListener(new LoadListener());

        // JButton test = new JButton("test");

        JButton exit= new JButton("Exit");
        exit.addActionListener(new ExitListener());
        menupanel.add(start);
        menupanel.add(load);
        menupanel.add(exit);
        // menupanel.add(test);
        /*
        test.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JDialog jd = new JDialog(frame);
                makeDialog("test",jd);
            }
        });

         */
    }

    /**
     * letrehozza a jatek paneljet
     * bekoti a listenereket
     */
    private void createGame()
    {
        JButton craftAgent= new JButton("Craft Agent");
        craftAgent.addActionListener(new CraftAgentListener());

        JButton useAgent= new JButton("Use Agent");
        useAgent.addActionListener(new UseAgentListener());

        JButton kill= new JButton("Kill");
        kill.addActionListener(new KillListener());

        JButton dropEquipment= new JButton("Drop Equipment");
        dropEquipment.addActionListener(new DropEquipmentListener());

        JButton stealEquipment= new JButton("Steal Equipment");
        stealEquipment.addActionListener(new StealEquipmentListener());

        JButton saveGame= new JButton("Save Game");
        saveGame.addActionListener(new SaveListener());

        JButton menu = new JButton("Back to Menu");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(contentpanel, "menu");
            }
        });

        JButton endTurn= new JButton("End turn");
        endTurn.setBackground(Color.red);
        endTurn.setForeground(Color.white);
        endTurn.addActionListener(new EndTurnListener());

        active = new JLabel("Active virologist: " + game.getActiveVirologist().getName());

        JPanel buttonpanel = new JPanel();
        mappanel= new PolygonsJPanel();

        List<JButton> buttons = new ArrayList<JButton>();
        buttons.add(craftAgent);
        buttons.add(useAgent);
        buttons.add(kill);
        buttons.add(dropEquipment);
        buttons.add(stealEquipment);
        buttons.add(saveGame);
        buttons.add(menu);
        buttons.add(endTurn);

        mappanel.setBackground(Color.gray);
        GridLayout gl = new GridLayout(1,2);

        gamepanel.setLayout(gl);
        gamepanel.add(mappanel);
        gamepanel.add(buttonpanel);
        gamepanel.addMouseListener(new MapListener());

        buttonpanel.setLayout(new BoxLayout(buttonpanel,BoxLayout.Y_AXIS));
        for (JButton button : buttons)
        {
            buttonpanel.add(button);
            buttonpanel.add(Box.createRigidArea(new Dimension(0, 80)));
        }
        buttonpanel.add(active);


        // endTurn.addActionListener(new EndTurnListener());
    }

    /**
     * letrehoz egy dialog ablakot
     * @param st
     * @param jd
     */
    private void makeDialog(String st,JDialog jd)
    {
        JLabel jLabel = new JLabel(st);
        JButton close = new JButton("close");
        close.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jd.setVisible(false);
            }
        });
        jd.setLayout(new FlowLayout());
        jd.setVisible(true);
        jd.setBounds(400,400,400,400);
        jd.add(close);
        jd.add(jLabel);

    }

    /**
     * A mapon torteno egerkattintasokat figyeli es kattintasra
     * vegrehajtja a mozgatast
     */
    class MapListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            /*
            Point[] poly = polygonToArray(polygon);
            int num = poly.length;

            if (isInside(e.getX(), e.getY(), poly, num)) {
                game.getActiveVirologist().Move(true);
            }
             */
            int mouseX = e.getX();
            int mouseY = e.getY();
            int count = 0;
            for (Polygon polygon : mappolygon) {
                if (polygon.contains(mouseX, mouseY)) {
                    // game.getActiveVirologist().Move(true);
                    game.getActiveVirologist().moveToCenter(game.map.centers.get(count));
                    System.out.println("Virologist moved to " + polygon.toString() + " " +
                            game.getActiveVirologist().getLocation());
                    // mappanel = new PolygonsJPanel();
                }
                count++;
            }
            gamepanel.revalidate();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    /**
     * A CraftAgent gomb megnyomosara vegrehajtja a hatast
     * letrehozza a dialogus ablakkot ahol a jatekos meg tudja adni a valaszat
     * ez alapjan vegrehajtja a modellen a valtoztatsokat
     */
    class CraftAgentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            String msg="";
            List<GeneticCode> gcs= game.getActiveVirologist().getGeneticCode();
            int c = 0;
            for(GeneticCode gc : gcs)
            {
                msg = msg + c+". "+gc.getName();
                c++;
            }
            JLabel p1 = new JLabel(msg);
            JTextField tx = new JTextField(6);
            JButton confirm = new JButton("confirm");
            confirm.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (tx.getText().length() > 0) {
                        int craft = Integer.parseInt(tx.getText());
                        if (craft >= 0 && craft <= gcs.size()) {
                            if (!game.getActiveVirologist().CraftAgent(gcs.get(craft))) {
                                p1.setText("Not enough material");
                            } else {
                                game.getActiveVirologist().CraftAgent(gcs.get(craft));
                                jd.setVisible(false);
                            }
                        }
                    }
                }
            });

            makeDialog("Available Agents:",jd);
            jd.add(p1);
            jd.add(tx);
            jd.add(confirm);
        }
    }

    /**
     * A UseAgent gomb megnyomosara vegrehajtja a hatast
     * letrehozza a dialogus ablakkot ahol a jatekos meg tudja adni a valaszat
     * ez alapjan vegrehajtja a modellen a valtoztatsokat
     */
    class UseAgentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JDialog jd = new JDialog(frame);
            String msg="";
            List<Agent> agents= game.getActiveVirologist().getKnownAgents();
            List<Virologist> virologists = game.getActiveVirologist().getLocation().getVirologists();
            String msgVirologists="Available targets:";
            int c=0;
            for(Agent agent : agents)
            {
                msg = msg + c+". "+agent.getName();
                c++;
            }
            int c2=1;
            for (Virologist v :virologists)
            {
                msgVirologists=msgVirologists+ c2 +". "+v.getName();
                c2++;
            }
            JLabel p1 = new JLabel(msg);
            JLabel p2 = new JLabel(msgVirologists);
            String agentstr = "Agent: ";
            String targetstr = "Target: ";
            JTextField tx1 = new JTextField(agentstr,6);
            JTextField tx2 = new JTextField(targetstr,6);
            JButton confirm = new JButton("confirm");
            confirm.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String agent = tx1.getText();
                    String target = tx2.getText();

                    String[] parsedAgent = agent.split(" ");
                    String[] parsedTarget = target.split(" ");

                    if (parsedAgent.length > 1 && parsedTarget.length > 1) {
                        int agentnb = Integer.parseInt(parsedAgent[1]);
                        int virnb = Integer.parseInt(parsedTarget[1]);
                        if (agentnb >= 0 && agentnb < agents.size() && virnb >= 0 && virnb < 3) {
                            ProtectorVaccine pv = new ProtectorVaccine();
                            if (agents.get(agentnb).getClass() == pv.getClass()) {
                                game.getActiveVirologist().ApplyAgent(agents.get(agentnb));
                            }
                                else{
                                game.getActiveVirologist().Touch(game.map.findVirologist(virologists.get(virnb).getName()), agents.get(agentnb));
                            }
                            jd.setVisible(false);
                        }
                    }
                }
            });

            makeDialog("Crafted Agents:",jd);
            jd.add(p1);
            jd.add(p2);
            jd.add(tx1);
            jd.add(tx2);
            jd.add(confirm);

        }
    }

    /**
     * A Kill gomb megnyomosara vegrehajtja a hatast
     * letrehozza a dialogus ablakkot ahol a jatekos meg tudja adni a valaszat
     * ez alapjan vegrehajtja a modellen a valtoztatsokat    */
    class KillListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            List<Virologist> virologists = game.getActiveVirologist().getLocation().getVirologists();
            String msg="Targets: ";
            int c=1;

            JTextField tx2 = new JTextField("Target number: ",12);
            JButton confirm = new JButton("confirm");
            confirm.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String[] parsed = tx2.getText().split(" ");

                    // 3 meretu lesz a parsed a prompt szokoze miatt
                    if (parsed.length > 2) {
                        int virnb = Integer.parseInt(parsed[2]);
                        if (virnb > 0 && virnb <= 2) {
                            game.getActiveVirologist().Kill(virologists.get(virnb - 1));
                            jd.setVisible(false);
                        }
                    }
                }
            });

            for (Virologist v: virologists)
            {
                msg = msg +c +". "+v.getName()+"  ";
                c++;
            }
            makeDialog("StealEquipment",jd);
            JLabel label = new JLabel(msg);
            jd.add(tx2);
            jd.add(label);
            jd.add(confirm);


        }
    }

    /**
     * A DropEquipment gomb megnyomosara vegrehajtja a hatast
     * letrehozza a dialogus ablakkot ahol a jatekos meg tudja adni a valaszat
     * ez alapjan vegrehajtja a modellen a valtoztatsokat   */
    class DropEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            List<Equipment> equipmentList = game.getActiveVirologist().getEquipments();
            String msg="Equipments: ";
            int c=1;

            JTextField tx2 = new JTextField("Equipment number: ",15);
            JButton confirm = new JButton("confirm");
            confirm.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String[] parsed = tx2.getText().split(" ");

                    if (parsed.length > 2) {
                        int eqnmb = Integer.parseInt(parsed[2]);
                        if (eqnmb > 0 && eqnmb <= equipmentList.size()) {
                            game.getActiveVirologist().DropEquipment(equipmentList.get(eqnmb - 1));
                            jd.setVisible(false);
                        }
                    }
                }
            });

            for (Equipment eq: equipmentList)
            {
                msg = msg +c +". "+eq.getName()+", durability:"+eq.getDurability()+" ";
                c++;
            }
            makeDialog("DropEquipment",jd);
            JLabel label = new JLabel(msg);
            jd.add(tx2);
            jd.add(label);
            jd.add(confirm);


        }
    }

    /**
     * A StealEquipment gomb megnyomosara vegrehajtja a hatast
     * letrehozza a dialogus ablakkot ahol a jatekos meg tudja adni a valaszat
     * ez alapjan vegrehajtja a modellen a valtoztatsokat  */
    class StealEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            List<Virologist> virologists = game.getActiveVirologist().getLocation().getVirologists();
            String msg="Targets: ";
            int c=0; // TODO c-t nem 0-rol kell inditani?

            JTextField tx2 = new JTextField("Target number: ",12);
            JButton confirm = new JButton("confirm");
            confirm.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String[] parsed = tx2.getText().split(" ");

                    if (parsed.length > 2) {
                        int virnb = Integer.parseInt(parsed[2]);
                        if (virnb >= 0 && virnb < 2) {
                            game.getActiveVirologist().StealEquipment(game.map.findVirologist(virologists.get(virnb).getName()));
                            jd.setVisible(false);
                        }
                    }
                }
            });

            for (Virologist v: virologists)
            {
                msg = msg +c +". "+v.getName()+"  ";
                c++;
            }
            makeDialog("StealEquipment",jd);
            JLabel label = new JLabel(msg);
            jd.add(tx2);
            jd.add(label);
            jd.add(confirm);


        }
    }

    /**
     * A SaveListener gomb megnyomosara vegrehajtja a hatast
     * elmenti a jatek allasat */
    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                game.writeXML("game.xml");
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            } catch (TransformerException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * A EndTurn gomb megnyomosara vegrehajtja a hatast
     * elinditja az uj kort valamint atadja a masik jatekosnak az iranyitast */
    class EndTurnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // cl.show(contentpanel,"menu");

            // game.setActiveVirologist(game.map.findVirologistByNum(playerNumber));

            if (playerNumber == 1)
            {
                playerNumber = 2;
            }
            else { playerNumber = 1; }
            game.setActiveVirologist(game.map.findVirologistByNum(playerNumber));

            if (endTurnCount % 2 == 0) {
                game.map.findVirologistByNum(1).setMoved(false);
                game.map.findVirologistByNum(2).setMoved(false);
                game.map.findVirologistByNum(1).Step();
                game.map.findVirologistByNum(2).Step();
            }
            endTurnCount++;
            active.setText("Active virologist: " + game.getActiveVirologist().getName());
            if (game.CheckEndGame()){
                JOptionPane.showMessageDialog(frame,
                        "GAME OVER");
                System.exit(0);
            }
            gamepanel.revalidate();
        }
    }
    /**
     * A Exit gomb megnyomosara vegrehajtja a hatast
     * */
    static class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    /**
     * A Start gomb megnyomosara vegrehajtja a hatast
     * Elinditja a jatekot*/
    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(contentpanel,"game");
            game.StartGame();
        }
    }
    /**
     * A Load gomb megnyomosara vegrehajtja a hatast
     * betolti a jatekot a korabbi allasbol*/
    class LoadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                game.readXML("game.xml");
                cl.show(contentpanel,"game");
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Beolvassa a polignokat es eltarolja a mappolygon-ban
     */
    public void readPolygons(){
        try{

            File file = new File("mappolygon.txt");

            Scanner scanner = new Scanner(file);
            String line;
            String points[];
            Polygon temp;
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                points = line.split(" ");
                temp = new Polygon();
                for (int i=0; i < points.length ; i+=2)
                    temp.addPoint(Integer.parseInt(points[i]),Integer.parseInt(points[i+1]));
                temp.addPoint(Integer.parseInt(points[0]),Integer.parseInt(points[1]));
                mappolygon.add(temp);
                Arrays.fill(points,null);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        //
    }
}
