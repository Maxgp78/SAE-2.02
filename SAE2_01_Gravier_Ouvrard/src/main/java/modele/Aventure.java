package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * La classe Aventure permet au joueur de démrarrer une aventure.
 * Elle permet de dérouler l'aventure et de calculer les différentes solutions efficaces pu exhaustives.
 */
public class Aventure {
    private static ArrayList<Quete> scenarioFixe;
    //stocke le scenario avec les quêtes non réalisées
    private ArrayList<Quete> scenarioActualisé;
    //cette liste stocke les quetes deja réalisées
    private ArrayList<Integer> queteDejaRealisee;
    //Ce booléen permet de donner l'accès au boss selon le niveau et la solution demandée
    private boolean faireBoss;

    private ArrayList<ArrayList<Integer>> solutionPossible;

    /**
     * Constructeur de la classe Aventure.
     * cette méthode permet de créer l'objet aventure contenant les quetes du scenario entré en parametre
     * @param parScenario un objet de type Scenario
     */
    public Aventure(Scenario parScenario){
        scenarioFixe = new ArrayList<>();
        scenarioActualisé = parScenario.getProvQuete();
        queteDejaRealisee = new ArrayList<>();
        faireBoss = false;
        solutionPossible = new ArrayList<>();
    }

    /**
     * La méthode niveau1 permet de lancer une solution de type niveau1
     * si le paramètre entré est 1 alors il s'agit d'une solution gloutonne efficace
     * si le paramètre choisi est 2 alors il s'agit d'une solution gloutonne exhaustive
     * @param parChoix de type int
     * @return le champ queteDejaRealisee, soit la liste des quêtes réalisée durant l'aventure
     */
    public ArrayList<Integer> niveau1(int parChoix){
        Joueur joueur = new Joueur();
        System.out.println("L'aventure du heros commence !");
        //solution efficace
        if (parChoix == 1) {
            while (finAventure() != true) {
                if (assezExperimente(joueur) == true){
                    faireBoss = true;
                }
                realisationQuete(choixProchaineQuete(joueur),joueur);
            }
        }
        // solution exhaustive
        if (parChoix == 2){
            while (finAventure() != true){
                while (scenarioActualisé.size() != 1){
                    realisationQuete(choixProchaineQuete(joueur),joueur);
                }
                faireBoss = true;
                realisationQuete(choixProchaineQuete(joueur),joueur);
            }
        }
        System.out.println("Fin de l'aventure !");
        return queteDejaRealisee;
    }

    /**
     * Cette  méthode permet de lancer le niveau 2
     * @param parType un entier
     * @return une TreeMap
     */
    public TreeMap niveau2(int parType){
        Joueur joueur = new Joueur();
        copierScenario();
        ArrayList<ArrayList<Integer>> solutions = rechercheSolutions(new ArrayList<>(),joueur,scenarioFixe);
        TreeMap soluceTriées = trierSolutions(solutions,parType,joueur);
        //
        return soluceTriées;
    }

    /**
     * Cette méthode permet de trouver toutes les solutions d'une quête
     * @param parSolution une liste d'entier
     * @param parJoueur un objet de type Joueur
     * @param parScenario une liste de quete
     * @return une liste de liste
     */
    public ArrayList<ArrayList<Integer>> rechercheSolutions(ArrayList<Integer> parSolution, Joueur parJoueur, ArrayList<Quete> parScenario){
        for(Quete quete : parScenario){
            if (quete.getNumero() == 0){
                if (preconditionsRemplies(quete,parJoueur)){
                    realisationQuete(quete,parJoueur);
                    parSolution.add(quete.getNumero());
                    solutionPossible.add(copieSolution(parSolution));
                    parSolution.remove(parSolution.size()-1);
                    queteDejaRealisee.remove(parSolution.size());
                    scenarioActualisé.add(quete);
                }
            } else if (quete.testPrecon() == true || preconditionsRemplies(quete,parJoueur) == true && !queteDejaRealisee.contains(quete.getNumero())){
                realisationQuete(quete,parJoueur);
                parSolution.add(quete.getNumero());
                rechercheSolutions(parSolution,parJoueur,evolutionScenario());
                parSolution.remove(parSolution.size()-1);
                queteDejaRealisee.remove(parSolution.size());
                scenarioActualisé.add(quete);
                supprimerExp(parJoueur,quete);
            }
        }
        return solutionPossible;
    }

