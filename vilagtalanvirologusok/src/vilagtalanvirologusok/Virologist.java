package vilagtalanvirologusok;

import java.util.List;

public class Virologist implements Steppable{
    public void Touch(Virologist v, Agent a){
        System.out.println("Virologist: Touch()");
    }
    public void GetTouched(Agent a){
        System.out.println("Virologist: GetTouched()");
    }
    public void Step(){
        System.out.println("Virologist: Step()");
    }
    public void LearnGeneticCode(GeneticCode g){
        System.out.println("Virologist: LearnGeneticCode()");
    }
    public void StealEquipment(Virologist v){
        System.out.println("Virologist: StealEquipment()");
    }
    public void PickupEquipment(Material m){
        System.out.println("Virologist: PickupEquipment()");
    }
    public void RemoveEquipment(Material m){
        System.out.println("Virologist: RemoveEquipment()");
    }
    public void CraftAgent(Agent a){
        System.out.println("Virologist: CraftAgent()");
    }
    public void ApplyAgent(Agent a){
        System.out.println("Virologist: ApplyAgent()");
    }
    public void RemoveAgent(){
        System.out.println("Virologist: RemoveAgent()");
    }
    public void Move(){
        System.out.println("Virologist: Move()");
    }
    public boolean UseMaterial(List<Material> m){
        System.out.println("Virologist: UseMaterial()");
        if (true)
            return true;
        return false;
    }
    public boolean PickupMaterial(Material m){
        System.out.println("Virologist: PickupMaterial()");
        if (true)
            return true;
        return false;
    }
    public void RemoveMaterial(Material m){
        System.out.println("Virologist: RemoveMaterial()");
    }


}
