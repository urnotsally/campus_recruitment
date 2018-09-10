import java.util.Scanner;

public class Main2 {

    static int[][] graph;
    static boolean[][] visit;
    static int n;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int count=0;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            graph=new int[n][n];
            visit=new boolean[n][n];
            int m=in.nextInt();
            for(int j=0;j<m;j++){
                int x=in.nextInt();
                int y=in.nextInt();
                graph[x-1][y-1]=1;
                visit[x-1][y-1]=false;
            }
            for(int p=0;p<n;p++){
                for(int q=0;q<n;q++){
                    if(!visit[p][q]&&graph[p][q]==1){
                        visit[p][q]=true;
                        visited(p,q);
                        count++;
                    }
                }
            }
            System.out.println(count==1);
        }

    }

    static void visited(int x,int y){
        int i=x-1,j=y;
        if(i>=0&&i<n&&j>=0&&j<n&&!visit[i][j]){
            visit[i][j]=true;
            if(graph[i][j]==1){
                visited(i,j);
            }
        }
        i=x+1;j=y;
        if(i>=0&&i<n&&j>=0&&j<n&&!visit[i][j]){
            visit[i][j]=true;
            if(graph[i][j]==1){
                visited(i,j);
            }
        }
        i=x;j=y-1;
        if(i>=0&&i<n&&j>=0&&j<n&&!visit[i][j]){
            visit[i][j]=true;
            if(graph[i][j]==1){
                visited(i,j);
            }
        }
        i=x;j=y+1;
        if(i>=0&&i<n&&j>=0&&j<n&&!visit[i][j]){
            visit[i][j]=true;
            if(graph[i][j]==1){
                visited(i,j);
            }
        }
    }

}
