import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


/**
 * Stocke une liste de mot issue d'un fichier texte
 * en filtrant les mots selon leur taille
 * et permet d'en choisir un aléatoirement
 */
public class Dictionnaire {

    private List<String> lesMots;
    private Random rand;

    /**
     * permet d'enlever les accents à un mot
     * @param mot le mot à traiter
     * @return le même mot mais sans accent
     */
    public static String sansAccents(String mot) {
        String normalized = Normalizer.normalize(mot, Normalizer.Form.NFD);
        return normalized.replaceAll("[\u0300-\u036F]", ""); 
    }

    /**
     * Constructeur qui lit un fichier de mot et retient ceux qui ont une longueur
     * comprise entre longMin et longMax
     * @param nomFichier est le chemin vers un fichier texte contenant une liste de mots
     *        (un mot par ligne)
     * @param longueurMinDesMots longueur minimale des mots retenus
     * @param longueurMaxDesMots longueur maximale des mots retenus
     */
    public Dictionnaire(String nomFichier, int longueurMinDesMots, int longueurMaxDesMots){
        BufferedReader lecteurAvecBuffer = null;
        String mot;
        this.lesMots = new ArrayList<String>();
        try{
            lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture du fichier " + nomFichier);
        }
        try{
            while ((mot = lecteurAvecBuffer.readLine()) != null){
                mot = sansAccents(mot).toUpperCase();
                int longueurDuMot = mot.length();
                if (mot.matches("([A-Z]|-)*")){
                    if (longueurDuMot >= longueurMinDesMots && longueurDuMot <= longueurMaxDesMots){
                        this.lesMots.add(mot);
                    }
                }
            }
            lecteurAvecBuffer.close();
        }
        catch (Exception e){
            System.out.println("Erreur de lecture dans le fichier " + nomFichier);
        }
        this.rand = new Random();
    }

    /**
     * choisit un mot au hasard dans le dictionnaire
     * @return le mot choisi
     */
    public String choisirMot(){
        int i = rand.nextInt(lesMots.size());
        return this.lesMots.get(i);
    }
}
