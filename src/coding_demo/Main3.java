package coding_demo;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        Map<Integer,Integer> map=new TreeMap<>();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        map=sort_by_value(map);
        Iterator iter=map.entrySet().iterator();
        Map.Entry ent=(Map.Entry )iter.next();
        System.out.println(ent.getKey());
        System.out.println(ent.getValue());


    }

    static Map<Integer,Integer> sort_by_value(Map<Integer,Integer> map){
        if(map==null||map.isEmpty()){
            return null;
        }
        Map<Integer,Integer> sortedMap=new LinkedHashMap<Integer, Integer>();
        List<Map.Entry<Integer,Integer>> entryList=new ArrayList<Map.Entry<Integer,Integer>>(
                map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Iterator<Map.Entry<Integer,Integer>> iter=entryList.iterator();
        Map.Entry<Integer,Integer> tmpEntry=null;
        while (iter.hasNext()){
            tmpEntry=iter.next();
            sortedMap.put(tmpEntry.getKey(),tmpEntry.getValue());
        }
        return sortedMap;
    }

}
