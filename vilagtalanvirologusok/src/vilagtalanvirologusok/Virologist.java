package vilagtalanvirologusok;

import java.io.Serializable;
import java.util.*;

/**
 * A játékos és a számítógép által irányított karakterek ősosztálya,
 * amik a pályán mozognak és genetikai kódokat gyűjtenek.
 */
public class Virologist implements Steppable, Serializable {

    private boolean dead;
    private Center location;
    private Turnable turnable;
    private ArrayList<Material> materials;
    private ArrayList<GeneticCode> geneticCodes;
    private ArrayList<Equipment> equipments;
    private ArrayList<Agent> activeAgents;
    private ArrayList<Agent> knownAgents;
    private String name;



    Virologist(String name, Center location)
    {
        dead=false;
        materials = new ArrayList<Material>();
        geneticCodes = new ArrayList<GeneticCode>();
        equipments = new ArrayList<Equipment>();
        activeAgents = new ArrayList<Agent>();
        knownAgents = new ArrayList<Agent>();
        this.name = name;
        this.location = location;
    }


    public void Kill(Virologist virologist)
    {
        EquipmentVisitor equipmentVisitor = new EquipmentVisitor();
        for (Equipment e : equipments)
        {
            e.accept(equipmentVisitor,virologist);
        }
    }


    /**
     * A megérintést valósítja meg a játékban. Az adott virológus GetTouched() függvényét valósítja meg.
     * @param v - Megérintett virológus.
     * @param a - Ágens, amellyel megérintik.
     */
    public void Touch(Virologist v, Agent a)
    {
        v.GetTouched(this,a);
    }

    /**
     *  Amikor egy virológust megérintenek ez a metódus hajtja végre az ágens hatását,
     *  ha nincs olyan felszerelése vagy a virológusra ható ágens ami ezt megakadályozza.
     * @param a - Ágens, amellyel megérintik a Virológust.
     */
    public void GetTouched(Virologist v,Agent a){

        EquipmentVisitor equipmentVisitor = new EquipmentVisitor();
        AgentVisitor agentVisitor = new AgentVisitor();
        //le kell csekkolni van e protector vaccine
        boolean success=true;
        for (Agent agent : activeAgents)
        {
           if(agent.acceptProtector(agentVisitor,v))
           {
               success=false;
               break;
           }
        }



        for (Equipment e : equipments)
        {
            if(e.accept(equipmentVisitor,v,a))
            {
                success=false;
                break;
            }
        }
        if (success)
        {
            ApplyAgent(a);
        }



    }

    /**
     * Megvalósítja a Steppable interfészt.
     */
    public void Step(){

        for (Agent a: activeAgents)
        {
            a.Step();
        }
        RemoveAgent();
    }

    /**
     * A laborokban található genetikai kódok közül a
     * megfelelőt megtanítja a virológusnak ezzel közelebb kerül a
     * győzelemhez és egy új ágens elkészítését teszi lehetővé.
     * @param g - Genetik kód, amit a virológus megtanulhat.
     */
    public void LearnGeneticCode(GeneticCode g)
    {
        geneticCodes.add(g);
    }

    /**
     *  Ha ugyan azon a mezőn, amin a játékos áll van egy lebénult virológus,
     *  akkor ennek a metódusnak a segítségével tudja elvenni valamelyik felszerelését tőle.
     * @param v - Virológus, akitől el lehet lopni a felszerelését.
     */
    public void StealEquipment(Virologist v)
    {
       v.RemoveEquipment(this);
    }


    public ArrayList<Equipment> getEquipments()
    {
        return equipments;
    }

    public ArrayList<GeneticCode> getGeneticCode()
    {
        return geneticCodes;
    }

    public Turnable getTurnable()
    {
        return this.turnable;
    }

    public Center getLocation()
    {
        return this.location;
    }

    /**
     *  Hozzáad egy tárgyat a virológushoz ha korábban nem rendelkezett azzal.
     * @param  - A felvehető tárgy.
     */
    public void PickupEquipment(Equipment e)
    {
        if(equipments.size()<3)
        {
            equipments.add(e);
        }

    }

    public void DropEquipment(Equipment e)
    {
        equipments.remove(e);
    }


    /**
     * Ez a metódus távolítja el a virológus egyik felszerelését, amit elvesznek tőle.
     * @param  - Eltávolítandó felszerelés.
     */
    public void RemoveEquipment(Virologist virologist)
    {
        AgentVisitor agentVisitor= new AgentVisitor();
        //csekkolni hogy le van e bénulva
        for (Agent agent:activeAgents)
        {
            if(agent.acceptParalyze(agentVisitor,this))
            {
                int n = new Random().nextInt(equipments.size());
                Equipment eq = equipments.get(n);
                virologist.PickupEquipment(eq);
            }




        }
    }

