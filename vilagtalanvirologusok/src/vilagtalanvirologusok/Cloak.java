package vilagtalanvirologusok;

import java.util.Random;

/**
 * A játékban szereplő köpenyt valósítja meg, ha a virológus rendelkezik ezzel,
 * akkor 82,3% eséllyel  kivédi a rákent ágenst. Ezt a hatást 3 szor tudja produkálni, ami után megsemmisül.
 */
public class Cloak extends Equipment implements Visitable{
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
    public boolean accept(Visitor visitor, Material m)
    {
        return false;
    }

    @Override
    public boolean accept(Visitor visitor, Virologist v, Agent a)
    {
        return visitor.visit(this,v,a);

    }

    @Override
    public void accept(Visitor visitor, Virologist v) {

    }
}
