package tp2_1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try{
                    System.out.print("Entrer n(pout quitter taper q) : ");
                    String n = sc.next();
                    if (n.equals("q")) {
                        System.out.println("Programme terminé.");
                        break;
                    }
                    int num = Integer.parseInt(n);
                    Fibonacci f = new Fibonacci(num);
                    System.out.println(f);  
                } catch(Exception e){
                System.out.println("Erreur: Entrer un entier valide.");
            }
        }
        sc.close();
    }
}
// afficher un tableau de fibonacci