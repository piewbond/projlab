package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * Azt a vakcinát valósítja meg amelyet a virológusok maguknak vagy másnak beadva,
 * immunisak lesznek a következő rájuk kent ágensre. A hatás 3 körig érvényes.
 */
public class ProtectorVaccine extends Agent{

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
        v.setActiveAgents(this);
        System.out.println("ChoreaVirus: Affect()");
    }

}
