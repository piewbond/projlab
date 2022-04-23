package vilagtalanvirologusok;

import java.util.HashSet;
import java.util.Set;

/**
 * Azt a vírust valósítja meg amelyet felkenve másra, az elszenvedő elfelejti az összes addig megtanult genetikai kódját.
 */
public class AmnesiaVirus extends Agent{
    /**
     * Az osztály az őséhez tartozó virtuális függvényt tartalmazza: A hatása alatt lévő virológus elveszti az eddig
     * megszerzett (megtanult) genetikai kódokat.
     * @param v - Virologus, akin kifejti a hatast
     */
    @Override
    public void Affect(Virologist v)
    {
        v.getGeneticCode().clear();
        v.setActiveAgents(this);
        System.out.println("AmnesiaVirus: Affect()");
    }
}
