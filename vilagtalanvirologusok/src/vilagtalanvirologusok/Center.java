package vilagtalanvirologusok;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Tárolja a rajta lévő virológusokat, illetve a pályán betöltött pozícióját. Az adatstruktúra alapja.
 * A pálya (felépülő gráf) struktúrájában a csúcsokat reprezentálja, ezeken tudnak a virológusok lépkedni.
 */
public class Center implements Serializable {

    private String name; // koordinatabol
    private int cordx;
    private int cordy;
    private boolean random;
    List<Center> neighbours;
    List<Virologist> virologists;


    public Center(int x, int y) {
        cordx = x;
        cordy = y;
        virologists = new ArrayList<Virologist>();
        neighbours = new ArrayList<Center>();
        name = cordx + "_" + cordy;
    }

    /**
     * Új virológust ad hozzá a helyhez.
     *
     * @param v - Az új virológus.
     */
    public void AddVirologist(Virologist v) {
        //System.out.println("Center: AddVirologist()");
        virologists.add(v);
        //v.setLocation(this);
    }

    /**
     * Eltávolít egy virológust a helyről.
     *
     * @param v - Eltávolítandó virológus.
     */
    public void RemoveVirologist(Virologist v) {
        //System.out.println("Center: RemoveVirologist()");
        virologists.remove(v);
    }

    /**
     * @return szomszedos mezok listaja
     */
    public List<Center> GetNeighbours() {
        // System.out.println("Center: GetNeighbours()");
        return neighbours;
    }

    public List<Virologist> getVirologists()
    {
        return this.virologists;
    }

    public String getName() {
        return name;
    }

    /**
     * stringbe irja az objektum informacioit
     * @param virologists
     * @param entities
     * @return
     */
    public String toString(String virologists, String entities) {
        return this.getName() +
                "\n\tType: " + this.getClass().getName() +
                "\n\tConnections: " + this.GetNeighbours().toString() +
                "\n\tVirologists: " + virologists +
                "\n\tEntities: " + entities + "\n\n";
    }
    public void setRandom(boolean r){
        random = r;
    }

    public int getCordx(){
        return cordx;
    }

    public int getCordy(){
        return cordy;
    }
}
