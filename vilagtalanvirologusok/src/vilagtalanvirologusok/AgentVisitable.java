package vilagtalanvirologusok;

/**
 * A visitor minta megvalositashoz szukseges segedinterface
 */
public interface AgentVisitable
{
    public boolean acceptProtector(AgVisitor agVisitor,Virologist virologist);
    public boolean acceptParalyze(AgVisitor agVisitor,Virologist virologist);
    public boolean acceptBear(AgVisitor agVisitor,Virologist virologist);
    public boolean acceptChorea(AgVisitor agVisitor,Virologist virologist);
    public boolean acceptAmnesia(AgVisitor agVisitor,Virologist virologist);



}
