import java.util.*;

public class testJ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // по условию задачи
        ArrayList<Integer> s = new ArrayList<>(); // sj — время начала фильма
        ArrayList<Integer> f = new ArrayList<>(); // fj — время окончания этого фильма
        ArrayList<Integer> w = new ArrayList<>(); // wj — интересность этого фильма


        for(int i = 1; i <= n; i++){
            s.add(in.nextInt());
            f.add(in.nextInt());
            w.add(in.nextInt());
        }

        int One = 0;
        int OneMax = 0;
        boolean OneFlag = false;

        for(int i = 1; i < n; i++){
            if(w.get(i) > OneMax  ){

                One = i;
                OneFlag = true;
                OneMax = w.get(i);

            }
        }
        int Two = 0;
        int TwoMax = 0;
        boolean TwoFlag = false;

        for(int i = 1; i < n; i++){
            if(s.get(One) > f.get(i) &&  OneMax > w.get(i) && w.get(i) > TwoMax ){

                Two = i;
                TwoFlag = true;
                TwoMax = w.get(i);

            }
        }
        if(OneFlag == true && TwoFlag == true){
            System.out.println(OneMax + TwoMax);
            System.out.print(Two + 1 + " ");
            System.out.print(One + 1);
        }
        else {
            System.out.println(0);
            System.out.println("-1 -1");
        }
    }
}