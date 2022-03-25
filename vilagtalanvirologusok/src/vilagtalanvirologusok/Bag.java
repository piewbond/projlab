package vilagtalanvirologusok;

/**
 * A játékban szereplő hátizsákot valósítja meg.
 * Amíg a virológus rendelkezik ezzel, ez megnöveli annak anyagi kapacitását 10 egységgel. Az anyag tárolását végzi.
 */
public class Bag extends Equipment{
    /**
     * Hozzáad a hátizsákhoz adott anyagot.
     * @param m - Hozááadott anyga.
     * @return
     */
    public boolean AddMaterial(Material m){
        System.out.println("Bag: AddMaterial()");
        if (true)
            return true;
        return false;
    }

    /**
     * Töröl a hátizsákból adott anyagot.
     * @param m - Törlendő anyag.
     */
    public void RemoveMaterial(Material m){
        System.out.println("Bag: RemoveMaterial()");
    }
}
