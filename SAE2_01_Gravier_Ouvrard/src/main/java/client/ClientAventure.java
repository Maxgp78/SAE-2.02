package client;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Aventure;
import modele.Joueur;
import modele.Scenario;

import java.io.File;
import java.util.ArrayList;

public class ClientAventure {
    public static void main(String[] args) {
        File fichier = new File( "scenario"+ File.separator + "scenario_0" + ".txt");
        Scenario s1 = LectureFichierTexte.lecture(fichier);
        Aventure a1 = new Aventure(s1);
        Joueur j1 = new Joueur();
        //System.out.println(a1.niveau1(1));
        //a1.copierScenario();
        //System.out.println(a1.rechercheSolutions(new ArrayList<>(),j1,a1.getScenarioFixe()));
        System.out.println(a1.niveau2(3));
    }
}
