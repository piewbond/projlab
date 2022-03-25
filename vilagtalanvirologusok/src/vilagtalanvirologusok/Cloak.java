package vilagtalanvirologusok;

/**
 * A játékban szereplő köpenyt valósítja meg, ha a virológus rendelkezik ezzel,
 * akkor 82,3% eséllyel  kivédi a rákent ágenst. Ezt a hatást 3 szor tudja produkálni, ami után megsemmisül.
 */
public class Cloak extends Equipment{
    /**
     * Kiszámolja, majd visszaadja, hogy a játékos kivédte-e az ellenfele támadását a 82,3%-os faktor alapján.
     * Amennyiben kivédte csökkenti a tartósságát eggyel.
     * @return
     */
    public boolean Resist(){
        System.out.println("Cloak: Resist()");
        if (true)
            return true;
        return false;
    }
}
