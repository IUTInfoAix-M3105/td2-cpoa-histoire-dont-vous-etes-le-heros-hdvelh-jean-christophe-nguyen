/**
 * File: ScenarioDG.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

/**
 * @author prost
 *
 */
public class Scenario {
    private static final String MSG_EMPTY_SCENARIO = "Sorry, no scenario was found.";
    private static final String MSG_FINALE = "That's all folks!";
    private Event head;
    private GUIManager gui;


    public Scenario(GUIManager gui, Event head){
    this.gui = gui;
    this.head = head;
    }

    /**
     * @return first event
     */
    public Event getHead() {
        return head;
    }

    /**
     * @return gui
     */
    public GUIManager getGui() {
        return gui;
    }

    /**
     * @param head
     */
    public void setHead(Event head) {
        this.head = head;
    }

    /**
     * @param gui
     */
    public void setGui(GUIManager gui) {
        this.gui = gui;
    }

    public String run(){
        if(head == null)return MSG_EMPTY_SCENARIO;
        while(true) {
            head = head.run();
            if(head == null)return MSG_EMPTY_SCENARIO;
            if(!head.hasDaughters()){
                gui.output(head.getData());
                return MSG_FINALE;
            }
        }
    }

    /* MAIN */
    public static void main(String[] args) {
        Scenario scenario;
        GUIManager gui = new GUIManager(System.in, System.out, System.err);


        // S
        // *1:event1
        // **1.1
        // ***S
        // **1.2
        // ***E
        // *2:event2
        // **2.1
        // ***1
        // **2.2
        // ***S

        Event e0 = new Event(gui,"Vous êtes Darius, le chasseur le plus renommé de la contrée.\n Un soir, on vous appelle car une créature a attaqué un paysan lui laissant de grosses séquelles.\n On vous dirige vers les lieux de l'attaque.\n En arrivant sur les lieux, vous remarquez qu'il y a des empreintes étranges dans la boue.\n La chasse commence. Où choisissez-vous d'aller?"
                + "\nSuivre le chemin boueux 2\n"
                + "Suivre la route pavée 1 \n");

        Event e1 =new Event(gui,"Après quelques mètres de marche, vous arrivez devant une intersection, il y a un panneau qui indique deux directions.\n L'une indique \"VILLAGE DE SALERS\" et l'autre indique \"FORET DE SOURDAN\".\n Quelle direction choisissez-vous ? \n"
                +"Se rendre à la FORET DE SOURDAN 2 \n"
                +"Se rendre au VILLAGE DE SALERS3\n");

        Event e3 = new Event(gui,"Bienvenue à Salers !, c'est un petit village où il fait bon vivre.\n A cette heure-ci, tous les villageois sont chez eux, les rues sont désertes.\n Il n'y a pas grand-chose à faire ici. Depuis le village, on peut rejoindre la FORET DE SOURDAN.\n" +
                "Allez à la FORET DE SOURDAN 2 \n");

        Event e2 = new Event(gui,"Vous arrivez devant l'immense et dense FORET DE SOURDAN, celle-ci regorge d'arbres épineux et de buissons aux feuilles tranchantes.\n Il est impossible pour vous de la traverser.Vous distinguez d'un côté un petit chemin qui longe la forêt et de l'autre côté au loin, vous apercevez de la lumière qui semble provenir d'un village.\n Sur le chemin pour se rendre au village se dresse une silhouette d'un homme. Que voulez-vous faire?\n" +
                "Allez au village 3\n" +
                "Allez parler à l'homme 5\n" +
                "Suivre le petit chemin 4\n");

        Event e4 = new Event(gui,"Vous arrivez dans une GROTTE, vous entendez un bruit, il fait sombre et la lumière se fait absente.\n Néanmoins, la lumière de la lune éclaire brièvement une sorte de brèche dans laquelle on peut s'y glisser.\n Que choisissez-vous de faire?\n" +
                "\n" +
                "Faire demi-tour et retourner vers la FORET DE SOURDAN 2\n" +
                "Traverser la brèche 4\n" +
                "Allez vers le bruit 6\n");
        Event e5 = new Event(gui,"Vous faites la connaissance d'un MENDIANT prénommé Sannur, celui-ci à des informations à vous donner quant au potentiel lieu où se trouve la bête mais celui-ci ne dévoilera ce qu'il sait que si vous gagnez au jeu des dés.\n Si vous perdez, vous lui devrez une pièce d'or. Que voulez-vous faire ?\n" +
                "JEU ALEATOIRE (Si vous gagnez allez en 4)\n" +
                "Refuser son offre et allez au village 3\n" +
                "Refuser son offre et suivre le petit chemin qui longe la FORET4\n");
        Event e6 = new Event(gui,"Les bruits ne cessent de devenir de plus en plus fort lorsque soudain..., Une boule de feu émane brusquement devant vous.\n Vous arrivez à l'esquiver, une source de lumière prend alors vie dans la grotte. Vous arrivez nettement distinguer une forme.\n C'EST LA BETE !. Il ne vous reste plus qu'à la vaincre ! \n");
        e0.setDaughter(e2,2);
        e0.setDaughter(e1,1);
        e1.setDaughter(e2,2);
        e1.setDaughter(e3,3);
        e3.setDaughter(e2,2);
        e2.setDaughter(e3,3);
        e2.setDaughter(e5,5);
        e2.setDaughter(e4,4);
        e4.setDaughter(e2,2);
        e4.setDaughter(e4,4);
        e4.setDaughter(e6,6);
        e5.setDaughter(e4,4);
        e5.setDaughter(e3,3);
        e5.setDaughter(e4,4);
		/*
		Event startEvent = new Event(gui, "Go!\n" + "(1)1 (2)2");
		Event event1 = new Event(gui, "event1:\n" + "(1)1.1 (2)1.2");
		Event event2 = new Event(gui, "event2:\n" + "(1)2.1 (2)2.2");
		Event endEvent = new Event(gui, "End event: that's it :-)");
		startEvent.addDaughter(event1);
		startEvent.setDaughter(event2, 1);
		event1.addDaughter(startEvent);
		event1.addDaughter(endEvent);
		event2.addDaughter(event1);
		event2.addDaughter(startEvent);
		scenario = new Scenario(gui, startEvent);
		*/
        // *2
        // ...
        // **2.3:event3
        // ***E
        // ***event3

		/*Event event3 = new EventExactSolution(gui, "Wizard: how much is worth pi?", "3.14159");
		event2.setData(event2.getData() + " (3)2.3");
		event2.addDaughter(event3);
		event3.addDaughter(endEvent);
		event3.addDaughter(event3);*/

        /* ******* */
        // **2.3
        // ***event4
        // ****event2
        // ****E
        // ****event3
        // ...

        int[] mask = { 3, 6, 7 };
		/*Event event4 = new EventRandomSolution(gui, "Random choice of the next event...", mask, "Dice rolling... Roll=",
				"\nNext event is ");
		event3.setDaughter(event4, 0);
		event4.addDaughter(event2);
		event4.addDaughter(endEvent);
		event4.addDaughter(event3);*/
        scenario = new Scenario(gui, e0);
        System.out.println(scenario.run());
    }
}

// eof

