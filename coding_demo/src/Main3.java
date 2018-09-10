import java.util.Scanner;

public class Main3 {

    static class product{
        int num;
        int a;
        int b;
        int c;

        product(int a,int b,int c,int num){
            this.a=a;
            this.b=b;
            this.c=c;
            this.num=num;
        }

        boolean lessthan(product m){
            return this.a<m.a && this.b<m.b && this.c<m.c;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);


    }

}
