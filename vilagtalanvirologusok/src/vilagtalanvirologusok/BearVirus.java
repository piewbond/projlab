package vilagtalanvirologusok;

import java.util.ArrayList;

public class BearVirus extends Agent{

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
        System.out.println("BearVirus: Affect()");
    }

}
