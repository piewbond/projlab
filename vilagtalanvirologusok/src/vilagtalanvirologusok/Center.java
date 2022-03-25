package vilagtalanvirologusok;
import java.util.ArrayList;
import java.util.List;

/**
 * Tárolja a rajta lévő virológusokat, illetve a pályán betöltött pozícióját. Az adatstruktúra alapja.
 * A pálya (felépülő gráf) struktúrájában a csúcsokat reprezentálja, ezeken tudnak a virológusok lépkedni.
 */
public class Center {
    /**
     * Új virológust ad hozzá a helyhez.
     * @param v - Az új virológus.
     */
    public void AddVirologist(Virologist v){
        System.out.println("Center: AddVirologist()");
    }

    /**
     * Eltávolít egy virológust a helyről.
     * @param v - Eltávolítandó virológus.
     */
    public void RemoveVirologist(Virologist v){
        System.out.println("Center: RemoveVirologist()");
    }
    public List<Center> GetNeighbours(){
        System.out.println("Center: GetNeighbours()");
        List<Center> l = new ArrayList<Center>();
        return l;
    }
}
