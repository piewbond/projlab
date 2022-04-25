package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.Random;

/**
 * A játékban szereplő köpenyt valósítja meg, ha a virológus rendelkezik ezzel,
 * akkor 82,3% eséllyel  kivédi a rákent ágenst. Ezt a hatást 3 szor tudja produkálni, ami után megsemmisül.
 */
public class Cloak extends Equipment implements Visitable, Serializable {
    /**
     * Kiszámolja, majd visszaadja, hogy a játékos kivédte-e az ellenfele támadását a 82,3%-os faktor alapján.
     * Amennyiben kivédte csökkenti a tartósságát eggyel.
     * @return
     */
    Cloak()
    {
        durability=3;
    }
    public boolean Resist(){

        if (durability==0)
        {
            return false;
        }
        Random rnd = new Random();
        int n = rnd.nextInt(101);
        if (n<82)
        {
            this.DecreaseDurability();
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public boolean accept(EqVisitor visitor, Material m)
    {
        return false;
    }

    @Override
    public void accept(EqVisitor visitor, Virologist virologist)
    {

    }

    @Override
    public boolean accept(EqVisitor visitor, Virologist v, Agent a)
    {
        return visitor.visit(this,v,a);

    }




}
