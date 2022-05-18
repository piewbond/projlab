package vilagtalanvirologusok;

/**
 * A visitor minta megvalositashoz szukseges segedinterface
 */
public interface EqVisitor
{

    public boolean visit(Bag bag,Material m);
    public void visit(Glove glove, Virologist virologist,Agent a);
    public void visit(Axe axe,Virologist virologist);
    public boolean visit(Cloak cloak,Virologist virologist,Agent a);

}
