package vilagtalanvirologusok;

/**
 * A játékban szereplő kesztyűt valósítja meg, ha egy kesztyűvel rendelkező virológusra kennek rá egy ágenst akkor,
 * az ágenst visszakeni a másik virológusra.
 */
public class Glove extends Equipment{
    /**
     * Amennyiben a virológuson van kesztyű, akkor az ágenst visszakeni a másik virológusra, akitől a virus származik.
     * @param v - Virológus, aki
     * @param a - Ágens, amit visszaken.
     */
    public void CastBack(Virologist v, Agent a){
        System.out.println("Glove: CastBack()");
    }
}
