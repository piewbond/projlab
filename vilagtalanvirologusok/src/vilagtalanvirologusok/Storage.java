package vilagtalanvirologusok;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * A játékban szereplő raktárakat reprezentálja, ezeken a helyszíneken tudnak a virológusok anyagokat gyűjteni.
 */
public class Storage extends Center {

    private List<Material> materials;

    public Storage(int x, int y) {
        super(x, y);
        materials = new ArrayList<Material>();
        SpawnMaterial();
    }

    /**
     * Hozzáad a helyhez adott aminosavat vagy nukleotidot.
     */
    public void SpawnMaterial(){
        //System.out.println("Storage: SpawnMaterial()");
        if (random == true) {
            Random r = new Random();
            if (r.nextInt(2) == 0) {
                materials.add(new Aminoacid());
            } else {
                materials.add(new Nucleotide());
            }
        }else   {
            materials.add(new Aminoacid());
        }
    }

    public void AddVirologist(Virologist v) {
        //System.out.println("Center: AddVirologist()");
        virologists.add(v);
        v.PickupMaterial(materials.get(0));
        RemoveMaterial(materials.get(0));
    }
    /**
     * Kitorol egy kapott anyagot
     * @param m torlendo anyag
     */
    public void RemoveMaterial(Material m){
        //System.out.println("Storage: RemoveMaterial()");
        materials.remove(m);
    }

    public List<Material> getMaterial()
    {
        return this.materials;
    }

}
