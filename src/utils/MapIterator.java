package utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapIterator {

    public static void main(String[] args) {
        //HashMap 遍历是不按顺序排列
        Map map=new HashMap();
        map.put("m1", "m11");
        map.put("m2", "m22");
        map.put("m3", "m33");
        map.put("m4", "m44");
        Iterator iter=map.entrySet().iterator();
        iteratorAll(iter);

        //TreeMap 遍历是按顺序排列
        Map treemap=new TreeMap();
        treemap.put("t1", "t11");
        treemap.put("t2", "t22");
        treemap.put("t3", "t33");
        treemap.put("t4", "t44");
        treemap.put("t5", "t55");

        Iterator titer=treemap.entrySet().iterator();
        iteratorAll(titer);

    }

    private static void iteratorAll(Iterator iter) {
        while(iter.hasNext()){
            Map.Entry entry=(Map.Entry) iter.next();
            String key=entry.getKey().toString();
            String value=entry.getValue().toString();
            System.out.println(key+"*"+value);
        }
    }
}
