package vilagtalanvirologusok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Skeleton {
    public void SkeletonMenu() {
        System.out.println("[0]Virologist moves\n" +
                "[1]Virologist crafts agent\n" +
                "[2]Virologist use protector vaccine\n" +
                "[3]Virologist use paralyze virus\n" +
                "[4]Virologist use chorea virus\n" +
                "[5]Virologist use amnesia virus\n" +
                "[6]Virologist picks up material\n" +
                "[7]Virologist use glove\n" +
                "[8]Virologist use cloak\n" +
                "[9]Virologist learns genetic code\n" +
                "[10]Virologist picks up equipment\n" +
                "[11]Virologist steal equipment\n" +
                "[12]Virologist ends turn\n" +
                "[13]Virologist affected by chorea virus\n");

        System.out.println();
        VirologistPicksUpEquipment();
        VirologistLearnsGeneticCode();
        VirologistUseCloak(1);
    }
    public void VirologistMoves(int scenarionmb){
        int callnmb = 1;
        prt(callnmb,"Virologist","v","Move()","");
        callnmb++;
        prt(callnmb,"Street","s","GetNeighbours()","list<Neighbours> neighbours");
        callnmb++;
        prt(callnmb,"Street","s","RemoveVirologist()","");
        callnmb++;
        prt(callnmb,"Laboratory","lab","AddVirologist","");
    }
    public void VirologistCraftsAgent(int scenarionmb){

    }
    public void VirologistUseProtectorVaccine(int scenarionmb){

    }
    public void VirologistUseParalyzeVirus(int scenarionmb){

    }
    public void VirologistUseChoreaVirus(int scenarionmb){

    }
    public void VirologistUseAmnesiaVirus(int scenarionmb){

    }
    public void VirologistPicksUpMaterial(int scenarionmb){

    }
    public void VirologistUseGlove(int scenarionmb){

    }
    public void VirologistUseCloak(int scenarionmb)
    {
        int cn=1;
        prt(cn++,"Virologist","v1","Touch","");
        prt(cn++,"Virologist","v","GetTouched","");
        System.out.println("Kivédi e az ágenst a köpeny? y/n?");
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
            if(input.equals("y"))
            {
                prt(cn++,"Cloak","c","Resist","true");
                prt(cn++,"Cloak","c","DecreaseDurability","");
            }
            else if(input.equals("n"))
            {
                prt(cn++,"Cloak","c","Resist","false");
                prt(cn++,"Virologist","v","Apply agent","");
            }
        prt(cn++,"Cloak","c","Resist","");
    }
    public void VirologistLearnsGeneticCode()
    {
        int cn=1;
        prt(cn++,"Virologist","v","Move","");
        prt(cn++,"Street","s","GetNeighbours","Neighbours");
        prt(cn++,"Street","s","RemoveVirologist","");
        prt(cn++,"Laboratory","l","AddVirologst","");
        prt(cn++,"Virologist","v","LearnGeneticCode","");
    }
    public void VirologistPicksUpEquipment(){

        int cn=1;
        prt(cn++,"Virologist","v","Move","");
        prt(cn++,"Street","st","GetNeighbours","Neighbours");
        prt(cn++,"Street","st","RemoveVirologist","");
        prt(cn++,"Shelter","sh","AddVirologist","");

        System.out.println("Van-e mar olyan felszerelese, amit fel akar venni? y/n?");
        Scanner sc = new Scanner(System.in);


            String input = sc.nextLine();
            if(input.equals("y"))
            {
                prt(cn++,"Virologist","v","PickUpEquipment","false");
            }
            else if(input.equals("n"))
            {
                prt(cn++,"Virologist","v","PickUpEquipment","true");
                prt(cn++,"Shelter","st","RemoveEquipment","");
            }
    }
    public void VirologistStealEquipment(int scenarionmb){

    }
    public void VirologistEndsTurn(int scenarionmb){

    }
    public void VirologistAffectedByChoreaVirus(int scenarionmb){

    }
    public void prt(int callnumber, String classname, String objname, String funcname, String returnparam)
    {
        System.out.println(callnumber+".fgv hivas "+classname+"-osztaly "+objname+"-objektum "+funcname+"-fgv nev "+returnparam+" visszateresi ertek");
    }
}
