package vilagtalanvirologusok;

import java.util.Scanner;

public class Skeleton {
    public void SkeletonMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[0]Virologist moves\n" +
                "[1]  Virologist crafts agent\n" +
                "[2]  Virologist use protector vaccine\n" +
                "[3]  Virologist use paralyze virus\n" +
                "[4]  Virologist use chorea virus\n" +
                "[5]  Virologist use amnesia virus\n" +
                "[6]  Virologist picks up material\n" +
                "[7]  Virologist use glove\n" +
                "[8]  Virologist use cloak\n" +
                "[9]  Virologist learns genetic code\n" +
                "[10] Virologist picks up equipment\n" +
                "[11] Virologist steal equipment\n" +
                "[12] Virologist ends turn\n" +
                "[13] Virologist affected by chorea virus\n");

        String selected = scanner.nextLine();

        switch (selected) {
            case "0" : VirologistMoves();
            case "1" : VirologistCraftsAgent();
            case "2" :  VirologistUseProtectorVaccine();
            case "3" :  VirologistUseParalyzeVirus();
            case "4" : VirologistUseChoreaVirus();
            case "5" : VirologistUseAmnesiaVirus();
            case "6" : VirologistPicksUpMaterial();
            case "7" : VirologistUseGlove();
            case "8" : VirologistUseCloak();
            case "9" : VirologistLearnsGeneticCode();
            case "10" : VirologistPicksUpEquipment();
            case "11" : VirologistStealEquipment();
            case "12" : VirologistEndsTurn();
            case "13" : VirologistAffectedByChoreaVirus();
            default : System.out.println("Enter a valid answer");
        }
    }


    public void VirologistMoves() {
        int callnmb = 1;
        prt(callnmb++, "Virologist", "v", "Move()", "");
        prt(callnmb++, "Street", "s", "GetNeighbours()", "list<Neighbours> neighbours");
        prt(callnmb++, "Street", "s", "RemoveVirologist()", "");
        prt(callnmb, "Laboratory", "lab", "AddVirologist", "");

        this.continueProcess();
    }


    public void VirologistCraftsAgent() {
        int callnmb = 1;
        Scanner scanner = new Scanner(System.in);
        int amino;
        int nucleo;
        System.out.println("How much nucleotide does the virologist has?");
        String ans = scanner.nextLine();
        nucleo = Integer.parseInt(ans);
        System.out.println("How much amino acid does the virologist has?");
        ans = scanner.nextLine();
        amino = Integer.parseInt(ans);
        System.out.println("Choose which agent do you craft: ");
        System.out.println("[0] Craft Chorea Virus " +
                " [1] Craft Paralyze Virus " +
                "[2] Craft Protector Vaccine " +
                "[3] Craft Amnesia Virus ");
        ans = scanner.nextLine();
        switch (ans) {
            case "0" : {
                prt(callnmb++, "ChoreaCode", "c", "Create(v)", "");
                if (nucleo >= 1 && amino >= 1) {
                    prt(callnmb++, "Virologist", "v", "UseMaterial(m)", "true");
                    for (int i = 0; i < 2; i++)
                        prt(callnmb++, "Virologist", "v", "RemoveMaterial(m)", "");

                    prt(callnmb++, "ChoreaVirus", "a", "<<create>>", "");
                    prt(callnmb++, "Turnable", "t", "AddSteppable(s)", "");
                    prt(callnmb, "Virologist", "v", "CraftAgent(a)", "");
                } else {
                    prt(callnmb, "Virologist", "v", "UseMaterial(m)", "false");
                }
            }
            case "1" : {
                prt(callnmb++, "ParalyzeCode", "c", "Create(v)", "");
                if (nucleo >= 1 && amino >= 1) {
                    prt(callnmb++, "Virologist", "v", "UseMaterial(m)", "true");
                    for (int i = 0; i < 6; i++)
                        prt(callnmb++, "Virologist", "v", "RemoveMaterial(m)", "");

                    prt(callnmb++, "ParalyzeVirus", "a", "<<create>>", "");
                    prt(callnmb++, "Turnable", "t", "AddSteppable(s)", "");
                    prt(callnmb, "Virologist", "v", "CraftAgent(a)", "");
                } else {
                    prt(callnmb, "Virologist", "v", "UseMaterial(m)", "false");
                }
            }
            case "2" : {
                prt(callnmb++, "ProtectorCode", "c", "Create(v)", "");
                if (nucleo >= 1 && amino >= 1) {
                    prt(callnmb++, "Virologist", "v", "UseMaterial(m)", "true");

                    for (int i = 0; i < 2; i++)
                        prt(callnmb++, "Virologist", "v", "RemoveMaterial(m)", "");

                    prt(callnmb++, "ProtectorVaccine", "a", "<<create>>", "");
                    prt(callnmb++, "Turnable", "t", "AddSteppable(s)", "");
                    prt(callnmb, "Virologist", "v", "CraftAgent(a)", "");
                } else {
                    prt(callnmb, "Virologist", "v", "UseMaterial(m)", "false");
                }
            }
            case "3" : {
                prt(callnmb++, "AmnesiaCode", "c", "Create(v)", "");
                if (nucleo >= 1 && amino >= 1) {
                    prt(callnmb++, "Virologist", "v", "UseMaterial(m)", "true");
                    for (int i = 0; i < 10; i++)
                        prt(callnmb++, "Virologist", "v", "RemoveMaterial(m)", "");

                    prt(callnmb++, "AmnesiaVirus", "a", "<<create>>", "");
                    prt(callnmb++, "Turnable", "t", "AddSteppable(s)", "");
                    prt(callnmb, "Virologist", "v", "CraftAgent(a)", "");
                } else {
                    prt(callnmb, "Virologist", "v", "UseMaterial(m)", "false");
                }
            }
        }
        this.continueProcess();
    }


    public void VirologistUseProtectorVaccine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Did the virologist craft this type of vaccine earlier? [y / n]"); // Opt on sequence diagram
        String ans = scanner.nextLine();

        switch (ans) {
            case "y" : { // Virologist crafted agent
                int callnmb = 1;
                prt(callnmb++, "Virologist", "v", "ApplyVaccine()", "");
                prt(callnmb, "Virologist", "v", "ApplyAgent()", "");
            }
            case "n" : { // Virologist hasn't crafted agent
                int callnum = 1;
                prt(callnum, "Virologist", "v", "ApplyVaccine()", "false");
            }
            default : System.out.println("Enter a valid answer");
        }

        this.continueProcess();
    }


    public void VirologistUseParalyzeVirus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Did the virologist craft this type of agent earlier? [y / n]");
        String ans = scanner.nextLine();

        switch (ans) {
            case "y" : {
                int callnmb = 1;
                prt(callnmb++, "Virologist", "v1", "Touch()", "");
                prt(callnmb++, "Virologist", "v2", "GetTouched()", "");
                prt(callnmb, "Virologist", "v2", "ApplyAgent()", "");
            }
            case "n" : {
                prt(1, "Virologist", "v1", "Touch()", "false");
            }
            default : System.out.println("Enter a valid answer");
        }
        this.continueProcess();
    }


    public void VirologistUseChoreaVirus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Did the virologist craft this type of agent earlier? [y / n]");
        String answer = scanner.nextLine();

        switch (answer) {
            case "y" : {
                int callnmb = 1;
                prt(callnmb++, "Virologist", "v1", "Touch()", "");
                prt(callnmb++, "Virologist", "v2", "GetTouched()", "");
                prt(callnmb, "Virologist", "v2", "ApplyAgent()", "");
            }
            case "n" : {
                int callnum = 1;
                prt(callnum, "Virologist", "v1", "Touch()", "");
            }
            default : System.out.println("Enter a valid answer");
        }

        this.continueProcess();
    }


    public void VirologistUseAmnesiaVirus() {
        System.out.println("Did the virologist craft this type of vaccine earlier? [y / n]");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        switch (answer) {
            case "y" : {
                int callnmb = 1;
                prt(callnmb++, "Virologist", "v1", "Touch()", "");
                prt(callnmb++, "Virologist", "v2", "GetTouched()", "");
                prt(callnmb, "Virologist", "v1", "ApplyAgent()", "");
            }
            case "n" : {
                int callnum = 1;
                prt(callnum, "Virologist", "v1", "Touch()", "");
            }
            default : System.out.println("Enter a valid answer");
        }

        this.continueProcess();
    }


    public void VirologistPicksUpMaterial() {

        int cn = 1;
        prt(cn++, "Virologist", "v", "Move", "");
        prt(cn++, "Street", "s", "GetNeighbours", "Neighbours");
        prt(cn++, "Street", "s", "RemoveVirologist", "");
        prt(cn++, "Storage", "s", "AddVirologist", "");
        System.out.println("Is the virologist's inventory full?");
        Scanner scanner = new Scanner(System.in);
        String ans1 = scanner.nextLine();
        switch (ans1)
        {
            case "y" :
                    {
                        System.out.println("Does the virologist has a bag?");
                        String ans2 = scanner.nextLine();
                        switch(ans2)
                        {
                            case "y" :
                                    {
                                        System.out.println("Is the bag full?");
                                        String ans3 = scanner.nextLine();
                                        if(ans3.equals("y"))
                                        {
                                            prt(cn++, "Virologist", "v", "PickupMaterial", "false");
                                            prt(cn, "Bag", "b","AddMaterial","false");

                                        }
                                        else if (ans3.equals("n"))
                                        {
                                            prt(cn++, "Virologist", "v", "PickupMaterial", "true");
                                            prt(cn++, "Bag", "b", "AddMaterial", "true");
                                            prt(cn, "Stroga", "s", "RemoveMaterial","");
                                        }
                                    }
                            case "n" :
                                    {
                                        prt(cn, "Virologist", "v", "PickupMaterial", "false");
                                    }
                        }
                    }
            case "n" :
                    {
                        prt(cn++, "Virologist", "v", "PickupMaterial", "true");
                        prt(cn, "Stroga", "s", "RemoveMaterial","");
                    }
        }
        this.continueProcess();
    }


    public void VirologistUseGlove() {

        int cn = 1;
        prt(cn++, "Virologist", "v1", "Touch", "");
        prt(cn++, "Virologist", "v", "GetTouched", "");
        prt(cn++, "Glove", "g", "CastBack", "");
        prt(cn++, "Virologist", "v1", "GetTouched", "");
        prt(cn, "Glove", "g", "DecreaseDurability", "");
        this.continueProcess();
    }


    public void VirologistUseCloak() {
        int cn = 1;
        prt(cn++, "Virologist", "v1", "Touch", "");
        prt(cn++, "Virologist", "v", "GetTouched", "");
        System.out.println("Does the cloak resist the agent? y/n?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("y")) {
            prt(cn++, "Cloak", "c", "Resist", "true");
            prt(cn++, "Cloak", "c", "DecreaseDurability", "");
        } else if (input.equals("n")) {
            prt(cn++, "Cloak", "c", "Resist", "false");
            prt(cn++, "Virologist", "v", "Apply agent", "");
        }
        prt(cn, "Cloak", "c", "Resist", "");
        this.continueProcess();
    }


    public void VirologistLearnsGeneticCode() {
        int cn = 1;
        prt(cn++, "Virologist", "v", "Move", "");
        prt(cn++, "Street", "s", "GetNeighbours", "Neighbours");
        prt(cn++, "Street", "s", "RemoveVirologist", "");
        prt(cn++, "Laboratory", "l", "AddVirologst", "");
        prt(cn, "Virologist", "v", "LearnGeneticCode", "");
        this.continueProcess();
    }


    public void VirologistPicksUpEquipment() {
        int cn = 1;
        prt(cn++, "Virologist", "v", "Move", "");
        prt(cn++, "Street", "st", "GetNeighbours", "Neighbours");
        prt(cn++, "Street", "st", "RemoveVirologist", "");
        prt(cn++, "Shelter", "sh", "AddVirologist", "");

        System.out.println("Does the virologist already have the equipment? y/n?");
        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();
        if (input.equals("y")) {
            prt(cn, "Virologist", "v", "PickUpEquipment", "false");
        } else if (input.equals("n")) {
            prt(cn++, "Virologist", "v", "PickUpEquipment", "true");
            prt(cn, "Shelter", "st", "RemoveEquipment", "");
        }
        this.continueProcess();
    }


    public void VirologistStealEquipment() {

        int cn = 1;
        System.out.println("Is the other virologist paralyzed?");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        switch(ans)
        {
            case "y" :
                    {
                        prt(cn++, "Virologist", "v1", "StealEquipment", "");
                        prt(cn++, "Virologist", "v2", "GetEquipments", "Equipments");
                        prt(cn++, "Virologist", "v2", "RemoveEquipment", "");
                        prt(cn, "Virologist", "v1", "PickupEquipment", "");
                    }
            case "n" :
                    {
                        break;
                    }
        }

        this.continueProcess();
    }



    public void VirologistEndsTurn() {
        int callnmb = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are there any virologist who has all of the GeneticCode? [y / n]"); // Opt on sequence diagram
        String ans = scanner.nextLine();

        prt(callnmb++,"Turnable","t","EndTurn()","");
        prt(callnmb++,"Turnable","t","StepAllSteppable()","");
        prt(callnmb++,"Game","g","CheckEndGame()","");
        if (ans.equals("y"))
            prt(callnmb,"Game","g","EndGame()","");

        this.continueProcess();
    }


    public void VirologistAffectedByChoreaVirus()
    {
        int callnmb = 1;
        prt(callnmb++,"Virologist","v","Step()","");
        prt(callnmb++,"ChoreaVirus","c","Affect()","");
        prt(callnmb,"Virologist","v","Move()","");

        this.continueProcess();
    }


    public void prt(int callnumber, String classname, String objname, String funcname, String returnparam) {
        System.out.println(callnumber+".fgv h??v??s "+classname+"-oszt??ly "+objname+"-objektum "+funcname+"-fgv n??v "+returnparam+" visszat??r??si ??rt??k");
    }


    public void continueProcess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? [y / n]");
        String ans = scanner.nextLine();

        if (ans.equals("y")) {
            this.SkeletonMenu();
        }
        else {
            System.exit(0);
        }
    }
}
