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

public class GameFrame implements PolygonChecker
{
    JFrame frame = new JFrame();
    JPanel menupanel = new JPanel();
    JPanel contentpanel = new JPanel();
    JPanel gamepanel = new JPanel();
    CardLayout cl = new CardLayout();
    Game game = new Game();
    // PolygonChecker polygonChecker;

    List<Polygon> mappolygon;

    class PolygonsJPanel extends JPanel
    {
        // draw polygons and polylines
        public void paintComponent( Graphics g )
        {
            Map temp = game.getMap();
            temp.GenerateGraph();
            super.paintComponent( g ); // call superclass's paintComponent
            for (int i=0;i<mappolygon.size();i++) {
                Center c = new Center(0,0);
                c = temp.centers.get(i);
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
            }

            g.setColor(Color.black);
            for (int i=0;i<mappolygon.size();i++)
                g.drawPolygon( mappolygon.get(i));
        }
    }

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

    private void createMenu()
    {
        JButton start= new JButton("Start game");
        start.addActionListener(new StartListener());

        JButton load= new JButton("Load game");
        load.addActionListener(new LoadListener());

        JButton test = new JButton("test");

        JButton exit= new JButton("Exit");
        exit.addActionListener(new ExitListener());
        menupanel.add(start);
        menupanel.add(load);
        menupanel.add(exit);
        menupanel.add(test);
        test.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JDialog jd = new JDialog(frame);
                makeDialog("test",jd);
            }
        });
    }

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

        JButton endTurn= new JButton("End turn");
        endTurn.addActionListener(new EndTurnListener());

        JPanel buttonpanel = new JPanel();
        JPanel mappanel= new PolygonsJPanel();

        List<JButton> buttons = new ArrayList<JButton>();
        buttons.add(craftAgent);
        buttons.add(useAgent);
        buttons.add(kill);
        buttons.add(dropEquipment);
        buttons.add(stealEquipment);
        buttons.add(saveGame);
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


        endTurn.addActionListener(new EndTurnListener());
    }

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

    public void drawRectangle(Game game,Graphics g){
        Map map = game.getMap();
        List<Center> tmp = map.getCenters();
        for(int i = 0; i< map.centers.size();i++)
        {
            if(tmp.get(i).getName().equals("Street"))
            {
               // g.draw();
            }
        }
    }


    // TODO MapListener (mouselistener?)
    class MapListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            /*
            Point[] poly = polygonToArray(polygon);
            int num = poly.length;

            if (isInside(e.getX(), e.getY(), poly, num)) {
                game.getActiveVirologist().Move(true);
                // TODO virologus mozgatasa a klikkelt helyre
            }
             */
            int mouseX = e.getX();
            int mouseY = e.getY();
            for (Polygon polygon : mappolygon) {
                if (polygon.contains(mouseX, mouseY)) {
                    game.getActiveVirologist().Move(true);
                    System.out.println("Virologist moved to " + polygon.toString());
                }
            }
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


    class CraftAgentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            String msg="";
            List<GeneticCode> gcs= game.getActiveVirologist().getGeneticCode();
            int c=1;
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
                        if (craft > 0 && craft <= gcs.size()) {
                            if (!game.getActiveVirologist().CraftAgent(gcs.get(craft - 1))) {
                                p1.setText("Not enough material");
                            } else {
                                jd.setVisible(false);
                            }
                        }
                    }
                }
            });

            makeDialog("Avalible Agents:",jd);
            jd.add(p1);
            jd.add(tx);
            jd.add(confirm);
        }
    }


    class UseAgentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JDialog jd = new JDialog(frame);
            String msg="";
            List<Agent> agents= game.getActiveVirologist().getKnownAgents();
            List<Virologist> virologists = game.getActiveVirologist().getLocation().getVirologists();
            String msgVirologists="Avalible targets:";
            int c=1;
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
                        if (agentnb > 0 && agentnb <= agents.size() && virnb > 0 && virnb < 3) {
                            game.getActiveVirologist().Touch(virologists.get(virnb), agents.get(agentnb));
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
                            game.getActiveVirologist().StealEquipment(virologists.get(virnb - 1));
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


    class StealEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog(frame);
            List<Virologist> virologists = game.getActiveVirologist().getLocation().getVirologists();
            String msg="Targets: ";
            int c=1; // TODO c-t nem 0-rol kell inditani?

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
                        if (virnb > 0 && virnb <= 2) {
                            game.getActiveVirologist().Kill(virologists.get(virnb));
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


    class EndTurnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(contentpanel,"menu");
            game.turnable.EndTurn();
        }
    }

    static class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(contentpanel,"game");
            game.StartGame();
        }
    }

    class LoadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                game.readXML("game.xml");
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void readPolygons(){
        try{
            /**
             * bekeri a file eleleresi utvonalat majd megprobalja beolvasni
             */
            //File file = new File("G:\\Programozás\\projlab\\projlab\\out\\production\\projlab\\vilagtalanvirologusok\\mappolygon.txt");
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
                    //TODO map ellenorzes
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
    public void rePaint(){



    }
}
