package coding_company;

import java.util.Scanner;

public class JD_Unlattices {
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
        int n=in.nextInt();
        product[] box=new product[n];
        boolean[] checked=new boolean[n*(n-1)/2];
        int ans=0;
        for(int i=0;i<n;i++){
            box[i]=new product(in.nextInt(),in.nextInt(),in.nextInt(),i+1);
        }
        for(int m=0;m<n;m++){
            for(int p=0;p<n;p++){
                if(p==m) continue;
                boolean flag=m>p?checked[m*(m-1)/2+p]:checked[p*(p-1)/2+m];
                if( box[m].lessthan(box[p])){
                    if(m>p)
                        checked[m*(m-1)/2+p]=true;
                    else
                        checked[p*(p-1)/2+m]=true;
                    ans++;
                    break;
                }
            }
        }
        System.out.print(ans);

    }
}
