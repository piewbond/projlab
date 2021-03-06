package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az egyik genetikai kód osztálya. Az vitustánc ágens létrehozása a felelőssége.
 * A játékos győzelméhez többek közt ennek a megszerzése a célja.
 */
public class ChoreaCode extends GeneticCode implements Serializable {
    /**
     * Az ágens létrehozásáért felelős metódus.
     * Meghivja a useMaterial() függvényt az alapanyagokra, amennyiben rendelkezik a szükséges mennyiséggel
     * @param - A készitő virológus
     */

    public ChoreaCode()
    {
        name = "ChoreaCode";
        nucleotideCost=1;
        aminoAcidCost=1;
    }
    /**
     * Letre hozza a virust es hozzaadja a virologus tarolojahoz
     * @param v a keszito virologus
     * @return elkeszult-e a virus
     */
    public boolean Create(Virologist v){

        ArrayList<Material> costs = new ArrayList<Material>();
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
            ChoreaVirus virus = new ChoreaVirus();
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
