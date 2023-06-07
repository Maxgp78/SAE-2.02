package lectureEcritureFichier;

import modele.Quete;
import modele.Scenario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Cette classe permet de lire les différents scenarios à l'aide de la classe Scenario
 */
public class LectureFichierTexte {

    /**
     * Cette méthode parcours le dossier scenario et créer l'objet scenario
     * @param fichier un objet de type File
     * @return un objet de type Scenario
     */
    public static Scenario lecture (File fichier){
        Scenario scenario = new Scenario();
        try{
            Scanner scanner = new Scanner(fichier);
            while(scanner.hasNext()){
                scenario.ajout(new Quete(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return scenario;
    }
}