    /**
     * Cette méthode permet de trier les solutions
     * @param parSolutions une liste de liste
     * @param parType un int
     * @param parJoueur un objet joueur
     * @return un TreeMap
     */
    public TreeMap trierSolutions(ArrayList<ArrayList<Integer>> parSolutions, int parType, Joueur parJoueur){
        TreeMap<Integer,ArrayList<Integer>> classement = new TreeMap<>();
        for (int i = 0; i < parSolutions.size(); i++){
            int valeurInteret = 0;
            if (parType == 3) {
                valeurInteret = parSolutions.get(i).size();
            }
            else {
                for (int numQuete : parSolutions.get(i)) {
                    if (parType == 1)
                        valeurInteret += parJoueur.getTempsDeJeu();
                    if (parType == 2)
                        valeurInteret += parJoueur.getNbDeplacement();
                }
            }
            System.out.println("valeur " + parSolutions.get(i));
            classement.put(valeurInteret,parSolutions.get(i));
        }
        System.out.println(classement);
        return classement;
    }

    /**
     * Cette méthode permet de copier une solution
     * @param parSolution une liste d'int
     * @return une liste d'int
     */
    public ArrayList<Integer> copieSolution(ArrayList<Integer> parSolution){
        ArrayList<Integer> copieSol = new ArrayList<>();
        for (int numQuete : parSolution){
            copieSol.add(numQuete);
        }
        return copieSol;
    }

    /**
     * Cette méthode permet de copier un scenario afin de contourner les adressages
     */
    public void copierScenario(){
        for(Quete quete : scenarioActualisé){
            scenarioFixe.add(quete);
        }
    }

    /**
     * Cette méthode permet de supprimer l'xp d'une quête
     * @param parJoueur un objet de type Joueur
     * @param parQuete un objet Quete
     */
    public void supprimerExp(Joueur parJoueur, Quete parQuete){
        parJoueur.setExperience(/*parJoueur.getExperience()*/ - parQuete.getExp());
    }

    /**
     * Cette méthode permet de créer un scénario qui évolue au fur et à mesure du temps
     * @return une liste de Quete
     */
    public ArrayList evolutionScenario(){
        ArrayList<Quete> evolution = new ArrayList<>();
        for (Quete quete : scenarioActualisé){
            evolution.add(quete);
        }
        return evolution;
    }

    /**
     * La méthode finAventure renvoie un booleen :
     *  - true si l'aventure est finie, si la quête 0 a été réalisée
     *  - false si la quete 0 n'a pas été réalisée
     * @return un booléen
     */
    public boolean finAventure(){
        if (queteDejaRealisee != null) {
            for (int quete : queteDejaRealisee) {
                if (quete == 0)
                    return true;
            }
        }
        return false;
    }

    /**
     * Cette méthode calcule le déplacement que le joueur doit effectué
     * en fonction des positions de départ et de fin entrés en paramètres
     * @param posDepart un tableau de 2 entiers
     * @param posFin un tableau de deux entiers
     * @return un entier équivalent à la distance entre les deux positions
     */
    public int calculDeplacement(int [] posDepart, int [] posFin){
        return Math.abs(posFin[0]-posDepart[0]) + Math.abs(posFin[1]-posDepart[1]);
    }

