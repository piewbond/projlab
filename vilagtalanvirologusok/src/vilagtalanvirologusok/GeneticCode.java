package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * Ezek az objektumok a laboratóriumok falain jelennek meg. Ezeknek megtanulásához a virológusoknak el kell menniük oda.
 * Minden meglátogatott laboratórium után a virológus kap egy genetikai kódot és egy véletlenül kisorsolt hozzá tartozó,
 * elkészíthető ágenst.
 * Amennyiben egy virológus megszerzett 4 genetikai kódot nyert.
 */
public abstract class GeneticCode implements Serializable {
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel,
     * akkor hozzáadja a virológus tárolójához és igazzal tér vissza.
     */
    protected String name;
    protected int nucleotideCost;
    protected int aminoAcidCost;


    public abstract boolean Create(Virologist virologist);


    public String getName() { return name; }

    public String toString() {
        return this.getName() +
                "\n\tType: " + this.getClass().getName() +
                "\n\tLocation: " /* + this.getLocation() */ + "\n\n";
    }



}
