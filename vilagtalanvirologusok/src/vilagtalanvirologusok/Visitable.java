package vilagtalanvirologusok;

import java.util.ArrayList;

public interface Visitable
{
    public boolean accept(EqVisitor visitor, Material m);
    public boolean accept(EqVisitor visitor, Virologist v, Agent a);
    public void accept(EqVisitor visitor, Virologist v);
}
