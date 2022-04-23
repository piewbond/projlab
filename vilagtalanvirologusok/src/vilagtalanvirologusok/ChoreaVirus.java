package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * Azt a vírust valósítja meg amelyet felkenve egy virológusra, az 3 körig elveszti az irányítást a karaktere felett és
 * az véletlenszerű irányba mozog ezalatt az időtartam alatt.
 */
public class ChoreaVirus extends Agent{
    /**
     * Az osztály az őséhez tartozó virtuális függvényt tartalmazza:
     * A virológus véletlenszerűen kezd el mozogni a pályán, kezelhetetlenné válik, amíg a hatása tart.
     * @param v - Virologus, akin kifejti a hatast
     */
    @Override
    public void Affect(Virologist v)
    {
        ArrayList<Agent> tmp = new ArrayList<Agent>();
        tmp = v.getActiveAgents();
        for(Agent a : tmp)
        {
            if(a.getName() == "ProtectorVaccine")
            {
                return;
            }
        }
        //TODO
        v.setActiveAgents(this);
        System.out.println("ChoreaVirus: Affect()");
    }
}
