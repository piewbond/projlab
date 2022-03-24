package vilagtalanvirologusok;
import java.util.ArrayList;
import java.util.List;

public class Center {
    public void AddVirologist(Virologist v){
        System.out.println("Center: AddVirologist()");
    }
    public void RemoveVirologist(Virologist v){
        System.out.println("Center: RemoveVirologist()");
    }
    public List<Center> GetNeighbours(){
        System.out.println("Center: GetNeighbours()");
        List<Center> l = new ArrayList<Center>();
        return l;
    }
}
