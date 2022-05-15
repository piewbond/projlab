package vilagtalanvirologusok;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameFrame
{
    JFrame frame = new JFrame();
    JPanel menupanel = new JPanel();
    JPanel contentpanel = new JPanel();
    JPanel gamepanel = new JPanel();
    CardLayout cl = new CardLayout();

    GameFrame()
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
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cl.show(contentpanel,"game");
            }
        });
        JButton load= new JButton("Load game");
        load.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //TODO -load megvalositas
            }
        });


        JButton exit= new JButton("Exit");
        exit.addActionListener(new ExitListener());
        menupanel.add(start);
        menupanel.add(load);
        menupanel.add(exit);
    }

    private void createGame()
    {
        JButton craftAgent= new JButton("Craft Agent");
        JButton useAgent= new JButton("Use Agent");
        JButton kill= new JButton("Kill");
        JButton dropEquipment= new JButton("Drop Equipment");
        JButton stealEquipment= new JButton("Steal Equipment");
        JButton saveGame= new JButton("Save Game");
        JButton endTurn= new JButton("End turn");
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


    class MapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class CraftAgentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class UseAgentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class KillListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class DropEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class StealEquipmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    class EndTurnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cl.show(contentpanel,"menu");
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
