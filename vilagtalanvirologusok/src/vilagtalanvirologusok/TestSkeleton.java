package vilagtalanvirologusok;


public class TestSkeleton {
    int success = 0;
    int fail = 0;

    public TestSkeleton(){
        testVirologistMoveStreet();
        testVirologistMoveLaboratory();
        testVirologistMoveLaboratorywithBearVirus();
        testVirologistMoveShelter();
        testVirologistMoveStorage();
        testVirologistInfectedwithBearmovestoStorage();
        testVirologistInfectedwithBearmovestoVirologist();
        craftAgentWithoutEnoughMaterial();
        craftAgent();
        learnGeneticCode();
        testPickupEquipment1();
        testPickupEquipment2();
        testDropEquipment();
        testStealEquipment();
        testUseAxe();
        testChoreVirusAffect();

        System.out.println("Test succeded: "+ success);
        System.out.println("Test failed: "+ fail);
    }


    public void testVirologistMoveStreet() {
        Street s1 = new Street(0,0);
        Street s2 = new Street(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2)) {
            success++;
        } else  {
            fail++;
        }
    }
    public void testVirologistMoveLaboratory() {
        Street s1 = new Street(0,0);
        Laboratory s2 = new Laboratory(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2) && v.getKnownAgents() != null) {
            success++;
        } else  {
            fail++;
        }
    }
    public void testVirologistMoveLaboratorywithBearVirus() {
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
        } else  {
            fail++;
        }
    }
    public void testVirologistMoveShelter() {
        Street s1 = new Street(0,0);
        Shelter s2 = new Shelter(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);

        v.Move(false);

        if (v.getLocation().equals(s2)) {
            success++;
        } else  {
            fail++;
        }
    }
    public void testVirologistMoveStorage() {
        Street s1 = new Street(0,0);
        Storage s2 = new Storage(50,50);
        Virologist v = new Virologist("jatekos",s1,1);
        s1.AddVirologist(v);
        s1.neighbours.add(s2);


        v.Move(false);

        if (v.getLocation().equals(s2)) {
            success++;
        } else  {
            fail++;
        }
    }
    public void testVirologistInfectedwithBearmovestoStorage() {
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
        } else  {
            fail++;
        }
    }
    public void testVirologistInfectedwithBearmovestoVirologist() {
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
        } else  {
            fail++;
        }
    }

    public void craftAgent() {
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
        }
        else {
            fail++;
        }
    }

    public void craftAgentWithoutEnoughMaterial() {
        Center center = new Street(1, 0);
        Virologist v1 = new Virologist("v1", center, 1);
        center.AddVirologist(v1);

        GeneticCode gc = new ProtectorCode();
        v1.LearnGeneticCode(gc);
        v1.PickupMaterial(new Nucleotide());

        v1.CraftAgent(gc);

        if (v1.getKnownAgents().size() == 0) {
            success++;
        }
        else {
            fail++;
        }
    }

    public void learnGeneticCode() {
        Laboratory lab = new Laboratory(1, 2);
        Virologist v2 = new Virologist("v2", lab, 2);
        lab.AddVirologist(v2);

        GeneticCode gc = lab.getGC();
        v2.LearnGeneticCode(gc);

        if (v2.getGeneticCode().size() > 0) {
            success++;
        }
        else {
            fail++;
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

    public void testUseitemCloak()
    {

    }

}

