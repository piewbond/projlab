package vilagtalanvirologusok;


public class TestSkeleton {
    int succes = 0;
    int fail = 0;

    public TestSkeleton(){
        new Game();
        testVirologistMoveStreet();
        

        System.out.println("Test succeded: "+ succes);
        System.out.println("Test failed: "+ succes);
    }


    public void testVirologistMoveStreet() {
        Center s = new Street(0,0);
        Center s1 = new Street(50,50);
        Virologist v1 = new Virologist("alma",s);
        s1.AddVirologist(v1);
        s.RemoveVirologist(v1);
        if (s.virologists == null && s1.virologists != null) {
            succes++;
        } else  {
            fail++;
        }
    }

}

