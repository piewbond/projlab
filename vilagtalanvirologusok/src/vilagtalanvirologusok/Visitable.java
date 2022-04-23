package vilagtalanvirologusok;

import java.util.ArrayList;

public interface Visitable
{
    public boolean accept(Visitor visitor, Material m);
    public boolean accept(Visitor visitor, Virologist v, Agent a);
    public void accept(Visitor visitor, Virologist v);
}
