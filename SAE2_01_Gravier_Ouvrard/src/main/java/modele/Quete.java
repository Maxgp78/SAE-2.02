package modele;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cette classe permet de créer des quetes à partir des scenarios
 */
public class Quete {
    //stocke le numero de la quete
    int numero;

    //stocke les coordonnées de la quete sur la carte
    int [] position;

    //stocke les quetes qu'il faut finir avec de pouvoir commencer celle-ci
    int [] precondition;

    //stocke la duree de la quete
    int duree;

    //stocke l'experience que donne la quête ou pour la quête 0, l'xp nécessaire pour la réaliser
    int exp;
    //stocke le nom de la quete
    String intitule;

    /**
     * Le constructeur de la classe Quete prend en parametre une ligne d'un fichier scenario
     * puis instancie à chaque champs les valeurs décrites dans la ligne en parametre
     * @param ligne un string
     */
    public Quete(String ligne){
        Scanner scanner = new Scanner(ligne).useDelimiter("\\|");
        while(scanner.hasNext()) {
            this.numero = scanner.nextInt();
            String pos = scanner.next();
            //extraction de la position
            position = new int [2];
            pos = pos.replace("(","");
            pos = pos.replace(")","");
            pos = pos.replace(" ","");
            Scanner scanPos = new Scanner(pos).useDelimiter(",");
            int i = 0;
            while(scanPos.hasNext()){
                String morceau = scanPos.next();
                position[i] = Integer.parseInt(morceau);
                i++;
            }

            String precond = scanner.next();
            //extraction de la precondition
            precondition = new int [4];
            precond = precond.replace("(","");
            precond = precond.replace(")","");
            precond = precond.replace(" ","");
            Scanner scanPrecondition = new Scanner(precond).useDelimiter(",");
            int j = 0;
            while (scanPrecondition.hasNext()){
                String extrait = scanPrecondition.next();
                if (! extrait.equals(""))
                    precondition[j] = Integer.parseInt(extrait);
                j++;
            }

            this.duree = scanner.nextInt();
            this.exp = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }

    /**
     * Un constructeur vide qui permet de créer une Quete temporaire dans la classe Aventure
     */
    public Quete(){
    }

    /**
     * Cette méthode vérifie si la quete ne nécessite pas de precondition
     * si la quête a des préconditions différentes de 0 renvoie false
     * sinon renvoie true
     * @return boolean
     */
    public boolean testPrecon (){
        for (int pre : precondition){
            if (pre != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ precondition
     * @return un tableau d'int
     */
    public int [] getPrecondition(){
        return precondition;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ intitule
     * @return un string
     */
    public String getIntitule(){
        return intitule;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ position
     * @return un tableau d'int
     */
    public int [] getPosition(){
        return position;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ numero
     * @return un int
     */
    public int getNumero(){
        return numero;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ exp
     * @return un int
     */
    public int getExp(){
        return exp;
    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ duree
     * @return un int
     */
    public int getDuree(){
        return duree;
    }

    /**
     * cette méthode permet d'afficher une quete en chaine de caractère
     * @return String
     */
    public String toString() {
        return numero + "," + Arrays.toString(position) + "," + Arrays.toString(precondition) + "," + duree + "," + exp + "," + intitule;
    }
}
