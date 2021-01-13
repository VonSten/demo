package ee.bcs.valiit.tasks;

import org.terracotta.offheapstore.HashingMap;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeWars {

    public static void main(String[] args) {

      //  toJadenCase("the-stealth-warrior");// returns "theStealthWarrior"
     //   toJadenCase("The_Stealth_Warrior"); // returns "TheStealthWarrior
       // toJadenCase("see_on-test_string_testimiseks");
     // nthPower(new int[] {3,1,2,2}, 3);
       deleteNth(new int[] {3,3,3,3,1,1},1);
     //   buddyPairs(381, 4318);


    }

    public static void toCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        input = input.replaceAll("[^a-zA-Z]", " ");
        String[] inputs = input.split("\\W+");
        sb.append(inputs[ 0 ]);
        for (int i = 1; i < inputs.length; i++) {
            inputs[ i ] = inputs[ i ].toString().substring(0, 1).toUpperCase() + inputs[ i ].toString().substring(1);
            sb.append(inputs[ i ]);
        }

        System.out.println(sb.toString());
    }

    public static void toJadenCase(String input) {


        StringBuilder sb = new StringBuilder();
        input = input.replaceAll("[^a-zA-Z]", " ");
        String[] inputs = input.split("\\W+");

        for (int i = 0; i < inputs.length; i++) {
            inputs[ i ] = inputs[ i ].toString().substring(0, 1).toUpperCase() + inputs[ i ].toString().substring(1);
            sb.append(inputs[ i ]+ " ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }

    public static int nthPower(int[] array, int n) {
        if(n < array.length){
            double test =(double) array[n];
            double ret = Math.pow(test, n);
            System.out.println(ret);

            return (int) ret;

        }
        else {
            return -1;
        }
    }
    // TODO DELETE NTH CODEWARS

        public static int[] deleteNth(int[] elements, int maxOccurrences) {
            Map<Integer, Integer> sort = new HashMap<Integer, Integer>();


            for (int i = 0; i < elements.length; i++) {
                if(!sort.containsKey(elements[i])) {
                    sort.put(elements[ i],1);

                }


                System.out.println(sort);




            }
            return elements;
        }

            // TODO BUDDY PAIRS CODEWARS
    //  testing(381, 4318, "(1050 1925)");
    //testing(1071625, 1103735, "(1081184 1331967)");
    // testing(2382, 3679, "Nothing");

    public static void buddyPairs(int x, int y){
                int count = y;
                while (helper(count) > x) {
                    for (int i = x; i < y; i++) {
                        if ( helper(i) == helper(helper(i + 1)) ) {
                            System.out.println(i);
                            System.out.println(count);
                            break;
                        }

                    }


                }
            }




// buddy pairs divisor calculator
    public static int helper(int x){
        int sum = 0;

        for(int i =1; i<x; i++){
            if(x % i == 0) {
                sum = sum + i;

            }

        }
        return sum;
    }








 public static void test(){
     int a=4;
     int b=5;

     a = b;
     b = a;

     // a = b ??


     System.out.println(a + " " + b);
    }


}
