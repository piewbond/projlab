package vilagtalanvirologusok;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class BearVirus extends Agent{
    /**
     * a megfertozott jatekosra kifejtett hatasait valositja meg
     * @param v - Virológus, akin kifejti a hatást
     */
    @Override
    public void Affect(Virologist v)
    {
        /**
         * elmozgatas
         */
        Center location = v.getLocation();
        Center nextlocation;
        List<Center> neighbours = v.getLocation().GetNeighbours();
        int size = neighbours.size();
        Random r = new Random();
        int random = r.nextInt((size));
        location.RemoveVirologist(v);
        nextlocation = neighbours.get(random);
        nextlocation.AddVirologist(v);
        v.setLocation(nextlocation);
        /**
         * raktarbol alapanyagok torlese
         */
        if(nextlocation.getName().compareTo("Storage") == 0)
        {
            Storage st = (Storage) nextlocation;
            st.RemoveMaterial(st.getMaterial().get(0));
        }
        /**
         * jatekosok megfertozese
         */
        List<Virologist> virologists = nextlocation.getVirologists();
        for(int i = 0; i < virologists.size()-1; i++)
        {
            virologists.get(i).GetTouched(virologists.get(i),new BearVirus());
        }
        //System.out.println("BearVirus: Affect()");
    }

    /**
     * A visitor minta megvalositashoz szukseges segedmetodus
     */
    @Override
    public boolean acceptBear(AgVisitor agVisitor, Virologist virologist)
    {
       return agVisitor.visit(this,virologist);
    }

}
