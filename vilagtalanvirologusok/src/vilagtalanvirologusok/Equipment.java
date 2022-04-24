package vilagtalanvirologusok;

/**
 * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
 */
public abstract class Equipment implements Visitable{
    /**
     * A játékban szereplő felszerelések absztrakt ősosztálya. Ezekből származnak le a különféle felszerelések.
     */
    private boolean random;
    private String name;
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

    public String getName() { return name; }

    public String toString() {
        return this.getName() +
                "\n\tType: " + this.getClass().getName() +
                "\n\tLocation: " + /* this.getLocation() + */
                "\n\tDurability: " + this.getDurability() + "\n\n";
    }
    public void setRandom(boolean r){
        random = r;
    }
}
