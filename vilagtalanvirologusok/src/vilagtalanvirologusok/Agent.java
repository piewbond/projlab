package vilagtalanvirologusok;
//VÁLTOZTATÁS
/**
 * Az ágensek megvalósításáért felelős absztrakt ősosztály, ebből származnak le a különböző ágens típusok.
 */
public class Agent implements Steppable, AgentVisitable{

    protected int lifetime;
    protected String name;
    private boolean random;
    /**
     * Csökkenti az adott ágens élettartamát.
     * Megvalósítja a Steppable interfészt.
     */
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

    /**
     * visszaadja az agens adatait stringben
     * @return agens adatai stringben
     */
    public String toString() {
        return  "Type: " + this.getClass().getName() +
                ", Lifetime: " + this.getLifetime();
    }
    public void setRandom(boolean r){
        random = r;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptProtector(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptParalyze(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptBear(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptChorea(AgVisitor agVisitor, Virologist virologist)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptAmnesia(AgVisitor agVisitor,Virologist virologist)
    {
        return false;
    }
}
