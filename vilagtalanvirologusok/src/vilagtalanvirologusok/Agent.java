package vilagtalanvirologusok;
//VÁLTOZTATÁS
/**
 * Az ágensek megvalósításáért felelős absztrakt ősosztály, ebből származnak le a különböző ágens típusok.
 */
public class Agent implements Steppable{
    /**
     * Csökkenti az adott ágens élettartamát.
     * Megvalósítja a Steppable interfészt.
     */
    public void Step(){}

    /**\
     * Az ágensek hatását fejti ki a virológuson.
     * @param v - Virológus, akin kifejti a hatást
     */
    public void Affect(Virologist v){}
}
