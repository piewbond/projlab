package vilagtalanvirologusok;

public interface Steppable {
    public default void Step(){
        System.out.println("Steppable: Step()");
    }
}
