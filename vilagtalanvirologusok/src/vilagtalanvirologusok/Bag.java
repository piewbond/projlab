package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * A játékban szereplő hátizsákot valósítja meg.
 * Amíg a virológus rendelkezik ezzel, ez megnöveli annak anyagi kapacitását 10 egységgel. Az anyag tárolását végzi.
 */
public class Bag extends Equipment implements Visitable{

    private ArrayList<Material> materials = new ArrayList<Material>();

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


    public ArrayList<Material> getMaterials()
    {
        return materials;
    }
    public void removeMaterial(Material m){
        materials.remove(m);
    }

    @Override
    public boolean accept(Visitor visitor,Material m)
    {
        return visitor.visit(this, m);
    }

    @Override
    public boolean accept(Visitor visitor, Virologist v, Agent a)
    {
        return false;
    }

    @Override
    public void accept(Visitor visitor ,Virologist v)
    {
        return;
    }
}
