package tp2_3;
import java.lang.Math;
public class jeu_allumetes {
    // attributs
    public int nbAllumetes;;
    public int intierjoueur;
    private int nombrePris;
    public String nomJoueur;

    public jeu_allumetes(int nbAllumetes){
        this.nbAllumetes=nbAllumetes;
        this.intierjoueur=0;
        this.nombrePris=0;
        this.nomJoueur="";
    }
    // getters
    public int getNbAllumetes(){
        return this.nbAllumetes;
    }
    public int getintierjoueur(){
        return this.intierjoueur;
    }
    public int getnombrePris(){
        return this.nombrePris;
    }
    public String getNomJoueur(){
        return this.nomJoueur;
    }
    // method pour retirer des allumettes
    public void retirerAllumettes(int nombre) throws IllegalArgumentException {
    if (nombre < 1 || nombre > 3) {
        throw new IllegalArgumentException("Vous devez prendre 1, 2 ou 3 allumettes");
    }
    if (nombre > nbAllumetes) {
        throw new IllegalArgumentException("Il ne reste que " + nbAllumetes + " allumettes");
    }
    
    nbAllumetes -= nombre;
    this.nombrePris = nombre;
}
// methode pour generer un nombre aleatoire
public int ordinateur_random(int min,int max){
    int range = (max-min)+1;
    int randome = (int) ((range * Math.random())+min);
    return randome;
}
// methode pour le coup de l'ordinateur
public int coupOrdinateur() {
    int coup;
    
    if (nbAllumetes % 4 == 0) {
        coup = ordinateur_random(1, Math.min(3, nbAllumetes));
    } else {
        coup = nbAllumetes % 4;
    }
    if (coup > nbAllumetes) {
        coup = nbAllumetes;
    }
    
    return coup;
}
// verifier si le jeu est termine
public boolean estTermine() {
return nbAllumetes <= 0;
}
// choisir le premier joueur
public void choisirPremierJoueur() {
    this.intierjoueur = ordinateur_random(0, 1);
    if (this.intierjoueur == 0) {
        System.out.println("Le joueur commence en premier.");
    } else {
        System.out.println("L'ordinateur commence en premier.");
    }
}
// afficher les allumettes
public String allumetes(){
    StringBuilder allumetesVisuelles = new StringBuilder();
    for (int i = 0; i < nbAllumetes; i++) {
        allumetesVisuelles.append("| ");
    }
    return allumetesVisuelles.toString();
}

public String toString(){
    return String.format("%s commence: ");
}
}
    


