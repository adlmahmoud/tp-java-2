package tp2_3;

import java.util.Scanner;
import java.util.InputMismatchException;

public class main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
    // Nom du joueur
    System.out.println("Entrer votre nom :");
    String nomJoueur = sc.nextLine();

    // Nombre d'allumettes de départ
    int nbAllumetes = 0;
    while (true) {
        try {
            System.out.println("Choisir le nombre d'allumette de départ :");
            nbAllumetes = sc.nextInt();
            if (nbAllumetes <= 0) {
                System.out.println("Le nombre doit être supérieur à 0.");
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un nombre entier.");
            sc.nextLine();
        }
    }

    // Création du jeu
    jeu_allumetes jeu = new jeu_allumetes(nbAllumetes);
    jeu.nomJoueur = nomJoueur;

    // Choisir qui commence
    jeu.choisirPremierJoueur();

    // Variable pour savoir qui a joué le dernier coup
    String dernierJoueur = "";

    // Boucle principale du jeu
    while (!jeu.estTermine()) {
        int prise = 0;

        if (jeu.getintierjoueur() == 1) { // ordinateur
            prise = jeu.coupOrdinateur();
            jeu.retirerAllumettes(prise);
            System.out.println(jeu.allumetes() + " Ordinateur enlève : " + prise);
            dernierJoueur = "Ordinateur";
            jeu.intierjoueur = 0;
        } else { // joueur 
            while (true) {
                try {
                    System.out.print(jeu.allumetes() + " " + nomJoueur + " enlève : ");
                    prise = sc.nextInt();
                    jeu.retirerAllumettes(prise);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un nombre entier.");
                    sc.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            dernierJoueur = nomJoueur;
            jeu.intierjoueur = 1;
        }
    }

    //le dernier joueur qui a joué a perdu
    if (dernierJoueur.equals(nomJoueur)) {
        System.out.println(nomJoueur + " a perdu :-(");
        System.out.println("L’ordinateur a gagné :-)");
    } else {
        System.out.println("L’ordinateur a perdu :-(");
        System.out.println(nomJoueur + " a gagné :-)");
    }

    sc.close();
}
}
