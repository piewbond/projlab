package vilagtalanvirologusok;

/**
 * A játékban szereplő kesztyűt valósítja meg, ha egy kesztyűvel rendelkező virológusra kennek rá egy ágenst akkor,
 * az ágenst visszakeni a másik virológusra.
 */
public class Glove extends Equipment implements Visitable{
    /**
     * Amennyiben a virológuson van kesztyű, akkor az ágenst visszakeni a másik virológusra, akitől a virus származik.
     *  - Virológus, aki
     *   - Ágens, amit visszaken.
     */

    Glove()
    {
        durability=3;
    }
    public void CastBack(Virologist v, Agent a)
    {
        if (durability>0)
        {
            v.ApplyAgent(a);
            DecreaseDurability();
        }
    }

    @Override
    public boolean accept(EqVisitor visitor, Material m)
    {
        return false;
    }



    @Override
    public boolean accept(EqVisitor visitor, Virologist v, Agent a)
    {
        visitor.visit(this,v,a);
        return true;
    }

    @Override
    public void accept(EqVisitor visitor, Virologist v) {

    }
}
