package vilagtalanvirologusok;

/**
 * A jatekban fellelheto egyik eszkoz
 *  Egyszer hasznalhato utana tonkremegy
 *  segitsegevel megolhetunk egy jatekost
 */
public class Axe extends Equipment implements Visitable
{


    Axe()
    {
        name ="Axe";
        durability=1;
    }

    /**
     * A jatekos megoleset vegrehajto metodus
     * @param v
     */
    public void UseAxe(Virologist v)
    {
        if(durability==0)
        {
            return;
        }

        v.Die();
        DecreaseDurability();
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    public boolean accept(EqVisitor visitor, Material m)
    {
        return false;
    }


    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean accept(EqVisitor visitor, Virologist v, Agent a)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public void accept(EqVisitor visitor,Virologist virologist)
    {
        visitor.visit(this,virologist);
    }

}
