package vilagtalanvirologusok;

import java.util.ArrayList;
/**
 * A visitor minta megvalositashoz szukseges segedosztaly
 */
public class EquipmentVisitor implements EqVisitor
{

    @Override
    public boolean visit(Bag bag, Material m)
    {
        return bag.addMaterial(m);
    }

    @Override
    public void visit(Glove glove, Virologist virologist, Agent a)
    {
        glove.CastBack(virologist,a);
    }

    @Override
    public void visit(Axe axe,Virologist virologist)
    {
        axe.UseAxe(virologist);
    }

    @Override
    public boolean visit(Cloak cloak,Virologist virologist,Agent agent)
    {
        return cloak.Resist();
    }

}
