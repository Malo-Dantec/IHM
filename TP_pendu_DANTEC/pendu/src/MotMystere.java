import java.util.Set;
import java.util.HashSet;

/**
 * Modèle pour le jeu du pendu.
 */
public class MotMystere {
    // constantes pour gérer les différents niveaux de jeu
    /** Niveau FACILE : la première lettre et la dernière lettre du mot à trouver sont données ainsi que les éventuels caractères non alphabétiques (traits d'union par exemple)*/
    public final static int FACILE = 0;
    /** Niveau MOYEN : la première lettre du mot à trouver est donnée ainsi que les traits d'union si le mot à trouver en comporte */
    public final static int MOYEN = 1;
    /** Niveau DIFFICILE : seuls les traits d'union si le mot à trouver en comporte */
    public final static int DIFFICILE = 2;
    /** Niveau EXPERT : rien n'est donné, ni lettre ni trait d'union */
    public final static int EXPERT = 3;
   

    /**
     * le mot à trouver
     */
    private String motATrouver;
    /**
     * le niveau de jeu
     */
    private int niveau;
    /**
     * chaine contenant les lettres déjà trouvées et des * à la place des lettres non encore trouvées
     */
    private String motCrypte;
    /**
     * chaine contenant l'ensemble des lettres déjà essayées
     */
    private Set<String> lettresEssayees;
    /**
     * entier inquant le nombre de lettres restant à trouver
     */
    private int nbLettresRestantes;
    /**
     * le nombre d'essais déjà effectués
     */
    private int nbEssais;
    /**
     * le nombre d'erreurs encore possibles
     */
    private int nbErreursRestantes;
    /**
     * le nombre total de tentatives autorisées
     */
    private int nbEerreursMax;
    /**
     * dictionnaire dans lequel on choisit les mots
     */
    private Dictionnaire dict;


    /**
     * constructeur dans lequel on impose le mot à trouver
     * @param motATrouve mot à trouver
     * @param niveau niveau du jeu
     * @param nbErreursMax le nombre total d'essais autorisés
     */
    public MotMystere(String motATrouver, int niveau, int nbErreursMax) {
        super();
        this.initMotMystere(motATrouver, niveau, nbErreursMax);
    }

    /**
     * Constructeur dans lequel on va initialiser un dictionnaire pour choisir les mots à trouver
     * @param nomFichier est le chemin vers le dictionnaire utilisé qui est un fichier texte
     *  contenant une liste de mots (un mot par ligne)
     * @param longMin longueur minimale des mots retenus dans le dictionnaire
     * @param longMax longueur maximale des mots retenus dans le dictionnaire
     * @param niveau niveau initial de jeu
     * @param nbErreursMax le nombre total d'essais autorisés
     */
    public MotMystere(String nomFichier, int longMin, int longMax, int niveau, int nbErreursMax) {
        super();
        this.dict = new Dictionnaire(nomFichier,longMin,longMax);
        String motATrouver = dict.choisirMot();
        this.initMotMystere(motATrouver, niveau, nbErreursMax);
        
    }

    /**
     * initialisation du jeu
     * @param motATrouver le mot à trouver
     * @param niveau le niveau de jeu
     * @param nbErreursMax  le nombre total d'essais autorisés
     */
    private void initMotMystere(String motATrouver, int niveau, int nbErreursMax){
        this.niveau =niveau;
        this.nbEssais=0;
        this.motATrouver = Dictionnaire.sansAccents(motATrouver).toUpperCase();
        this.motCrypte = "";
        this.lettresEssayees = new HashSet<>();

        nbLettresRestantes=0;
        
        if (niveau == MotMystere.EXPERT || niveau == MotMystere.DIFFICILE){
            motCrypte = "*"; // premiere lettre cachée
            this.nbLettresRestantes+=1;
        }
        else{
            motCrypte += this.motATrouver.charAt(0); // premiere lettre révélée
        }
        
        for (int i=1; i<motATrouver.length()-1; i++){
            char lettre = this.motATrouver.charAt(i);
            if (this.niveau == MotMystere.EXPERT || Character.isAlphabetic(lettre)){
                motCrypte += "*"; // lettre cachée
                this.nbLettresRestantes += 1;
            }   
            else{
                motCrypte += lettre; // lettre révélée si c'est un trait d'union ET qu'on n'est pas en mode Expert
            }
        }
        
        if (niveau != MotMystere.FACILE){ // dernière lettre révélée
            motCrypte += "*";
            this.nbLettresRestantes += 1;
        }
        else{
            motCrypte += this.motATrouver.charAt(motATrouver.length()-1);
            // dernière lettre cachée
        }
        this.nbEerreursMax = nbErreursMax;
         this.nbErreursRestantes = nbErreursMax;
    }

