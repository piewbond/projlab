package vilagtalanvirologusok;


public class TestSkeleton {
    int success = 0;
    int fail = 0;
    String methodName;

    public TestSkeleton(){
        testVirologistMoveStreet();
        testVirologistMoveLaboratory();
        testVirologistMoveLaboratorywithBearVirus();
        testVirologistMoveShelter();
        testVirologistMoveStorage();
        testVirologistInfectedwithBearmovestoStorage();
        testVirologistInfectedwithBearmovestoVirologist();
        PickupMaterialFullBag();
        PickupMaterialnotFullBag();
        PickupMaterialFullInventory();
        PickupMaterialnotFullInventory();
        craftAgentWithoutEnoughMaterial();
        craftAgent();
        learnGeneticCode();

        System.out.println("\nTests succeeded overall: "+ success);
        System.out.println("Tests failed overall: "+ fail);
    }

    public void printSuccess(String methodName) {
        System.out.println("Test succeeded: " + methodName);
    }

    public void printFail(String methodName) {
        System.out.println("Test failed: " + methodName);
    }

    public void testVirologistMoveStreet() {
        methodName = "testVirologistMoveStreet";
        Street s1 = new Street(0,0);
        Street s2 = new Street(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2)) {
            printSuccess(methodName);
            success++;
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistMoveLaboratory() {
        methodName = "testVirologistMoveLaboratory";
        Street s1 = new Street(0,0);
        Laboratory s2 = new Laboratory(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2) && v.getKnownAgents() != null) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistMoveLaboratorywithBearVirus() {
        methodName = "testVirologistMoveLaboratorywithBearVirus";
        Street s1 = new Street(0,0);
        Laboratory s2 = new Laboratory(50,50);
        s2.setContiguous(true);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);
        v.ApplyAgent(new ProtectorVaccine());
        v.Move(false);
        if (v.getLocation().equals(s2) && v.getActiveAgents().size()==0) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistMoveShelter() {
        methodName = "testVirologistMoveShelter";
        Street s1 = new Street(0,0);
        Shelter s2 = new Shelter(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);

        v.Move(false);

        if (v.getLocation().equals(s2)) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistMoveStorage() {
        methodName = "testVirologistMoveStorage";
        Street s1 = new Street(0,0);
        Storage s2 = new Storage(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2)) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistInfectedwithBearmovestoStorage() {
        methodName = "testVirologistInfectedwithBearmovestoStorage";
        Laboratory s1 = new Laboratory(0,0);
        Storage s2 = new Storage(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.Infect();
        s1.neighbours.add(s2);
        s2.AddVirologist(v);
        v.getActiveAgents().get(0).Affect(v);

        if (s2.getMaterial().size() == 0) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void testVirologistInfectedwithBearmovestoVirologist() {
        methodName = "testVirologistInfectedwithBearmovestoVirologist";
        Laboratory s1 = new Laboratory(0,0);
        Storage s2 = new Storage(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        Virologist v2 = new Virologist("jatekos2",s1,1);
        s1.AddVirologist(v);
        s1.AddVirologist(v2);
        s1.Infect();
        s1.neighbours.add(s2);
        v.getActiveAgents().get(0).Affect(v);

        if (v2.getActiveAgents().size()>0) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void PickupMaterialFullInventory(){
        methodName = "PickupMaterialFullInventory";
        Street s1 = new Street(0,0);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);

        for (int i=0; i<10;i++)
            v.PickupMaterial(new Nucleotide());

        v.PickupMaterial(new Nucleotide());

        if (v.getMaterials().size() == 10) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void PickupMaterialnotFullInventory(){
        methodName = "PickupMaterialnotFullInventory";
        Street s1 = new Street(0,0);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);

        for (int i=0; i<5;i++)
            v.PickupMaterial(new Nucleotide());

        v.PickupMaterial(new Nucleotide());

        if (v.getMaterials().size() == 6) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void PickupMaterialFullBag(){
        methodName = "PickupMaterialFullBag";
        Street s1 = new Street(0,0);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        v.PickupEquipment(new Bag());

        for (int i=0; i<20;i++)
            v.PickupMaterial(new Nucleotide());

        v.PickupMaterial(new Nucleotide());
        Bag b = (Bag) v.getEquipments().get(0);
        if (v.getMaterials().size() == 10 && b.getMaterials().size() == 10) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void PickupMaterialnotFullBag() {
        methodName = "PickupMaterialnotFullBag";
        Street s1 = new Street(0,0);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        v.PickupEquipment(new Bag());

        for (int i=0; i<15;i++)
            v.PickupMaterial(new Nucleotide());

        v.PickupMaterial(new Nucleotide());
        Bag b = (Bag) v.getEquipments().get(0);
        if (v.getMaterials().size() == 10 && b.getMaterials().size() == 6) {
            success++;
            printSuccess(methodName);
        } else  {
            fail++;
            printFail(methodName);
        }
    }
    public void craftAgent() {
        methodName = "craftAgent";
        Center center = new Street(0, 0);
        Virologist v1 = new Virologist("v1", center, 1);
        center.AddVirologist(v1);

        GeneticCode gc = new ProtectorCode();
        v1.LearnGeneticCode(gc);
        v1.PickupMaterial(new Nucleotide());
        v1.PickupMaterial(new Aminoacid());

        v1.CraftAgent(gc);

        if (v1.getKnownAgents().size() > 0) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public void craftAgentWithoutEnoughMaterial() {
        methodName = "craftAgentWithoutEnoughMaterial";
        Center center = new Street(1, 0);
        Virologist v1 = new Virologist("v1", center, 1);
        center.AddVirologist(v1);

        GeneticCode gc = new ProtectorCode();
        v1.LearnGeneticCode(gc);
        v1.PickupMaterial(new Nucleotide());

        v1.CraftAgent(gc);

        if (v1.getKnownAgents().size() == 0) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public void learnGeneticCode() {
        methodName = "learnGeneticCode";
        Laboratory lab = new Laboratory(1, 2);
        Virologist v2 = new Virologist("v2", lab, 2);
        lab.AddVirologist(v2);

        GeneticCode gc = lab.getGC();
        v2.LearnGeneticCode(gc);

        if (v2.getGeneticCode().size() > 0) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;printFail(methodName);
        }
    }

}

