package vilagtalanvirologusok;
/**
 * A visitor minta megvalositashoz szukseges segedosztaly
 */
public class AgentVisitor implements AgVisitor
{
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean visit(ProtectorVaccine pc,Virologist virologist)
    {
         pc.Affect(virologist);
         return true;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean visit(ParalyzeVirus pc, Virologist virologist)
    {
        return true;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean visit(BearVirus pc, Virologist virologist)
    {
        pc.Affect(virologist);
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean visit(ChoreaVirus pc, Virologist virologist)
    {
        pc.Affect(virologist);
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean visit(AmnesiaVirus pc, Virologist virologist)
    {
         pc.Affect(virologist);
         return false;
    }


}
