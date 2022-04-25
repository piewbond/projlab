package vilagtalanvirologusok;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BearVirus extends Agent{

    @Override
    public void Affect(Virologist v)
    {
        Center location = v.getLocation();
        Center nextlocation;
        List<Center> neighbours = v.getLocation().GetNeighbours();
        int size = neighbours.size();
        Random r = new Random();
        int random = r.nextInt((size) + 1);
        location.RemoveVirologist(v);
        nextlocation = neighbours.get(random);
        nextlocation.AddVirologist(v);
        if(nextlocation.getName() == "Storage")
        {
            Storage st = (Storage) nextlocation;
            st.RemoveMaterial(st.getMaterial().get(0));
        }
        List<Virologist> virologists = nextlocation.getVirologists();
        for(int i = 0; i < virologists.size(); i++)
        {
            virologists.get(i).GetTouched(virologists.get(i),new BearVirus());
        }
        System.out.println("BearVirus: Affect()");
    }


    @Override
    public boolean acceptBear(AgVisitor agVisitor, Virologist virologist)
    {
       return agVisitor.visit(this,virologist);
    }

}
