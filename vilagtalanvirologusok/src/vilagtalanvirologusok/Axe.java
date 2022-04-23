package vilagtalanvirologusok;

public class Axe extends Equipment implements Visitable
{


    Axe()
    {
        durability=3;
    }

    public void UseAxe(Virologist v)
    {
        if(durability==0)
        {
            return;
        }

        v.Die();
        DecreaseDurability();
    }

    public boolean accept(Visitor visitor, Material m)
    {
        return false;
    }

    @Override
    public boolean accept(Visitor visitor, Virologist v, Agent a)
    {
        return false;
    }

    @Override
    public void accept(Visitor visitor,Virologist virologist)
    {
        visitor.visit(this,virologist);
    }

}
