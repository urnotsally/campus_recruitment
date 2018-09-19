package coding_company;

import java.util.Scanner;

public class RedBook_ListReverse {

    static Node pnew;
    static Node pold;

    static class Node{
        private int value;
        private Node next;

        Node(int v){
            this.value=v;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String[] list=str.split(" ");
        int k=in.nextInt();
        Node head=new Node(Integer.valueOf(list[0]));
        Node p=head;
        for(int i=1;i<list.length;i++){
            Node n=new Node(Integer.valueOf(list[i]));
            p.next=n;
            p=n;
        }
        if(k==1){

        }else if(k>list.length){
            head=reverse(head,list.length);
        }else{
            int n=list.length;
            int t=n/k;
            pold=head;
            Node oldhead=head;
            for(int i=0;i<t;i++){
                if(i==0){
                    head=reverse(pold,k);
                }else {
                    Node tmp=pold;
                    oldhead.next=reverse(pold, k);
                    oldhead=tmp;
                }
            }

        }

        printf(head);
    }

    static Node reverse(Node head,int k){
        pnew=head;
        pold=head.next;
        for(int i=1;i<k;i++){
            Node tmp=pold.next;
            pold.next=pnew;
            pnew=pold;
            pold=tmp;
        }
        head.next=pold;
        return pnew;
    }

    static void printf(Node head){
        if(head!=null){
            while (head.next!=null){
                System.out.print(head.value+" ");
                head=head.next;
            }
            System.out.print(head.value);
        }
    }


}
