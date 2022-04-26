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

}

