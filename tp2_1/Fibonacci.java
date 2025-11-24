package tp2_1;
public class Fibonacci {
    private int n; 

    public Fibonacci(int n){
        this.n=n;
    }
// le geter sers a recuperer la valeur de n 
    public int getn(){
        return this.n;
    }
// le seter sers a modifier la valeur de n 
   public int calculerFibunacci(int n){
    int f=0;
    int a=0;
    int b=1;
    if(n<=0){
        return 0;
   }
   if (n<=2){
    return 1;
   }
   for (int i=2;i<=n;i++){
    f=a+b;
    a=b;
    b=f;
   }
   return f;
}
 public String toString(){
    return String.format("Fibonacci de %d est %d : F[%d] = %d",this.n,calculerFibunacci(this.n),this.n,calculerFibunacci(this.n));
 }
}


