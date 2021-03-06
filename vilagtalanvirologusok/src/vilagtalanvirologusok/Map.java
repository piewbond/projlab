package vilagtalanvirologusok;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * A Map osztály tartalmazza a játékteret.
 * A játék kezdetekor mindig új pályát generál, rajta tetszőleges, a játékos által választott számú virológussal.
 */

public class Map implements Serializable {
    List<Center> centers;
    /**
     * Generálja a pálya gráfját.
     */

    public Map() {
        centers = new ArrayList<>();
    }

    /**
     * Filebol beolvassa es letrehozza a grafot
     */
    public void GenerateGraph(){
        int centernmb = 0;
        try{

            File file = new File("map1.txt");

            /**
             * eloszor beolvassa az elso sort es letrehozza a locationokat az alapjan
             */
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] loc = line.split(" ");
            for (int i=0; i<loc.length;i++) {
                switch(loc[i]) {
                    case "0":
                        centers.add(new Street((i%10 + 1)*50,(i/10 + 1)*50));
                        centernmb++;
                        break;
                    case "1":
                        centers.add(new Laboratory((i%10 + 1)*50,(i/10 + 1)*50));
                        centernmb++;
                        break;
                    case "2":
                        centers.add(new Storage((i%10 + 1)*50,(i/10 + 1)*50));
                        centernmb++;
                        break;
                    case "3":
                        centers.add(new Shelter((i%10 + 1)*50,(i/10 + 1)*50));
                        centernmb++;
                        break;

                }
            }
            /**
             * letrehoz egy seged tombot ami a kapcsolatok fogja abrazolni a grafban
             * minden elemet -1re allitja
             */
            int[][] neigh = new int[centernmb][7];
            for (int i= 0;i<centernmb;i++) {
                for (int j = 0; j<7;j++)
                    neigh[i][j] = -1;
            }
            /**
             * vegig megy es beolvas minden centerhez a hozzatartozo szomszedokat
             */
            int k = 0;
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] str = line.split(" ");
                for (int j=0 ; j<str.length; j++)
                    neigh[k][j] = Integer.parseInt(str[j]);

                k++;
            }

            /**
             * beallitja a centerek szomszedjait a fileban meghatarozottra
             */
            for (int i = 0; i< centernmb;i++) {
                for (int j = 0; j < 7;j++) {
                    if(neigh[i][j] >= 0)
                        centers.get(i).neighbours.add(centers.get(neigh[i][j]));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Center getCenter(String coord) {
        return centers.get(Integer.parseInt(coord));
    }
    /**
     * neve alapjan megkeresi es visszaadja a virologust
     * @return
     */
    public Virologist findVirologist(String name) {
        Virologist res = null;

        for (Center center : centers) {
            for (Virologist virologist : center.virologists) {
                if (virologist.getName().equals(name)) {
                    res = virologist;
                }
            }
        }
        return res;
    }

    /**
     * szama alapjan megkeresi es visszaadja a virologust
     * @param playerNumber
     * @return
     */
    public Virologist findVirologistByNum(int playerNumber) {
        Virologist res = null;

        for (Center center : centers) {
            for (Virologist virologist : center.virologists) {
                if (virologist.getNumber() == playerNumber) {
                    res = virologist;
                }
            }
        }
        return res;
    }

    public List<Center> getCenters()
    {
        return centers;
    }

}
