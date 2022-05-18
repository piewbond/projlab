package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * Azt a vakcinát valósítja meg amelyet a virológusok maguknak vagy másnak beadva,
 * immunisak lesznek a következő rájuk kent ágensre. A hatás 3 körig érvényes.
 */
public class ProtectorVaccine extends Agent implements Serializable {
    /**
     * A vakcina hatasat fejti ki
     * @param v - Virológus, akin kifejti a hatást
     */
    @Override
    public void Affect(Virologist v)
    {
        if(v.getActiveAgents().contains(this))
        {
            v.getActiveAgents().remove(this);
        }
       // System.out.println("ChoreaVirus: Affect()");
    }

ProtectorVaccine()
{
    name="Protector Vaccine";
    lifetime=3;
}
    /**
     * A visitor minta megvalositashoz szukseges seged metodus
     */
    @Override
    public boolean acceptProtector(AgVisitor agVisitor,Virologist virologist)
    {
        return agVisitor.visit(this,virologist);
    }
}
