package vilagtalanvirologusok;

import java.util.ArrayList;

/**
 * Az egyik genetikai kód osztálya.
 * Az amnézia ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class AmnesiaCode extends GeneticCode{
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel,
     *  - A készitő virológus
     */

    public AmnesiaCode()
    {
        name ="AmnesiaCode" ;
        nucleotideCost=5;
        aminoAcidCost=5;
    }
    public boolean Create(Virologist v){

        ArrayList<Material> costs = new ArrayList<Material>();
        for (int i=0;i<5;i++)
        {
            Nucleotide n = new Nucleotide();
            costs.add(n);
        }
        for (int i=0;i<5;i++)
        {
            Aminoacid n = new Aminoacid();
            costs.add(n);
        }
        if(v.UseMaterial(costs))
        {
            AmnesiaVirus virus = new AmnesiaVirus();
            // applyagent helyett az a fgv legyen meghívva amelyik a tanultakba rakja bele
            v.learnAgent(virus);
            return  true;
        }
        else
        {
            return false;
        }
    }
}
