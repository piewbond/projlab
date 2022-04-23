package vilagtalanvirologusok;

/**
 *  A játékban szereplő óvóhelyeket reprezentálja, ezeken a helyszíneken tudnak a virológusok felszereléseket gyűjteni.
 */
public class Shelter extends Center{
    /**
     * Helyhez hozzáad egy felszerelést.
     */
    public void SpawnEquipment(){
        System.out.println("Shelter: SpawnEquipment()");
    }

    /**
     *  Eltávolít a helyről egy felszerelést.
     * @param e - Törlendő felszerelés.
     */
    public void RemoveEquipment(Equipment e){
        System.out.println("Shelter: RemoveEquipment()");
    }

    @Override
    public String getType() {
        return "Shelter";
    }
}
