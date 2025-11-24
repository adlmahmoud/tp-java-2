package tp2_4;

public class Carte {
    private Couleur couleur;
    private String valeur;

    // Constructeur avec couleur et valeur
    public Carte(Couleur couleur, String valeur) {
        setCouleur(couleur); 
        setValeur(valeur);    
    }

    // Constructeur par copie
    public Carte(Carte autreCarte) {
        if (autreCarte == null) {
            throw new IllegalArgumentException("La carte à copier ne peut pas être null");
        }
        this.couleur = autreCarte.couleur;
        this.valeur = autreCarte.valeur;
    }

    // GETTERS
    public Couleur getCouleur() {
        return couleur;
    }

    public String getValeur() {
        return valeur;
    }

    // SETTERS 
    public void setCouleur(Couleur couleur) {
        if (couleur == null) {
            throw new IllegalArgumentException("La couleur ne peut pas être null");
        }
        this.couleur = couleur;
    }

    public void setValeur(String valeur) {
        if (valeur == null || valeur.trim().isEmpty()) {
            throw new IllegalArgumentException("La valeur ne peut pas être null ou vide");
        }
        this.valeur = valeur;
    }

    // afficher
    public void afficher() {
        System.out.println(valeur + " de " + couleur);
    }

    // affecter 
    public void affecter(Carte autreCarte) {
        if (autreCarte == null) {
            throw new IllegalArgumentException("La carte à affecter ne peut pas être null");
        }
        this.couleur = autreCarte.couleur;
        this.valeur = autreCarte.valeur;
    }

    // equal pour comparer deux cartes
    public boolean equal(Carte autreCarte) {
        if (autreCarte == null) {
            return false;
        }
        return this.couleur == autreCarte.couleur && 
               this.valeur.equals(autreCarte.valeur);
    }

    // toString pour affichage
    public String toString() {
        return valeur + " de " + couleur;
    }
}

enum Couleur {
    COEUR("Coeur"),
    CARREAU("Carreau"),
    TREFLE("Trefle"),
    PIQUE("Pique");

    private final String libelle;

    Couleur(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
}