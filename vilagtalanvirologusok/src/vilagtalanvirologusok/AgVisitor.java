package vilagtalanvirologusok;

public interface AgVisitor
{

    public boolean visit(ProtectorVaccine pc,Virologist virologist);
    public boolean visit(ParalyzeVirus pc,Virologist virologist);
    public boolean visit(BearVirus pc,Virologist virologist);
    public boolean visit(ChoreaVirus pc,Virologist virologist);
    public boolean visit(AmnesiaVirus pc,Virologist virologist);


}
