import java.io.IOException;
import java.util.*;

public class testC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Set<String> map = new HashSet<>(); // бабочки которые пролетали мимо экрана
        Set<String> har = new HashSet<>(); // Харитоновские бабочки
        Set<String> meleton = new HashSet<>(); // Мелентия бабочки

        int t1=0;
        int sizeMeleton=0;
        boolean flag = false;

        int n = input.nextInt();
        int k = input.nextInt();

        for (int i = 0; i < n; i++) {
            String bab = input.next(); // название бабочки
            int t = input.nextInt();  //  время когда пролетала
            if(t1<=t){

                sizeMeleton=meleton.size();
                meleton.add(bab);


                if(sizeMeleton !=meleton.size()){
                    flag=true;
                    t1=t+k;

                }
                continue;
            }
            if(flag == true){
                har.add(bab);
                flag=false;
            }
            else if (flag == false) {
                map.add(bab);
            }
        }
        har.removeAll(meleton);
        meleton.addAll(har);
        map.removeAll(meleton);

        System.out.println(meleton.size());
        System.out.println(har.size());
        System.out.println(map.size());


    }
}