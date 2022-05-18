package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * A játékban szereplő kesztyűt valósítja meg, ha egy kesztyűvel rendelkező virológusra kennek rá egy ágenst akkor,
 * az ágenst visszakeni a másik virológusra.
 */
public class Glove extends Equipment implements Visitable, Serializable {
    /**
     * Amennyiben a virológuson van kesztyű, akkor az ágenst visszakeni a másik virológusra, akitől a virus származik.
     *  - Virológus, aki
     *   - Ágens, amit visszaken.
     */

    Glove()
    {
        name = "Glove";
        durability=3;
    }

    /**
     * A visszakenest megvalosito metodus
     * @param v
     * @param a
     */
    public void CastBack(Virologist v, Agent a)
    {
        if (durability>0)
        {
            v.ApplyAgent(a);
            DecreaseDurability();
        }
    }
    /**
     * A visitor minta megvalositashoz szukseges seged metodus
     */
    @Override
    public boolean accept(EqVisitor visitor, Material m)
    {
        return false;
    }


    /**
     * A visitor minta megvalositashoz szukseges seged metodus
     */
    @Override
    public boolean accept(EqVisitor visitor, Virologist v, Agent a)
    {
        visitor.visit(this,v,a);
        return true;
    }
    /**
     * A visitor minta megvalositashoz szukseges seged metodus
     */
    @Override
    public void accept(EqVisitor visitor, Virologist v) {

    }
}
