package vilagtalanvirologusok;

/**
 * A játékot kezeli. A játék indításakor létrehozza a pályát.
 * A körök végén ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot.
 */
public class Game {
    /**
     *  Inicializálja a játék kezdéséhez szükséges objektumokat.
     */
    public void StartGame(){
        System.out.println("Game: StartGame()");
    }

    /**
     * Leállítja a játékot, nyereség vagy veszteség hatására hívódik meg.
     */
    public void EndGame(){
        System.out.println("Game: EndGame()");
    }

    /**
     *  Minden körben ellenőrzi, hogy van-e olyan virológus aki megtanulta az összes genetikai kódot,
     *  és ha van, meghívja az +EndGame(): void metódust.
     */
    public void CheckEndGame(){
        System.out.println("Game: CheckEndGame()");
    }
}
