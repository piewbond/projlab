package vilagtalanvirologusok;

public class ChoreaCode extends GeneticCode{
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel, visszatér az ágenssel
     * @param v - A készitő virológus
     * @return
     */
    public Agent Create(Virologist v){
        System.out.println("Amnesia: Create");
        return new Agent();
    }
}
