package vilagtalanvirologusok;

/**
 * Az egyik genetikai kód osztálya.
 * Az amnézia ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class AmnesiaCode extends GeneticCode{
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel,
     * visszatér az ágenssel.
     * @param v - A készitő virológus
     * @return
     */
    public Agent Create(Virologist v){
        System.out.println("AmnesiaCode: Create()");
        return new Agent();
    }
}
