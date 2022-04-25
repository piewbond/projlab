package vilagtalanvirologusok;


public class TestSkeleton {
    int success = 0;
    int fail = 0;

    public TestSkeleton(){
        new Game();
        testVirologistMoveStreet();
        

        System.out.println("Test succeded: "+ success);
        System.out.println("Test failed: "+ success);
    }


    public void testVirologistMoveStreet() {
        Center s = new Street(0,0);
        Center s1 = new Street(50,50);
        Virologist v1 = new Virologist("alma",s);
        s1.AddVirologist(v1);
        s.RemoveVirologist(v1);
        if (s.virologists == null && s1.virologists != null) {
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

}

