package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * Azt a vírust valósítja meg amelyet felkenve egy virológusra, az 3körig lebénul,
 * ez idő alatt nem tud semmilyen cselekvést folytatni és el lehet tőle venni felszereléseket.
 */
public class ParalyzeVirus extends Agent implements Serializable {
    /**
     * Az osztály az őséhez tartozó virtuális függvényt tartalmazza:
     * A virológus lebénul, nem képes mozogni a pályán, amíg a hatása tart.
     * - Virologus, akin kifejti a hatást.
     */

ParalyzeVirus()
{
    name = "ParalyzeVirus";
    lifetime=3;
}



    @Override
    public void Affect(Virologist v)
    {
        v.setMoved(true);

    }
    @Override
    public boolean acceptParalyze(AgVisitor agentVisitor, Virologist v)
    {
        return agentVisitor.visit(this,v);

    }
}
