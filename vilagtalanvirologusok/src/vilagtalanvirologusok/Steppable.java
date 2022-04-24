package vilagtalanvirologusok;

/**
 * A játékban szereplő léptethető(időben) osztályokhoz tartozó interface.
 */
public interface Steppable {
    /**
     *  Lépteti a meghívott osztályt.
     */
    public default void Step(){
        //System.out.println("Steppable: Step()");
    }
}
