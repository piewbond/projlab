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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameFrame implements PolygonChecker
{
    JFrame frame = new JFrame();
    JPanel menupanel = new JPanel();
    JPanel contentpanel = new JPanel();
    JPanel gamepanel = new JPanel();
    CardLayout cl = new CardLayout();
    Game game = new Game();
    PolygonChecker polygonChecker;


    public GameFrame()
    {

        contentpanel.setLayout(cl);

        createMenu();
        createGame();
        contentpanel.add(menupanel,"menu");
        contentpanel.add(gamepanel,"game");
        cl.show(contentpanel,"menu");
        frame.add(contentpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,1000));
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

        JButton exit= new JButton("Exit");
        exit.addActionListener(new ExitListener());
        menupanel.add(start);
        menupanel.add(load);
        menupanel.add(exit);
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
        JPanel mappanel= new JPanel();

        List<JButton> buttons = new ArrayList<JButton>();
        buttons.add(craftAgent);
        buttons.add(useAgent);
        buttons.add(kill);
        buttons.add(dropEquipment);
        buttons.add(stealEquipment);
        buttons.add(saveGame);
        buttons.add(endTurn);


        mappanel.setBackground(Color.red);
        GridLayout gl = new GridLayout(1,2);

        gamepanel.setLayout(gl);
        gamepanel.add(mappanel);
        gamepanel.add(buttonpanel);



        buttonpanel.setLayout(new BoxLayout(buttonpanel,BoxLayout.Y_AXIS));
        for (int i=0;i< buttons.size();i++)
        {
            buttonpanel.add(buttons.get(i));
            buttonpanel.add(Box.createRigidArea(new Dimension(0,80)));
        }


        endTurn.addActionListener(new EndTurnListener());
    }

    public void drawRectangle(Game game,Graphics g){
        Map map = game.getMap();
        List<Center> tmp = map.getCenters();
        for(int i = 0; i< map.centers.size();i++)
        {
            if(tmp.get(i).getName().equals("Street"))
            {
                g.draw;
            }
        }
    }


    // TODO MapListener (mouselistener?)
    class MapListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Point[] poly = {new Point(0, 0)};
            int num = poly.length;

            if (isInside(e.getX(), e.getY(), poly, num)) {
                game.getActiveVirologist().Move(true);
                // TODO virologus mozgatasa a klikkelt helyre
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
            game.getActiveVirologist().CraftAgent(null);
            // TODO popup
        }
    }


    class UseAgentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getActiveVirologist().learnAgent(null);
            // TODO popup
        }
    }


    class KillListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getActiveVirologist().Kill(null);
            // TODO popup, kit oljon meg
        }
    }


    class DropEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getActiveVirologist().DropEquipment(null);
            // TODO popup hogy mit dobjon el
        }
    }


    class StealEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Virologist v = game.getActiveVirologist();
            v.StealEquipment(v.getLocation().virologists.get(1));
            // TODO ez most kenyszermegoldas, ide kene a popup?
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

}
