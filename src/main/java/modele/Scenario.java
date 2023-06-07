package modele;

import lectureEcritureFichier.LectureFichierTexte;

import java.util.ArrayList;

/**
 * Cette classe permet de créer les objets scenarios à partir des scenarios stockés dans le repertoire
 * /scenario
 * Elle hérite de la classe LectureFichierTexte
 */
public class  Scenario extends LectureFichierTexte {

    //permet de stocker les différentes quetes d'un scenario
    ArrayList <Quete> provQuete;

    /**
     * Le constructeur de la classe Scenario, elle permet d'instancier le champ provQuete
     */
    public Scenario(){

    }

    /** Cette méthode ajoute le paramètre de type quete à l'objet appelant
     * @param quete, un objet Quete
     */
    public void ajout(Quete quete){

    }

    /**
     * Cette méthode permet d'accéder au champ provQuete de la classe
     * @return une ArrayList de Quete
     */
    public ArrayList <Quete> getProvQuete(){

    }

    /**
     * Cette méthode permet d'afficher les scenarios en chaine de caractère ainsi que la taille
     * @return String;
     */
    public String toString() {

    }
}