    /**
     * @return le mot à trouver
     */
    public String getMotATrouve() {
        return this.motATrouver;
    }

    /**
     * @return le niveau de jeu
     */
    public int getNiveau(){
        return this.niveau;
    }

    /** réinitialise le jeu avec un nouveau à trouver
     * @param motATrouver le nouveau mot à trouver
     */
    public void setMotATrouver(String motATrouver) {
        this.initMotMystere(motATrouver, this.niveau, this.nbEerreursMax);
    }

    /**
     * Réinitialise le jeu avec un nouveau mot à trouver choisi au hasard dans le dictionnaire
     */
    public void setMotATrouver() {
        this.initMotMystere(this.dict.choisirMot(), this.niveau, this.nbEerreursMax);
    }

    /**
     * change le niveau de jeu (n'a pas d'effet en cours de partie)
     * @param niveau le nouveau niveu de jeu
     */
    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    /**
     * @return le mot avec les lettres trouvées affichées et des étoiles pour les lettres non trouvées
     */
    public String getMotCrypte() {
        return this.motCrypte;
    }

    /**
     * @return les lettres déjà essayées
     */
    public Set<String> getLettresEssayees() {
        return this.lettresEssayees;
    }

    /**
     * @return le nombre de lettres restant à trouver
     */
    public int getNbLettresRestantes() {
        return this.nbLettresRestantes;
    }

    /**
     * @return le nombre d'essais déjà effectués
     */
    public int getNbEssais(){
        return this.nbEssais;
    }

    /**
     * @return le nombre total de tentatives autorisées
     */
    public int getNbErreursMax(){
        return this.nbEerreursMax;
    }

    /**
     * @return le nombre d'erreurs encore autorisées
     */
    public int getNbErreursRestants(){
        return this.nbErreursRestantes;
    }

    /**
     * @return un booléen indiquant si le joueur a perdu
     */
    public boolean perdu(){
        return this.nbErreursRestantes == 0;
    }

    /**
     * @return un booléen indiquant si le joueur a gangé
     */
    public boolean gagne(){
        return this.nbLettresRestantes == 0;
    }

    /**
     * permet au joueur d'essayer une lettre
     * @param lettre la lettre essayée par le joueur
     * @return le nombre de fois où la lettre apparait dans le mot à trouver
     */
    public int essaiLettre(char lettre){
        int nbNouvelles = 0;
        char[] aux = this.motCrypte.toCharArray();
        for (int i=0; i<this.motATrouver.length(); i++){
            if (this.motATrouver.charAt(i) == lettre && this.motCrypte.charAt(i) == '*'){
                nbNouvelles += 1;
                aux[i] = lettre;
            }
        }
        this.motCrypte = String.valueOf(aux);
        this.nbLettresRestantes -= nbNouvelles;
        this.lettresEssayees.add(lettre+"");
        // Le nombre d'essais augmente de 1
        this.nbEssais += 1;
        // Si aucune lettre n'a été trouvée, le nombre d'erreurs restante diminue de 1
        if (nbNouvelles == 0){
            this.nbErreursRestantes-=1;
        }
        return nbNouvelles;
    }

    /**
     * @return une chaine de caractère donnant l'état du jeu
     */
    public String toString(){
        return "Mot a trouve: "+this.motATrouver+" | Lettres trouvees: "+
               this.motCrypte+" | Nombre de lettres restantes: "+this.nbLettresRestantes+
               " | Nombre d'essais restants: "+this.nbErreursRestantes;
    }

    public String nomNiveau() {
        if(niveau == MotMystere.FACILE){
            return "Facile";
        }
        else if(niveau == MotMystere.MOYEN){
            return "Moyen";
        }
        else if(niveau == MotMystere.DIFFICILE){
            return "Difficile";
        }
        else{
            return "Expert";
        }

    }

}