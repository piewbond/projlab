package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * A játékban szereplő anyagok ősosztálya. Az anyagok heterogén kollekcióként megvalósítása a célja.
 */
public class Material implements Serializable {

    private String name;

    public String getName() { return name; }

    public String toString() {
        return "Type: " + this.getClass().getName();
    }
}
