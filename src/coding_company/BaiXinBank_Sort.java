package coding_company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BaiXinBank_Sort {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] sort(int[] a, int length) {
        Arrays.sort(a);
        return a;
    }
    /******************************结束写代码******************************/

//一行多个数字无空格输入  读入  可参考
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String origin = in.nextLine().trim();
        int[] a = new int[origin.length()];
        for(int i = 0; i < origin.length(); i++) {
            a[i] = Integer.parseInt(String.valueOf(origin.charAt(i)));
        }
        int[] res;

        res = sort(a, origin.length());
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.print(String.valueOf(res[res_i]));
        }

    }
}
