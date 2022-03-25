package vilagtalanvirologusok;

import java.util.List;

/**
 * A játékos és a számítógép által irányított karakterek ősosztálya,
 * amik a pályán mozognak és genetikai kódokat gyűjtenek.
 */
public class Virologist implements Steppable{
    /**
     * A megérintést valósítja meg a játékban. Az adott virológus GetTouched() függvényét valósítja meg.
     * @param v - Megérintett virológus.
     * @param a - Ágens, amellyel megérintik.
     */
    public void Touch(Virologist v, Agent a){
        System.out.println("Virologist: Touch()");
    }

    /**
     *  Amikor egy virológust megérintenek ez a metódus hajtja végre az ágens hatását,
     *  ha nincs olyan felszerelése vagy a virológusra ható ágens ami ezt megakadályozza.
     * @param a - Ágens, amellyel megérintik a Virológust.
     */
    public void GetTouched(Agent a){
        System.out.println("Virologist: GetTouched()");
    }

    /**
     * Megvalósítja a Steppable interfészt.
     */
    public void Step(){
        System.out.println("Virologist: Step()");
    }

    /**
     * A laborokban található genetikai kódok közül a
     * megfelelőt megtanítja a virológusnak ezzel közelebb kerül a
     * győzelemhez és egy új ágens elkészítését teszi lehetővé.
     * @param g - Genetik kód, amit a virológus megtanulhat.
     */
    public void LearnGeneticCode(GeneticCode g){
        System.out.println("Virologist: LearnGeneticCode()");
    }

    /**
     *  Ha ugyan azon a mezőn, amin a játékos áll van egy lebénult virológus,
     *  akkor ennek a metódusnak a segítségével tudja elvenni valamelyik felszerelését tőle.
     * @param v - Virológus, akitől el lehet lopni a felszerelését.
     */
    public void StealEquipment(Virologist v){
        System.out.println("Virologist: StealEquipment()");
    }

    /**
     *  Hozzáad egy tárgyat a virológushoz ha korábban nem rendelkezett azzal.
     * @param m - A felvehető tárgy.
     */
    public void PickupEquipment(Material m){
        System.out.println("Virologist: PickupEquipment()");
    }

    /**
     * Ez a metódus távolítja el a virológus egyik felszerelését, amit elvesznek tőle.
     * @param m - Eltávolítandó felszerelés.
     */
    public void RemoveEquipment(Material m){
        System.out.println("Virologist: RemoveEquipment()");
    }

    /**
     * Megfelelő mennyiségű ágens felhasználásával létrehoz egy ágenst.
     * Meghivja a UseMaterial() függvényt, ami ellenőrzi, hogy rendelkezésre
     * áll-e megfelelő mennyiségű material, majd meghívja a removeMaterialt() megfelelő mennyiségre.
     * @param a - Ágens amivel létrehoz egy másikat.
     */
    public void CraftAgent(Agent a){
        System.out.println("Virologist: CraftAgent()");
    }

    /**
     * Saját magára keni fel a virológus a kiválasztott ágenst.
     * @param a - Ágens amit magára ken.
     */
    public void ApplyAgent(Agent a){
        System.out.println("Virologist: ApplyAgent()");
    }

    /**
     * A step() metódus meghívására kitöröl minden olyan ágenst aminek a lifetimeja 0.
     */
    public void RemoveAgent(){
        System.out.println("Virologist: RemoveAgent()");
    }

    /**
     * a Virologist osztály mozgását valósítja meg.
     * Először lekéri a szomszédos mezőket majd a játékos kiválasztja hova szeretne lépni
     * és meghívja a RemoveVirologist(v: Virologist) a mezőre amin áll majd a
     * AddVirologist(v: Virologist) a mezőre amire lépni szeretne.
     */
    public void Move(){

        System.out.println("Virologist: Move()");
    }

    /**
     * Ellenőrzi, hogy a virológus rendelkezik-e a megfelelő mennyiségű materiallal.
     * @param m - Az anyagok listája.
     * @return
     */
    public boolean UseMaterial(List<Material> m){
        System.out.println("Virologist: UseMaterial()");
        if (true)
            return true;
        return false;
    }

    /**
     * Adott anyag mennyiséget ad hozzá, ha a táskája vagy a virológus képes azt eltárolni.
     * @param m - Anyag, amit a Virológus felvehet.
     * @return - Van hely a Virológusnál és feltudja venni vagy sem.
     */
    public boolean PickupMaterial(Material m){
        System.out.println("Virologist: PickupMaterial()");
        if (true)
            return true;
        return false;
    }

    /**
     * Adott anyagot töröl.
     * @param m - Törölni kívánt anyag.
     */
    public void RemoveMaterial(Material m){
        System.out.println("Virologist: RemoveMaterial()");
    }


}
