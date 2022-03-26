package vilagtalanvirologusok;

/**
 * Az egyik genetikai kód osztálya.
 * Az paralzye ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class ParalyzeCode extends GeneticCode{
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel
     * @param v - A készitő virológus.
     */
    public void Create(Virologist v){
        System.out.println("Amnesia: Create()");
    }
}
