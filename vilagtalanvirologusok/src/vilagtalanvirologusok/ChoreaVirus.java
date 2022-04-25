package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Azt a vírust valósítja meg amelyet felkenve egy virológusra, az 3 körig elveszti az irányítást a karaktere felett és
 * az véletlenszerű irányba mozog ezalatt az időtartam alatt.
 */
public class ChoreaVirus extends Agent implements Serializable {
    /**
     * Az osztály az őséhez tartozó virtuális függvényt tartalmazza:
     * A virológus véletlenszerűen kezd el mozogni a pályán, kezelhetetlenné válik, amíg a hatása tart.
     * @param v - Virologus, akin kifejti a hatast
     */
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
        System.out.println("ChoreaVirus: Affect()");
    }
}
