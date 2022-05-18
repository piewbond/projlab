package vilagtalanvirologusok;


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
    }

    @Override
    public boolean acceptAmnesia(AgVisitor agVisitor,Virologist virologist)
    {
        return agVisitor.visit(this,virologist);
    }

    AmnesiaVirus()
    {
        name = "AmnesiaVirus";
        lifetime=1;
    }

}
