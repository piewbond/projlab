package vilagtalanvirologusok;

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
        VirologistMoves(1);
    }
    public void VirologistMoves(int scenarionmb){
        int callnmb = 1;
        prt(callnmb++,"Virologist","v","Move()","");
        prt(callnmb++,"Street","s","GetNeighbours()","list<Neighbours> neighbours");
        prt(callnmb++,"Street","s","RemoveVirologist()","");
        prt(callnmb++,"Laboratory","lab","AddVirologist","");
    }
    public void VirologistCraftsAgent(int scenarionmb){

    }
    public void VirologistUseProtectorVaccine(int scenarionmb){
        switch (scenarionmb) {
            case 1: // Virologist crafted agent
                int callnmb = 1;
                prt(callnmb++, "Virologist", "v", "ApplyVaccine()", "");
                prt(callnmb++, "Virologist", "v", "ApplyAgent()", "");

            case 2: // Virologist hasn't crafted agent
                System.out.println("Virolgist has not crafted vaccine");

        };





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
    public void VirologistUseCloak(int scenarionmb){

    }
    public void VirologistLearnsGeneticCode(int scenarionmb){

    }
    public void VirologistPicksUpEquipment(int scenarionmb){

    }
    public void VirologistStealEquipment(int scenarionmb){

    }
    public void VirologistEndsTurn(int scenarionmb){

    }
    public void VirologistAffectedByChoreaVirus(int scenarionmb){

    }
    public void prt(int callnumber, String classname, String objname, String funcname, String returnparam)
    {
        System.out.println(callnumber+".fgv hívás "+classname+"-osztály "+objname+"-objektum "+funcname+"-fgv név "+returnparam+" visszatérési érték");
    }
}
