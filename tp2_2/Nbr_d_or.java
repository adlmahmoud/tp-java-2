package tp2_2;
import tp2_1.Fibonacci;
import java.lang.Math;
public class Nbr_d_or {
    public  double ore=(1+Math.sqrt(5))/2;
    private int n;
    public Nbr_d_or(int n){
        this.n=n;
    }
    public double getOre(){
        return this.ore;
    }
    public int getN(){
        return this.n;
    }
    public int calculerFibunacci(int n){
        Fibonacci f=new Fibonacci(n);
        return f.calculerFibunacci(n);
    }
    public double calculerlenbrdor(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return calculerFibunacci(n)/(double)calculerFibunacci(n-1);
    }
    
    public String toString(){
        return String.format("Le resutlat de O[%d] est : %f\n Le nombre d'or est egale a : %f",this.n,calculerlenbrdor(this.n),this.ore);

}       
}