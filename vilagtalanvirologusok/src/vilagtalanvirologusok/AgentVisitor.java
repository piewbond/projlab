package vilagtalanvirologusok;

public class AgentVisitor implements AgVisitor
{


    @Override
    public boolean visit(ProtectorVaccine pc,Virologist virologist)
    {
         pc.Affect(virologist);
         return true;
    }

    @Override
    public boolean visit(ParalyzeVirus pc, Virologist virologist)
    {
        return true;
    }

    @Override
    public boolean visit(BearVirus pc, Virologist virologist)
    {
        pc.Affect(virologist);
        return false;
    }

    @Override
    public boolean visit(ChoreaVirus pc, Virologist virologist)
    {
        pc.Affect(virologist);
        return false;
    }


}