    /**
     * Megfelelő mennyiségű ágens felhasználásával létrehoz egy ágenst.
     * Meghivja a UseMaterial() függvényt, ami ellenőrzi, hogy rendelkezésre
     * áll-e megfelelő mennyiségű material, majd meghívja a removeMaterialt() megfelelő mennyiségre.
     * @param  - Ágens amivel létrehoz egy másikat.
     */
    public void CraftAgent(GeneticCode geneticCode)
    {
        geneticCode.Create(this);

    }

    /**
     * Saját magára keni fel a virológus a kiválasztott ágenst.
     * @param a - Ágens amit magára ken.
     */
    public void ApplyAgent(Agent a)
    {
        activeAgents.add(a);
    }

    /**
     * A step() metódus meghívására kitöröl minden olyan ágenst aminek a lifetimeja 0.
     */
    public void RemoveAgent()
    {
        for (int i=0;i<activeAgents.size();i++)
        {
            if (activeAgents.get(i).getLifetime()==0)
            {
                activeAgents.remove(i);
                i--;
            }
        }
    }

    /**
     * a Virologist osztály mozgását valósítja meg.
     * Először lekéri a szomszédos mezőket majd a játékos kiválasztja hova szeretne lépni
     * és meghívja a RemoveVirologist(v: Virologist) a mezőre amin áll majd a
     * AddVirologist(v: Virologist) a mezőre amire lépni szeretne.
     */
    public void Move(){
        //System.out.println("Virologist: Move()");
        for (int i=0;i<location.GetNeighbours().size();i++) {
            System.out.println(i + ": " + location.GetNeighbours().get(i).toString());
        }
        System.out.println("Which neighbour location do you want leave? Please give the number");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        Center nextloc = location.neighbours.get(Integer.parseInt(inputString));
        nextloc.AddVirologist(this);
        location.RemoveVirologist(this);

        this.location = nextloc;
    }

    /**
     * Ellenőrzi, hogy a virológus rendelkezik-e a megfelelő mennyiségű materiallal.
     * @param m - Az anyagok listája.
     * @return
     */
    public boolean UseMaterial(ArrayList<Material> m){

        int aminoacid = 0;
        int nucleotide = 0;
        int am = 0;
        int nuc = 0;

        for (Material mat : materials) {
            if (mat.getClass().getName().compareTo("vilagtalanvirologusok.Nucleotide") == 0) {
                nucleotide++;
            }

            if (mat.getClass().getName().compareTo("vilagtalanvirologusok.Aminoacid") == 0) {
                aminoacid++;
            }
        }

        for (Material mat : m) {
            if (mat.getClass().getName().compareTo("vilagtalanvirologusok.Nucleotide") == 0) {
                nuc++;
            }

            if (mat.getClass().getName().compareTo("vilagtalanvirologusok.Aminoacid") == 0) {
                am++;
            }
        }


        int nucdeleted = 0;
        int amdeleted = 0;
        if (nucleotide >= nuc && aminoacid >= am) {
            for (int i = 0; i < materials.size(); i++) {
                if (materials.get(i).getClass().getName().compareTo("vilagtalanvirologusok.Nucleotide") == 0) {
                    materials.remove(i);
                    i--;
                    nucdeleted++;
                    if (nucdeleted == nuc) {
                        break;
                    }
                }
            }
            for (int j = 0; j < materials.size(); j++) {
                if (materials.get(j).getClass().getName().compareTo("vilagtalanvirologusok.Aminoacid") == 0) {
                    materials.remove(j);
                    j--;
                    amdeleted++;
                    if (amdeleted == am) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Adott anyag mennyiséget ad hozzá, ha a táskája vagy a virológus képes azt eltárolni.
     * @param m - Anyag, amit a Virológus felvehet.
     * @return - Van hely a Virológusnál és feltudja venni vagy sem.
     */
    public boolean PickupMaterial(Material m){

        EquipmentVisitor equipmentVisitor = new EquipmentVisitor();


        if(materials.size()<10)
        {
            materials.add(m);
            return true;
        }
        else
        {
            boolean success=false;
            for (Equipment e: equipments)
            {
               success= e.accept(equipmentVisitor,m);
               if(success)
               {
                   return true;
               }
            }
            return false;

        }

    }

    /**
     * Adott anyagot töröl.
     * @param m - Törölni kívánt anyag.
     */
    public void RemoveMaterial(Material m)
    {
        materials.remove(m);
    }

    public void Die()
    {
        dead=true;
    }

    public void learnAgent(Agent agent)
    {
        knownAgents.add(agent);
    }




    public ArrayList<Agent> getActiveAgents()
    {
        return activeAgents;
    }
    public ArrayList<Material> getMaterials() { return materials; }
    public String getName() { return name; }
    public String getPos() {return location.getName();}
    public boolean infected() { return false; } // TODO visitor
    public ArrayList<Agent> getKnownAgents() { return knownAgents; }

    @Override
    public String toString() {
        return this.getName() + "\n\tPosition: " + this.getPos() +
                "\n\tInfected: " + this.infected() +
                "\n\tEquipments: " + this.getEquipments().toString() +
                "\n\tAgents: " + this.getKnownAgents().toString() +
                "\n\tMaterials: " + this.getMaterials().toString() + "\n\n";
    }


}
