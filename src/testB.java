import java.util.*;

public class testB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> v = new HashMap<>(); // вздохи
        Set<String> set = new HashSet<>();
        Set<String> cv = new HashSet<>();         //  цветущие

        int n = in.nextInt();
        int d = 0,f=0, p=0;
        boolean flag = true;
        int vsdoxn = 0;// вздохи
        for(int i=0; i < n; i++) {
            String kakt = in.next();
            int cvet = in.nextInt();



            if (map.size()==f) {
                flag = false;
            }
            else
            {
                flag = true;
            }

            set.add(kakt);
            d++;

            int sizeMap = map.size();
            if (!map.containsKey(kakt)) {
                map.put(kakt,cvet);

                if (cvet == 1) {
                    cv.add(kakt);
                    f++;
                }
            }

            if ((map.get(kakt)==0) && (cvet ==1)) {
                cv.add(kakt);
                f++;
                map.put(kakt,cvet);

            }


            if (f == map.size()) {
                p++;
            }


            if ((map.size()==f) && ((flag == false) && (map.size()==sizeMap)) ){
                vsdoxn++;
                flag = false;
            }


        }

        System.out.println(set.size());
        System.out.println(cv.size());
        System.out.println(p);
        System.out.println(vsdoxn);
    }
}