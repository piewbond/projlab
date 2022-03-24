package vilagtalanvirologusok;

public class Turnable {
    public void EndTurn(){
        System.out.println("Turnable: EndTurn()");
    }
    public void AddSteppable(Steppable s){
        System.out.println("Turnable: AddSteppable()");
    }
    public void RemoveSteppable(Steppable s){
        System.out.println("Turnable: RemoveSteppable()");
    }
    public void StepAllSteppable(){
        System.out.println("Turnable: StepAllSteppable()");
    }
}
