package vilagtalanvirologusok;

import java.io.Serializable;

/**
 * Egy olyan szabad terület, ahol a virológusok találkozhatnak, de nincs konkrét tulajdonsága a helynek.
 */
public class Street extends Center implements Serializable {

    public Street(int x, int y){
        super(x,y);
    }
}
