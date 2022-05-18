package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * A játékban szereplő hátizsákot valósítja meg.
 * Amíg a virológus rendelkezik ezzel, ez megnöveli annak anyagi kapacitását 10 egységgel. Az anyag tárolását végzi.
 */
public class Bag extends Equipment implements Visitable{

    private ArrayList<Material> materials = new ArrayList<>();

    /**
     * letrehozza az objektumot es inicilizalja
     */
    Bag()
    {
        durability=3;
        name="Bag";
    }

    /**
     * Hozzaad a taskahoz egy alapanyagot
     * @param m
     * @return
     */
    public boolean addMaterial(Material m)
    {

        if (materials.size()<10)
        {
            materials.add(m);
            return true;
        }
        else
        {
            return false;
        }


    }

    /**
     * visszaadja a materialjait
     * @return
     */
    public ArrayList<Material> getMaterials()
    {
        return materials;
    }

    /**
     * Eltavolit egy alapanyagot a helyrol
     * @param m
     */
    public void removeMaterial(Material m){
        materials.remove(m);
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean accept(EqVisitor visitor,Material m)
    {
        return visitor.visit(this, m);
    }


    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean accept(EqVisitor visitor, Virologist v, Agent a)
    {
        return false;
    }
    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public void accept(EqVisitor visitor ,Virologist v)
    {

    }
}
