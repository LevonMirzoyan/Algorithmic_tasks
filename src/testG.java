import java.util.*;
public class testG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> sortirovka = new TreeMap<>();
        int n = in.nextInt();
        String[] word = new String[n];
        Map<String,Integer> pol = new HashMap<>();
        Character[] zn = new Character[n];
        Map<String,Integer> otr = new HashMap<>();
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {

            word[i] = in.next();
            zn[i] = in.next().charAt(0);

        }

        for (int i=0;i<n;i++) {
            String str = word[i];
            Character znak = zn[i];
            if(sortirovka.containsKey(str)) {
                if(znak == '-' ) {
                    if (i+sortirovka.get(str)<otr.get(str) && sortirovka.get(str) < 0)
                        otr.put(str, i+ sortirovka.get(str));
                    sortirovka.put(str,-i);

                }

            }
            else {
                if(znak == '-') {
                    pol.put(str,Integer.MIN_VALUE);
                    otr.put(str, Integer.MAX_VALUE);
                    sortirovka.put(str,-i);
                }
                else {
                    pol.put(str, Integer.MIN_VALUE);
                    otr.put(str, Integer.MAX_VALUE);
                    sortirovka.put(str,i);
                }
                continue;

            }
            if(znak == '-' ) {
                sortirovka.put(str,-i);
            }
            else {
                if (i - sortirovka.get(str) > pol.get(str) && sortirovka.get(str) > 0) {
                    pol.put(str, i - sortirovka.get(str));
                    sortirovka.put(str, i);

                } else {
                    sortirovka.put(str, i);
                }

            }
        }
        System.out.println(sortirovka.size());
        for (Map.Entry entry : sortirovka.entrySet()) {
            System.out.print(entry.getKey());
            if (pol.get(entry.getKey()) != Integer.MIN_VALUE)
                System.out.print(" " + (pol.get(entry.getKey())-1));
            else System.out.print(" ND");
            if (otr.get(entry.getKey()) != Integer.MAX_VALUE)
                System.out.print(" " + (otr.get(entry.getKey())-1));
            else System.out.print(" ND");
            System.out.println();
        }
    }
}