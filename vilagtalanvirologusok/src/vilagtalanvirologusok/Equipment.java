package vilagtalanvirologusok;

/**
 * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
 */
public abstract class Equipment implements Visitable{
    /**
     * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
     */

    protected int durability;
    public int getDurability()
    {
        return durability;
    }
    public void DecreaseDurability(){
        durability--;
    }


    public abstract boolean accept(Visitor visitor, Material m);



    public abstract boolean accept(Visitor visitor, Virologist v, Agent a);

}
