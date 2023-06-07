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
        scenarioActualisé = parScenario.getProvQuete();
        queteDejaRealisee = new ArrayList<>();
        faireBoss = false;
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
                nouvellePosition = scenarioActualisé.get(i).getPosition();
                prochaineQuete = scenarioActualisé.get(i);
                minDeplacement = calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition());
            }
            // sinon cherche la quête la plus proche
            else if (calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition())< minDeplacement && preconditionsRemplies(scenarioActualisé.get(i),parJoueur) == true){
                nouvellePosition = scenarioActualisé.get(i).getPosition();
                prochaineQuete = scenarioActualisé.get(i);
                minDeplacement = calculDeplacement(parJoueur.getPosition(),scenarioActualisé.get(i).getPosition());
            }
        }
        parJoueur.setPosition(nouvellePosition);
        System.out.println("Le heros se deplace en : " + affichePosition(nouvellePosition));
        System.out.println("La prochaine quete de notre heros est la suivante : " + prochaineQuete.getIntitule());
        parJoueur.setNbDeplacement(minDeplacement);
        parJoueur.setTempsDeJeu(minDeplacement);
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
                if (assezExperimente(parJoueur) == true && faireBoss == true && accesQuete(parQuete, precond) == true) {
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
        if (parQuete.getNumero() != 0) {
            parJoueur.setExperience(parQuete.getExp());
            System.out.println("Le heros gagne " + parQuete.getExp() + " d'exp et possede desormais " + parJoueur.getExperience() + " points d'exp.");
        }
        parJoueur.setTempsDeJeu(parQuete.getDuree());
    }

    /**
     * Cette fonction affiche les quetes du scenario actualisé
     * @return un string
     */
    public String toString(){
        return "Voici les quêtes : " + scenarioActualisé + ".";
    }
}
