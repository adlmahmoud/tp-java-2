package tp2_2;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Entrer n(q pour quitter): ");
                String n = sc.next();
                if (n.equals("q")) {
                    System.out.println("Programme terminé.");
                    break;
                }
                int num = Integer.parseInt(n);
                Nbr_d_or or = new Nbr_d_or(num);
                double ratio = or.calculerlenbrdor(num);
                double phi = or.getOre();
                double tolerance = 0.05;
                if (num <= 4) {
                    System.out.println(or);
                }else if(Math.abs(ratio - phi) > tolerance){
                     throw new Exception("Erreur: Le ratio s'éloigne trop du nombre d'or.");
                }else{ 
                    System.out.println(or);
                }    
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Entrer un entier valide.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}


