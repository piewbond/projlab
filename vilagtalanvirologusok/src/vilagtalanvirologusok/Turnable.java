package vilagtalanvirologusok;

import java.util.ArrayList;
import java.util.List;

/**
 * A játékban a körök kezelését végzi. Minden kör végét a játékos kezeli.
 */
public class Turnable {
    List<Steppable> steppables;
    /**
     * Felügyeli, hogy a játékos befejezte-e a kört és meghívja a Step() metódust.
     */
    public Turnable(){
        steppables = new ArrayList<Steppable>();
    }
    public void EndTurn(){
        //System.out.println("Turnable: EndTurn()");
        StepAllSteppable();

    }

    /**
     * A léptetendő objektumok listájához ad újat.
     * @param s - Léptethető osztály.
     */
    public void AddSteppable(Steppable s){
        //System.out.println("Turnable: AddSteppable()");
        steppables.add(s);
    }

    /**
     *  Eltávolít egy léptetendő objektumot a listából.
     * @param s - Léptethető osztály.
     */
    public void RemoveSteppable(Steppable s){
        //System.out.println("Turnable: RemoveSteppable()");
        steppables.remove(s);
    }

    /**
     * Minden léptethető objektumot léptet.
     */
    public void StepAllSteppable(){
        //System.out.println("Turnable: StepAllSteppable()");
        for (Steppable s: steppables
             ) {
            s.Step();
        }
    }

    public Turnable getTurnable()
    {
        return this;
    }
}
