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
        testPickupEquipment1();
        testPickupEquipment2();
        testDropEquipment();
        testStealEquipment();
        testUseAxe();
        testChoreVirusAffect();
        useGlove();
        useProtector();
        useParalyze();
        useAmnesia();
        useCloak();

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
            fail++;
            printFail(methodName);
        }
    }

    public void testPickupEquipment1()
    {
        Street street   = new Street(1,0);
        Virologist v1 = new Virologist("v1",street,1);
        Equipment cloak = new Cloak();
        v1.PickupEquipment(cloak);
        if(v1.getEquipments().size() == 1)
        {
            success++;
        }
        else    {
            fail++;
        }
    }

    public void testPickupEquipment2()
    {
        Street street   = new Street(1,0);
        Virologist v1 = new Virologist("v1",street,1);
        Equipment cloak = new Cloak();
        Equipment glove = new Glove();
        Equipment axe = new Axe();
        Equipment bag = new Bag();
        v1.PickupEquipment(cloak);
        v1.PickupEquipment(glove);
        v1.PickupEquipment(axe);
        v1.PickupEquipment(bag);
        if (v1.getEquipments().size() == 3)
        {
            success++;
        }
        else{
            fail++;
        }
    }

    public void testDropEquipment()
    {
        Street street   = new Street(1,0);
        Virologist v1 = new Virologist("v1",street,1);
        Equipment glove = new Glove();
        v1.PickupEquipment(glove);
        v1.DropEquipment(glove);
        if(v1.getEquipments().size() == 0)
        {
            success++;
        }
        else{
            fail++;
        }
    }

    public void testStealEquipment()
    {
        Street street = new Street(1,0);
        Virologist v1 = new Virologist("v1", street, 1);
        Virologist v2 = new Virologist("v2", street, 2);
        Equipment glove = new Glove();
        v1.PickupEquipment(glove);
        v1.ApplyAgent(new ParalyzeVirus());
        v1.getActiveAgents().get(0).Affect(v1);
        v2.StealEquipment(v1);
        if(v1.getEquipments().size() == 0 && v2.getEquipments().size() == 1)
        {
            success++;
        }
        else{
            fail++;
        }
    }


    public void testUseAxe()
    {
        Street street = new Street(1,0);
        Virologist v1 = new Virologist("v1", street, 1);
        Virologist v2 = new Virologist("v2", street, 2);
        Equipment axe = new Axe();
        v1.PickupEquipment(axe);
        v1.Kill(v2);
        if ((v2.getDead()))
        {
            success++;
        }
        else{
            fail++;
        }
    }
    
    
    public void testChoreVirusAffect()
    {
        Street street1 = new Street(1,0);
        Street street2 = new Street(2,1);
        Street street3 = new Street(1,1);
        street1.neighbours.add(street2);
        street1.neighbours.add(street3);
        Virologist v1 = new Virologist("v1", street1, 1);
        Agent chorea = new ChoreaVirus();
        Center startlocation;
        Center nextlocation;
        v1.ApplyAgent(chorea);
        startlocation =v1.getLocation();
        v1.getActiveAgents().get(0).Affect(v1);
        nextlocation = v1.getLocation();
        if (startlocation != nextlocation)
        {
            success++;
        }
        else{
            fail++;
        }
    }

    public void useCloak()
    {
        methodName = "useCloak";
        Center c1= new Center(1,1);
        Center c2 = new Center(2,2);
        Virologist v1 = new Virologist("v1",c1,1);
        Virologist v2 = new Virologist("v2",c1,2);


        v1.PickupEquipment(new Cloak());
        v2.Touch(v1,new AmnesiaVirus());




        if (v1.getActiveAgents().size()==0) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public void useGlove()
    {
        methodName = "useGlove";
        Center c1= new Center(1,1);
        Center c2 = new Center(2,2);
        Virologist v1 = new Virologist("v1",c1,1);
        Virologist v2 = new Virologist("v2",c1,2);

        v1.PickupEquipment(new Glove());
        v2.Touch(v1,new AmnesiaVirus());
        v2.Touch(v1,new AmnesiaVirus());
        v2.Touch(v1,new AmnesiaVirus());


        if (v1.getEquipments().get(0).getDurability()==0&&v2.getActiveAgents().size()==3) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public  void useAmnesia()
    {
        methodName = "useAmnesia";
        Center c1= new Center(1,1);
        Center c2 = new Center(2,2);
        Virologist v1 = new Virologist("v1",c1,1);
        Virologist v2 = new Virologist("v2",c1,2);
        v1.LearnGeneticCode(new ParalyzeCode());
        v1.LearnGeneticCode(new AmnesiaCode());

        v2.Touch(v1,new AmnesiaVirus());
        v1.Step();

        if (v1.getGeneticCode().size()==0) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public void useProtector()
    {
        methodName = "useProtector";
        Center c1= new Center(1,1);
        Center c2 = new Center(2,2);
        Virologist v1 = new Virologist("v1",c1,1);
        Virologist v2 = new Virologist("v2",c1,2);
        v1.ApplyAgent(new ProtectorVaccine());
        v2.Touch(v1,new AmnesiaVirus());

        if (v1.getActiveAgents().size()==1) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }

    public void useParalyze()
    {
        methodName = "useParalyze";
        Center c1= new Center(1,1);
        Center c2 = new Center(2,2);
        Virologist v1 = new Virologist("v1",c1,1);
        Virologist v2 = new Virologist("v2",c1,2);

        v2.learnAgent(new ParalyzeVirus());
        v2.Touch(v1,v2.getKnownAgents().get(0));


        if (v2.getKnownAgents().size()==0&&v1.getActiveAgents().size()==1) {
            success++;
            printSuccess(methodName);
        }
        else {
            fail++;
            printFail(methodName);
        }
    }
}

