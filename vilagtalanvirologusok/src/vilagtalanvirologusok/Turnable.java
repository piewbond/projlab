package vilagtalanvirologusok;

/**
 * A játékban a körök kezelését végzi. Minden kör végét a játékos kezeli.
 */
public class Turnable {

    /**
     * Felügyeli, hogy a játékos befejezte-e a kört és meghívja a Step() metódust.
     */
    public void EndTurn(){
        System.out.println("Turnable: EndTurn()");
    }

    /**
     * A léptetendő objektumok listájához ad újat.
     * @param s - Léptethető osztály.
     */
    public void AddSteppable(Steppable s){
        System.out.println("Turnable: AddSteppable()");
    }

    /**
     *  Eltávolít egy léptetendő objektumot a listából.
     * @param s - Léptethető osztály.
     */
    public void RemoveSteppable(Steppable s){
        System.out.println("Turnable: RemoveSteppable()");
    }

    /**
     * Minden léptethető objektumot léptet.
     */
    public void StepAllSteppable(){
        System.out.println("Turnable: StepAllSteppable()");
    }

    public Turnable getTurnable()
    {
        return this;
    }
}
