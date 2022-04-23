package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * Azt a vírust valósítja meg amelyet felkenve egy virológusra, az 3körig lebénul,
 * ez idő alatt nem tud semmilyen cselekvést folytatni és el lehet tőle venni felszereléseket.
 */
public class ParalyzeVirus extends Agent{
    /**
     * Az osztály az őséhez tartozó virtuális függvényt tartalmazza:
     * A virológus lebénul, nem képes mozogni a pályán, amíg a hatása tart.
     * @param v - Virologus, akin kifejti a hatást.
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
        v.getTurnable().EndTurn();
        v.setActiveAgents(this);
        System.out.println("ParalyzeVirus: Affect()");
    }
}
