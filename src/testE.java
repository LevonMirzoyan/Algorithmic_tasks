import java.util.*;

public class testE {
    public static void main(String[] args) {
        Map<Integer, Set<String>> collection = new HashMap<>();
        Set<String> base = new HashSet<>();
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();

        int counter = 0;

        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        for (int i = 0; i < k; i++) {
            String a = in.next();
            base.add(a);
        }

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            Set<String> dancer = new HashSet<>();
            int count = 0;
            Set<String> skills = new HashSet<>();

            k = in.nextInt();

            for (int l = 0; l < k; l++) {
                String d = in.next();
                if(base.contains(d)) {

                    count += 1;
                    dancer.add(d);
                    skills.add(d);

                }
            }
            if (count < 2) {
                collection.put(i + 1,skills);

            }
            else {
                base.removeAll(dancer);
                two.add(i + 1);
            }
        }

        if (base.size() > 0) {
            for (var tmp: collection.entrySet()) {
                for (var d:base) {
                    if (tmp.getValue().contains(d)) {
                        one.add(tmp.getKey());
                        base.remove(d);
                        counter += 1;
                    }

                }
            }
            if (base.size() == 0) {

                System.out.println(1);
                System.out.println(two.size());
                //получение итератора для множества
                Iterator<Integer> iterator = two.iterator();

                for (Integer text : two)
                {
                    System.out.print(text + " ");
                }
                System.out.print( "\n");

                System.out.println(counter);

                for (Integer text : one)
                {
                    System.out.print(text + " ");
                }
                System.out.print( "\n");

            }
            else {
                System.out.println(0);
            }


        }
        else {
            System.out.println(2);
            System.out.println(two.size());
            for (Integer text : two)
            {
                System.out.print(text + " ");
            }
            System.out.print( "\n");

        }

    }
}
