package ee.bcs.valiit.tasks;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson3 {
    public static void main(String[] args) {
        // sum(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        // factorial(7);
        //reverseString("sorteeri massiiv suuruse järgi");
        // reverseString2("sorteeri massiiv suuruse järgi");
        // sort(new int[]{3331, 32, 43, 64, 5, 76, 70, 8, 6000, 60300, 33, 1, 5, 2});

        System.out.println(isPrime(96));
        System.out.println(isPrime(97));
        System.out.println(isPrime(98));
        //System.out.println(helper(48));

    }

    // summeeri massiiv
    public static int sum(int[] x) {
        int ans = 0;
        for (int i = 0; i < x.length; i++) {
            ans = ans + x[ i ];

        }
        System.out.println(ans);
        return ans;
    }


    public static int factorial(int x) {
        // tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int answer = 1;
        for (int i = 1; i <= x; i++) {
            answer = answer * i;

        }
        System.out.println(answer);
        return answer;

    }


    public static int[] sort(int[] a) {
        //  sorteeri massiiv suuruse järgi.
        //  kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        int[] retlist = new int[ a.length ];

        for (int k = 0; k < retlist.length; k++) {

            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int j = 0; j < a.length; j++) {
                if ( a[ j ] < min ) {
                    min = a[ j ];
                    index = j;
                }


            }
            retlist[ k ] = min;
            a[ index ] = Integer.MAX_VALUE;
        }

        for (int k = 0; k < a.length; k++) {
            System.out.print(retlist[ k ] + " ");
        }
        System.out.println();
        return retlist;

    }


    // string tagurpidi
    public static String reverseString(String a) {
        StringBuilder sb = new StringBuilder();
        char[] temp = a.toCharArray();


        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[ i ]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // string tagurpidi lihtne versioon
    public static String reverseString2(String a) {

        for (int i = a.length() - 1; i >= 0; i--) {
            System.out.print(a.charAt(i));

        }
        System.out.println();
        return "";
    }

    public static boolean isPrime(int x) {

        int counter = 0;

        for (int i = 1; i <= x; i++) {
            if ( x % i == 0 ) {
                counter++;
            }
        }
        return ( counter == 2  || x == 1);

    }
}


