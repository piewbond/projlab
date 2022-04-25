package vilagtalanvirologusok;
//VÁLTOZTATÁS
/**
 * Az ágensek megvalósításáért felelős absztrakt ősosztály, ebből származnak le a különböző ágens típusok.
 */
public class Agent implements Steppable, AgentVisitable{
    /**
     * Csökkenti az adott ágens élettartamát.
     * Megvalósítja a Steppable interfészt.
     */
    private int lifetime;
    private String name;
    private boolean random;
    public void Step()
    {
        lifetime--;
    }

    /**\
     * Az ágensek hatását fejti ki a virológuson.
     * @param v - Virológus, akin kifejti a hatást
     */
    public void Affect(Virologist v){}


    public int getLifetime()
    {
        return lifetime;
    }
    public String getName() { return name; }

    public String toString() {
        return  "Type: " + this.getClass().getName() +
                ", Lifetime: " + this.getLifetime();
    }
    public void setRandom(boolean r){
        random = r;
    }

    @Override
    public boolean acceptProtector(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
    @Override
    public boolean acceptParalyze(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }

    @Override
    public boolean acceptBear(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }

    @Override
    public boolean acceptChorea(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
}
