package vilagtalanvirologusok;

/**
 * Ezek az objektumok a laboratóriumok falain jelennek meg. Ezeknek megtanulásához a virológusoknak el kell menniük oda.
 * Minden meglátogatott laboratórium után a virológus kap egy genetikai kódot és egy véletlenül kisorsolt hozzá tartozó,
 * elkészíthető ágenst.
 * Amennyiben egy virológus megszerzett 4 genetikai kódot nyert.
 */
public abstract class GeneticCode {
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel,
     * akkor hozzáadja a virológus tárolójához és igazzal tér vissza.
     */
    protected int nucleotideCost;
    protected int aminoAcidCost;


    public abstract void Create(Virologist virologist);








}
