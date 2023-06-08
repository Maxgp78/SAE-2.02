package modele;

import lectureEcritureFichier.LectureFichierTexte;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AventureTest {

    File fichier = new File( "scenario"+ File.separator + "scenario_0" + ".txt");
    Scenario s1 = LectureFichierTexte.lecture(fichier);
    Aventure a1 = new Aventure(s1);
    Joueur j1 = new Joueur();

    @Test
    void niveau1() {
    }

    int [] posFin = new int[2];
    int [] posDebut = new int[2];
    @Test
    void calculDeplacement() {
        System.out.println("calcul déplacement");
        posFin[0] = 5;
        posFin[1] = 5;
        posDebut[0] = 10;
        posDebut[1] = 15;
        assert (a1.calculDeplacement(posDebut,posFin) > 0);
        posFin[0] = 15;
        posFin[1] = 30;
        assert (a1.calculDeplacement(posDebut,posFin) > 0);
        posDebut[0] = 15;
        posDebut[1] = 30;
        assertEquals(a1.calculDeplacement(posDebut,posFin), 0);
    }


    Quete q1 = new Quete("1|(4, 3)|()|2|100|explorer pic de Bhanborim");
    Quete q2 = new Quete("0|(1,1)|((3,4),)|4|350|vaincre Araignée lunaire");

    @Test
    void preconditionsRemplies() {
        System.out.println("preconditions remplies");
        assertTrue(a1.preconditionsRemplies(q1, j1));
        assertFalse(a1.preconditionsRemplies(q2,j1));
    }

}