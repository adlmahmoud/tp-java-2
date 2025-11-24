package tp2_5;

public class Resultat {
    
  private int score;
    private Joueur joueur;

    public Resultat() {
        this.score = 0;
        this.joueur = null;
    }
    public Resultat(int score, Joueur joueur) {
        setScore(score);
        setJoueur(joueur);
    }

    // GETTERS
    public int getScore() {
        return score;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    // SETTERS avec validation
    public void setScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Le score ne peut pas être négatif");
        }
        this.score = score;
    }

    public void setJoueur(Joueur joueur) {
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas être null");
        }
        this.joueur = joueur;
    }

    // afficher
    public void afficher() {
        if (joueur != null) {
            System.out.println("Résultat: " + joueur.getPseudo() + " - Score: " + score);
        } else {
            System.out.println("Résultat: Aucun joueur - Score: " + score);
        }
    }

    // toString
    public String toString() {
        if (joueur != null) {
            return joueur.getPseudo() + " : " + score + " points";
        }
        return "Score: " + score + " points";
    }

    // augmenter le score
    public void augmenterScore(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Les points ne peuvent pas être négatifs");
        }
        this.score += points;
    }

    // réinitialiser le score
    public void reinitialiserScore() {
        this.score = 0;
    }
}
