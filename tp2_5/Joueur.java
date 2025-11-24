package tp2_5;

public class Joueur {
    private String nom;
    private String prenom;
    private String pseudo;

    public Joueur(String nom, String prenom, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }
    public Joueur() {
        this.nom = "";
        this.prenom = "";
        this.pseudo = "";
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getPseudo() {
        return pseudo;
    }
    // Setters avec validation
      public void setNom(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom ne peut pas être null");
        }
        this.nom = nom.trim();
    }

    public void setPrenom(String prenom) {
        if (prenom == null) {
            throw new IllegalArgumentException("Le prénom ne peut pas être null");
        }
        this.prenom = prenom.trim();
    }

    public void setPseudo(String pseudo) {
        if (pseudo == null) {
            throw new IllegalArgumentException("Le pseudo ne peut pas être null");
        }
        this.pseudo = pseudo.trim();
    }
        public void afficher() {
        System.out.println("Joueur: " + prenom + " " + nom + " (Pseudo: " + pseudo + ")");
    }
    public String toString() {
        return prenom + " " + nom + " (" + pseudo + ")";
    }
}