    /**
     * Cette méthode affiche la position actuelle du joueur
     * @param parPos un tableau de deux entiers
     * @return un string
     */
    public String affichePosition(int [] parPos){
        int x = parPos[0];
        int y = parPos[1];
        return "[" + x + "," + y + "]";
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
        int minDeplacement = 1000;
        Quete prochaineQuete = new Quete();
        int [] nouvellePosition = new int[2];
        for (int i = 0; i< scenarioActualisé.size(); i++){
            // si les conditions pour réaliser la quête finale sont réalisées
            if (assezExperimente(parJoueur) == true && scenarioActualisé.get(i).getNumero() == 0 && preconditionsRemplies(scenarioActualisé.get(i),parJoueur) == true){
                prochaineQuete = scenarioActualisé.get(i);
                minDeplacement = calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition());
            }
            // sinon cherche la quête la plus proche
            else if (calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition())< minDeplacement && preconditionsRemplies(scenarioActualisé.get(i),parJoueur) == true){
                prochaineQuete = scenarioActualisé.get(i);
                minDeplacement = calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition());
            }
        }
        return prochaineQuete;
    }

    /**
     * Cette méthode permet de comparer l'expérience du joueur parJoueur avec celle nécessaire pour la quête finale
     * si l'expérience de parJoueur est inférieure alors renvoie faux
     * si l'expérience de parJoueur est supérieure ou égale alors renvoie true
     * @param parJoueur un objet de type Joueur
     * @return un booléen
     */
    public boolean assezExperimente(Joueur parJoueur){
        for (Quete quete : scenarioActualisé){
            if (quete.getNumero() == 0){
                if (parJoueur.getExperience() >= quete.getExp()){
                    faireBoss = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Cette méthode permet de vérifier si les préconditions d'une quete sont bien respectées pour pouvoir la lancer
     * @param parQuete un objet de type Quete
     * @param parJoueur un objet de type Joueur
     * @return un booléen
     */
    public boolean preconditionsRemplies(Quete parQuete, Joueur parJoueur){
        int [] precond = parQuete.getPrecondition();
        // si il n'y a pas de préconditions
        if (parQuete.testPrecon() == true) {
            return true;
        }
        else {
            // si la quête est la quête finale
            if (parQuete.getNumero() == 0){
                // si les préconditions sont respectées pour la quête 0
                if (assezExperimente(parJoueur) == true && accesQuete(parQuete, precond) == true) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                // si la quête parQuete respecte les préconditions
                if (accesQuete(parQuete, precond) == true) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * Cette méthode permet de vérifier que le joueur a bien réalisée les quêtes nécessaires
     * elle est utilisée et appelée dans la méthode préconditionsRemplies
     * si les préconditions sont remplies renvoie true
     * sinon renvoie false
     * @param parQuete un objet de type Quete
     * @param parPrecon un objet de type Joueur
     * @return un booléen
     */
    public boolean accesQuete(Quete parQuete, int [] parPrecon){
        if ((queteDejaRealisee.contains(parPrecon[0]) && parPrecon[0] != 0) || (queteDejaRealisee.contains(parPrecon[1]) && parPrecon[1] != 0)) {
            if (((queteDejaRealisee.contains(parPrecon[2]) && parPrecon[2] != 0) || (queteDejaRealisee.contains(parPrecon[3]) && parPrecon[3] != 0)) || (parPrecon[2] == 0 && parPrecon[3] == 0)){
                return true;
            }
        }
        return false;
    }

    /**
     * Cette méthode réalise la quete entrée en paramètre et l'ajoute aux quetes réalisées du joueur entré en paramètre
     * @param parQuete un objet de type Quete
     * @param parJoueur un objet de type Joueur
     */
    public void realisationQuete(Quete parQuete, Joueur parJoueur){
        scenarioActualisé.remove(parQuete);
        queteDejaRealisee.add(parQuete.getNumero());
        parJoueur.setNbDeplacement(calculDeplacement(parJoueur.getPosition(),parQuete.getPosition()));
        parJoueur.setPosition(parQuete.getPosition());
        System.out.println("Le heros se deplace en : " + affichePosition(parQuete.getPosition()));
        System.out.println("La prochaine quete de notre heros est la suivante : " + parQuete.getIntitule());
        if (parQuete.getNumero() != 0) {
            parJoueur.setExperience(parQuete.getExp());
            System.out.println("Le heros gagne " + parQuete.getExp() + " d'exp et possede desormais " + parJoueur.getExperience() + " points d'exp.");
        }
        parJoueur.setTempsDeJeu(parQuete.getDuree());
    }

    public ArrayList<Quete> getScenarioFixe(){
        return scenarioFixe;
    }

    /**
     * Cette fonction affiche les quetes du scenario actualisé
     * @return un string
     */
    public String toString(){
        return "Voici les quêtes : " + scenarioActualisé + ".";
    }
}
