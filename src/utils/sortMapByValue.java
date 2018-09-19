package utils;

import java.util.*;

public class sortMapByValue {

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
