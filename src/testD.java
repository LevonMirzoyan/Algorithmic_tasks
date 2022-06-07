import java.io.IOException;
import java.util.*;
public class testD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dh = 0; // счетчик пока выбирают предложение одного человека, потом его обнуляем
        int dm =0; // 0 - когда выбираем Харитона
        int sdh = 0; // счетчик сколько раз выбирали предложение вообще за все время
        int sdm = 0;
        int n = in.nextInt();

        int[] har = new int[n];
        int[] mel = new int[n];
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {

            har[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            mel[i] = in.nextInt();

        }


        for (int i = 0; i < n; i++){

            int h = har[i];
            int m = mel[i];
// на 6 день (h>m+dh ) здесь нужно такое условие, а не условие  (h>m) поэтому ошибка
            if (h>m+dh){

                if (dh<0)
                {
                    res[i] = "H";
                    sdh++;
                    dh=1;
                    dm = 0;
                }
                else
                {
                    res[i] = "H";
                    sdh++;
                    dh++;
                    dm=0;
                }
            }

            else if ((dm>0) && h>m ){

                if(dh<0)
                {
                    res[i] = "H";
                    sdh++;
                    dm=0;
                    dh=1;
                }

                else
                {
                    res[i] = "H";
                    sdh++;
                    dm=0;
                    dh++;
                }

            }

            else if ((sdh<=sdm)&&(h == m + dh) ){


                if (dh < 0) {
                    res[i] = "H";
                    sdh++;
                    dh = 1;
                    dm = 0;
                } else {
                    res[i] = "H";
                    sdh++;
                    dh++;
                    dm = 0;
                }


            }
            else {

                if (dm>0)
                {
                    res[i] = "M";
                    sdm++;
                    dh=dh -1;
                }
                else
                {
                    res[i] = "M";
                    sdm++;
                    dh = -1;
                    dm = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);

        }
    }


}