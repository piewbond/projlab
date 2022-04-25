package vilagtalanvirologusok;

public interface AgentVisitable
{
    public boolean acceptProtector(AgVisitor agVisitor,Virologist virologist);
    public boolean acceptParalyze(AgVisitor agVisitor,Virologist virologist);


}
