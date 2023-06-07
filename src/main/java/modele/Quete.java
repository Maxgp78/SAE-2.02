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

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ precondition
     * @return un tableau d'int
     */
    public int [] getPrecondition(){

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ intitule
     * @return un string
     */
    public String getIntitule(){

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ position
     * @return un tableau d'int
     */
    public int [] getPosition(){

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ numero
     * @return un int
     */
    public int getNumero(){

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ exp
     * @return un int
     */
    public int getExp(){

    }

    /**
     * Cette méthode permet de récupérer la valeur dans le champ duree
     * @return un int
     */
    public int getDuree(){

    }

    /**
     * cette méthode permet d'afficher une quete en chaine de caractère
     * @return String
     */
    public String toString() {

    }
}
