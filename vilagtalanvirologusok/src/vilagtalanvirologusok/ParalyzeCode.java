package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az egyik genetikai kód osztálya.
 * Az paralzye ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class ParalyzeCode extends GeneticCode implements Serializable {
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel
     * @param  - A készitő virológus.
     */

    public ParalyzeCode()
    {
        name = "ParalyzeCode";
        nucleotideCost=3;
        aminoAcidCost=3;
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
            ParalyzeVirus virus = new ParalyzeVirus();
            // applyagent helyett az a fgv legyen meghívva amelyik a tanultakba rakja bele
            v.learnAgent(virus);
            return true;
        }
        else
        {
            return false;
        }
    }
}
