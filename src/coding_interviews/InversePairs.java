import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//HashMap按照key排序
public class InversePairs {

    public int InversePairs(int [] array) {
        Map<Integer,Integer> check=new TreeMap<Integer, Integer>();
        int count;
        for(int i=0;i<array.length;i++){
            check.put(array[i],i);
        }
        Set<Integer> keyset=check.keySet();
        Iterator<Integer> iterator=keyset.iterator();
        int index=0;
        int ans=0;
        while (iterator.hasNext()){
            int key=iterator.next();
            int tmp=Math.abs(check.get(key)-(index++));
            ans+=tmp;
        }
        return ans/2;
    }

    public static void main(String[] args) {
        int[] array={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int res=new InversePairs().InversePairs(array);
        System.out.print(res);
    }

}
