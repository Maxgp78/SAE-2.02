package modele;

import java.util.ArrayList;

/**
 * Cette classe permet de créer l'objet Joueur. C'est ce joueur va effectuer des quetes.
 * C'est cet objet qui possède les données analytiques de l'aventure.
 */
public class Joueur {
    //stocke l'experience de joueur
    private int experience;
    //stocke la position du joueur
    private int [] position = new int[2];
    //stocke le temps de jeu du joueur
    private int tempsDeJeu;
    //stocke le nombre de déplacement du joueur
    private int nbDeplacement;

    /**
     * Il s'agit du constructeur de la classe Joueur. Un joueur contiendra plusieurs champs qui le définiront tels que :
     * - son experience
     * - sa position
     * - son temps de jeu
     * - son nombre de déplcement
     */
    public Joueur(){

    }

    /**
     * Cette méthode permet de modifier le champs : tempsDeJeu
     * @param parTemps un int
     */
    public void setTempsDeJeu(int parTemps){

    }

    /**
     * Cette méthode permet de modifier le champs : experience
     * @param parExp un int
     */
    public void setExperience(int parExp){

    }

    /**
     * Cette méthode permet de modifier le champs : ndDeplacement
     * @param parDeplacement un int
     */
    public void setNbDeplacement(int parDeplacement){

    }

    /**
     * Cette méthode permet de modifier le champs : position
     * @param parPosition un tableau d'int
     */
    public void setPosition(int [] parPosition){

    }

    /**
     * Cette méthode permet de récupérer le champs : position
     * @return un tableau d'int
     */
    public int [] getPosition(){

    }

    /**
     * Cette méthode permet de récupérer le champs : experience
     * @return un int
     */
    public int getExperience(){

    }
}
