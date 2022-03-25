package vilagtalanvirologusok;

/**
 * A játékban szereplő raktárakat reprezentálja, ezeken a helyszíneken tudnak a virológusok anyagokat gyűjteni.
 */
public class Storage extends Center {
    /**
     * Hozzáad a helyhez adott aminosavat vagy nukleotidot.
     */
    public void SpawnMaterial(){
        System.out.println("Storage: SpawnMaterial()");
    }

    /**
     * Töröl a helyről  adott aminosavat vagy nukleotidot.
     * @param m - Törlendő anyag.
     */
    public void RemoveMaterial(Material m){
        System.out.println("Storage: RemoveMaterial()");
    }
}
