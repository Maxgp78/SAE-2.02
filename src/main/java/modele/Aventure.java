package modele;

import java.util.ArrayList;

/**
 * La classe Aventure permet au joueur de démrarrer une aventure.
 * Elle permet de dérouler l'aventure et de calculer les différentes solutions efficaces pu exhaustives.
 */
public class Aventure {
    //stocke le scenario avec les quêtes non réalisées
    private ArrayList<Quete> scenarioActualisé;
    //cette liste stocke les quetes deja réalisées
    private ArrayList<Integer> queteDejaRealisee;
    //Ce booléen permet de donner l'accès au boss selon le niveau et la solution demandée
    private boolean faireBoss;

    /**
     * Constructeur de la classe Aventure.
     * cette méthode permet de créer l'objet aventure contenant les quetes du scenario entré en parametre
     * @param parScenario un objet de type Scenario
     */
    public Aventure(Scenario parScenario){

    }

    /**
     * La méthode niveau1 permet de lancer une solution de type niveau1
     * si le paramètre entré est 1 alors il s'agit d'une solution gloutonne efficace
     * si le paramètre choisi est 2 alors il s'agit d'une solution gloutonne exhaustive
     * @param parChoix de type int
     * @return le champ queteDejaRealisee, soit la liste des quêtes réalisée durant l'aventure
     */
    public ArrayList<Integer> niveau1(int parChoix){

    }

    /**
     * La méthode finAventure renvoie un booleen :
     *  - true si l'aventure est finie, si la quête 0 a été réalisée
     *  - false si la quete 0 n'a pas été réalisée
     * @return un booléen
     */
    public boolean finAventure(){

    }

    /**
     * Cette méthode calcule le déplacement que le joueur doit effectué
     * en fonction des positions de départ et de fin entrés en paramètres
     * @param posDepart un tableau de 2 entiers
     * @param posFin un tableau de deux entiers
     * @return un entier équivalent à la distance entre les deux positions
     */
    public int calculDeplacement(int [] posDepart, int [] posFin){

    }

    /**
     * Cette méthode affiche la position actuelle du joueur
     * @param parPos un tableau de deux entiers
     * @return un string
     */
    public String affichePosition(int [] parPos){

    }

    /**
     * Cette méthode calcule la prochaine quête que le joueur doit réaliser grace à l'exp accumulés ou les quetes réalisées
     * elle utilise les méthodes pour le calcul de déplacement vers la prochaine quete ainsi que la vérification des préconditions
     * si la quete 0 peut être réalisée il l'effectue
     * sinon il calcule la quête la plus proche
     * @param parJoueur un objet de type Joueur
     * @return prochaineQuete, un objet de type quete, qui est la prochaine quete à réaliser
     */
    public Quete choixProchaineQuete(Joueur parJoueur){

    }

    /**
     * Cette méthode permet de comparer l'expérience du joueur parJoueur avec celle nécessaire pour la quête finale
     * si l'expérience de parJoueur est inférieure alors renvoie faux
     * si l'expérience de parJoueur est supérieure ou égale alors renvoie true
     * @param parJoueur un objet de type Joueur
     * @return un booléen
     */
    public boolean assezExperimente(Joueur parJoueur){

    }

    /**
     * Cette méthode permet de vérifier si les préconditions d'une quete sont bien respectées pour pouvoir la lancer
     * @param parQuete un objet de type Quete
     * @param parJoueur un objet de type Joueur
     * @return un booléen
     */
    public boolean preconditionsRemplies(Quete parQuete, Joueur parJoueur){

    }

    /**
     * Cette méthode permet de vérifier que le joueur a bien réalisée les quêtes nécessaires
     * elle est utilisée et appelée dans la méthode préconditionsRemplies
     * si les préconditions sont remplies renvoie true
     * sinon rencoie false
     * @param parQuete un objet de type Quete
     * @param parPrecon un objet de type Joueur
     * @return un booléen
     */
    public boolean accesQuete(Quete parQuete, int [] parPrecon){

    }

    /**
     * Cette méthode réalise la quete entrée en paramètre et l'ajoute aux quetes réalisées du joueur entré en paramètre
     * @param parQuete un objet de type Quete
     * @param parJoueur un objet de type Joueur
     */
    public void realisationQuete(Quete parQuete, Joueur parJoueur){

    }

    /**
     * Cette fonction affiche les quetes du scenario actualisé
     * @return un string
     */
    public String toString(){

    }
}
