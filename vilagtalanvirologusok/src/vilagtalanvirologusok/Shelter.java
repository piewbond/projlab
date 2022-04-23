package vilagtalanvirologusok;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *  A játékban szereplő óvóhelyeket reprezentálja, ezeken a helyszíneken tudnak a virológusok felszereléseket gyűjteni.
 */
public class Shelter extends Center{
    private List<Equipment> equipments;
    private int cordx;
    private int cordy;
    /**
     *  Letrehozza a sheltert es random maximum haromnszor letrehozza a benne levo itemeket
     *  minden esetben random sorsolja hogy melyik itemet helyezi el
     */
    public Shelter(int x, int y){
        super(x,y);
        equipments = new ArrayList<>();
        Random r = new Random();
        for (int i=0; i< r.nextInt(2)+1;i++) {
            SpawnEquipment();
        }
    }

    /**
     * Helyhez hozzáad egy felszerelést.
     * random sorsolassal donti el melyik felszerelest adja hozza
     */
    public void SpawnEquipment(){
        //System.out.println("Shelter: SpawnEquipment()");
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                equipments.add(new Axe());
                break;
            case 1:
                equipments.add(new Cloak());
                break;
            case 2:
                equipments.add(new Glove());
                break;
            case 3:
                equipments.add(new Bag());
                break;
        }
    }

    /**
     @ -16,7 +51,8 @@ public class Shelter extends Center{
     * @param e - Törlendő felszerelés.
     */
    public void RemoveEquipment(Equipment e){
        //System.out.println("Shelter: RemoveEquipment()");
        equipments.remove(e);
    }
}
