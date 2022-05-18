package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az egyik genetikai kód osztálya. Az védőoltás ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class ProtectorCode extends GeneticCode implements Serializable {
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel
     * @param - A készitő virológus
     */

    public ProtectorCode()
    {
        name = "ProtectorCode";
        nucleotideCost=1;
        aminoAcidCost=1;
    }
    public boolean Create(Virologist v){

        ArrayList<Material> costs = new ArrayList<>();
        for (int i=0;i<nucleotideCost;i++)
        {
            Nucleotide n = new Nucleotide();
            costs.add(n);
        }
        for (int i=0;i<aminoAcidCost;i++)
        {
            Aminoacid n = new Aminoacid();
            costs.add(n);
        }
        if(v.UseMaterial(costs))
        {
            ProtectorVaccine virus = new ProtectorVaccine();
            v.learnAgent(virus);
            return true;
        }
        else
        {
            return false;
        }
    }
}
