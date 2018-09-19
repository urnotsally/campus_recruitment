package coding_demo;

import java.util.*;

public class Main {

    static class Stu {
        private String number;
        private String M100;
        private String M800;
        private String JUMP;
        private String BAIL;
        private int count;

        public Stu(String num) {
            this.number = num;
        }

        public void setM100(String m, String n) {
            int x = Integer.valueOf(m), y = Integer.valueOf(n);
            if (x < 12 || (x == 12 && y == 0)) {
                this.M100 = "GREAT";
                this.count+=3;
            } else if (x < 13) {
                if (y <= 4) {
                    this.M100 = "GOOD";
                    this.count+=2;
                } else {
                    this.M100 = "QUALIFIED";
                    this.count+=1;
                }
            } else {
                this.M100 = "FAIL";
            }
        }

        public void setM800(String m, String n) {
            int x = Integer.valueOf(m), y = Integer.valueOf(n);
            if (x < 2 || (x == 2 && y <=15)) {
                this.M800 = "GREAT";
                this.count+=3;
            } else if (x==2&&y<=24) {
                this.M800 = "GOOD";
                this.count+=2;
            } else if(x==2&&y<=31){
                this.M800 = "QUALIFIED";
                this.count+=1;
            }else {
                this.M800 = "FAIL";
            }

        }

        public void setJUMP(String m) {
            int x = Integer.valueOf(m);
            if (x>266) {
                this.JUMP = "GREAT";
                this.count+=3;
            } else if (x>=256) {
                this.JUMP = "GOOD";
                this.count+=2;
            } else if(x>=246){
                this.JUMP = "QUALIFIED";
                this.count+=1;
            }else {
                this.JUMP = "FAIL";
            }

        }

        public void setBAIL(String m) {  //转化为整数
            int x = Integer.valueOf(m);
            if (x>104) {
                this.BAIL = "GREAT";
                this.count+=3;
            } else if (x>=96) {
                this.BAIL = "GOOD";
                this.count+=2;
            } else if(x>=87){
                this.BAIL = "QUALIFIED";
                this.count+=1;
            }else {
                this.BAIL = "FAIL";
            }

        }

        public int getCount(){
            return this.count;
        }


        public String getNumber() {
            return number;
        }

        public String getM100() {
            return M100;
        }

        public String getM800() {
            return M800;
        }

        public String getJUMP() {
            return JUMP;
        }

        public String getBAIL() {
            return BAIL;
        }
    }

    static Map<Stu,Integer> sort_by_value(Map<Stu,Integer> map){
        if(map==null||map.isEmpty()){
            return null;
        }
        Map<Stu,Integer> sortedMap=new LinkedHashMap<Stu, Integer>();
        List<Map.Entry<Stu,Integer>> entryList=new ArrayList<Map.Entry<Stu,Integer>>(
                map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Stu, Integer>>() {
            @Override
            public int compare(Map.Entry<Stu, Integer> o1, Map.Entry<Stu, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Iterator<Map.Entry<Stu,Integer>> iter=entryList.iterator();
        Map.Entry<Stu,Integer> tmpEntry=null;
        while (iter.hasNext()){
            tmpEntry=iter.next();
            Stu a=tmpEntry.getKey();
            System.out.println(a.getNumber()+"/t"+a.getM100()+"/t"+a.getM800()+"/t"+a.getJUMP()+"/t"+a.getBAIL());
            sortedMap.put(tmpEntry.getKey(),tmpEntry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String record=in.nextLine().trim();
        Map<Stu,Integer> map=new TreeMap<>();
        while (!record.equals("end")){
            String[] tmps=record.split(" ");
            Stu stu=new Stu(tmps[0]);
            for(int i=2;i<tmps.length;i++){
                String str=tmps[i];
                if(str.contains("s")){
                    String mm=str.substring(0,str.indexOf("s"));
                    if(str.indexOf("s")!=str.length()-1){
                        String ss=str.substring(str.indexOf("s")+1);
                        stu.setM100(mm,ss);
                    }else{
                        stu.setM100(mm,"0");
                    }
                }else if(str.contains("cm")){
                    String dis=str.substring(0,str.indexOf("c"));
                    stu.setJUMP(dis);
                }else if(str.endsWith("m")){
                   String dis=str.substring(0,str.indexOf("m"));
                   if(dis.contains(".")) dis.replace(".","");
                   stu.setBAIL(dis);
                }else {
                    int x=str.indexOf("m");
                    String cc;
                    String mm=str.substring(0,x);
                    if(x!=str.length()-1)
                        cc=str.substring(x+1);
                    else cc="0";
                    stu.setM800(mm,cc);
                }
               map.put(stu,stu.getCount());
            }
            System.out.println("NO."+"/t"+"100M"+"/t"+"800M"+"/t"+"JUMP"+"/t"+"BALL");
            map=sort_by_value(map);
        }


    }



}
