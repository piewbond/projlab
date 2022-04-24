package vilagtalanvirologusok;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * A Map osztály tartalmazza a játékteret.
 * A játék kezdetekor mindig új pályát generál, rajta tetszőleges, a játékos által választott számú virológussal.
 */
public class Map {
    List<Center> centers;
    /**
     * Generálja a pálya gráfját.
     */
    public Map() {
        centers = new ArrayList<>();
    }
    public void GenerateGraph(){
        //System.out.println("Map: GenerateGraph()");
        try{
            System.out.println("Adja meg a map file eleresi utvonalat: ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            File file = new File(inputString + "map1.txt");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
