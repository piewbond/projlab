package vilagtalanvirologusok;

public interface AgVisitor
{

    public boolean visit(ProtectorVaccine pc,Virologist virologist);
    public boolean visit(ParalyzeVirus pc,Virologist virologist);


}