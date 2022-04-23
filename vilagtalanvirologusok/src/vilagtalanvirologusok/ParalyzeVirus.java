package vilagtalanvirologusok;

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
        v.setActiveAgents(this);
        v.getTurnable().EndTurn();
        System.out.println("ParalyzeVirus: Affect()");
    }
}
