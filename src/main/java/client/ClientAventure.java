package client;

import lectureEcritureFichier.LectureFichierTexte;
import modele.Aventure;
import modele.Scenario;

import java.io.File;

public class ClientAventure {
    public static void main(String[] args) {
        File fichier = new File( "scenario"+ File.separator + "scenario_0" + ".txt");
        Scenario s1 = LectureFichierTexte.lecture(fichier);
        Aventure a1 = new Aventure(s1);
        System.out.println(a1.niveau1(1));
    }
}
