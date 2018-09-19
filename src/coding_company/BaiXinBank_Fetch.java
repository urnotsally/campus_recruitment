package coding_company;

import java.util.Scanner;
//通过用例50%
public class BaiXinBank_Fetch {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int fetch(int[] price) {

        return count(price,price.length-1);
    }

    static int count(int[] price,int last){
        if(last==0){
            return price[0];
        }
        if(last==1){
            return max(price[0],price[1]);
        }
        return max(count(price,last-1),count(price,last-2)+price[last]);
    }

    static int max(int a,int b){
        return a>b?a:b;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _price_size = 0;
        _price_size = Integer.parseInt(in.nextLine().trim());
        int[] _price = new int[_price_size];
        int _price_item;
        for(int _price_i = 0; _price_i < _price_size; _price_i++) {
            _price_item = Integer.parseInt(in.nextLine().trim());
            _price[_price_i] = _price_item;
        }

        res = fetch(_price);
        System.out.println(String.valueOf(res));

    }
}
