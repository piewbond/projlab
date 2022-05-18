package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.Random;

/**
 *A Laboratórium helyiséget valósítja meg, a virológusok itt olvashatják le a győzelemhez szükséges genetikai kódokat.
 */
public class Laboratory extends Center implements Serializable {
    private boolean contiguous;
    private GeneticCode gn;
    public Laboratory(int x, int y) {
        super(x, y);
        Random r = new Random();
        contiguous = r.nextInt(100) > 80;
        SpawnGeneticCode();
    }
    /**
     * Genetikai kódot generál a laboratóriumba.
     */
    public void SpawnGeneticCode(){
        //System.out.println("Laboratory: SpawnGeneticCode()");
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                gn = new AmnesiaCode();
                break;
            case 1:
                gn = new ProtectorCode();
                break;
            case 2:
                gn = new ChoreaCode();
                break;
            case 3:
                gn = new ParalyzeCode();
                break;
        }

    }
    public void AddVirologist(Virologist v) {
        virologists.add(v);
        if (contiguous)
            Infect();
        v.LearnGeneticCode(gn);
        
    }

    public void Infect(){
        for (Virologist v: virologists
             ) {
            v.GetTouched(v,new BearVirus());
        }
    }

    public GeneticCode getGC() {
        return this.gn;
    }
    public void setContiguous(boolean c) { contiguous= c;}

}
