package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
 */
public abstract class Equipment implements Visitable, Serializable {
    /**
     * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
     */
    private boolean random;
    protected String name;
    protected int durability;
    public int getDurability()
    {
        return durability;
    }
    public void DecreaseDurability(){
        durability--;
    }


    public abstract boolean accept(EqVisitor visitor, Material m);


    public abstract void accept(EqVisitor visitor,Virologist virologist);

    public abstract boolean accept(EqVisitor visitor, Virologist v, Agent a);

    public String getName() { return name; }
    /**
     * stringbe irja az objektum informacioit
     * @param virologists
     * @param entities
     * @return
     */
    public String toString() {
        return  "Type: " + this.getClass().getName() +
                ", Durability: " + this.getDurability();
    }
    public void setRandom(boolean r){
        random = r;
    }
}
