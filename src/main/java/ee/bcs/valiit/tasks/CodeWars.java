package ee.bcs.valiit.tasks;

import org.hibernate.collection.internal.PersistentList;
import org.terracotta.offheapstore.HashingMap;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.OutputStream;
import java.util.*;

public class CodeWars {

    public static void main(String[] args) {

      //  toJadenCase("the-stealth-warrior");// returns "theStealthWarrior"
     //   toJadenCase("The_Stealth_Warrior"); // returns "TheStealthWarrior
       // toJadenCase("see_on-test_string_testimiseks");
     // nthPower(new int[] {3,1,2,2}, 3);
     //  deleteNth(new int[] {31, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3);
        buddyPairs(10, 50);

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
    // DELETE NTH CODEWARS

        public static int[] deleteNth(int[] elements, int maxOccurrences) {

            ArrayList<Integer> vastused = new ArrayList<>();
            Map<Integer, Integer> sort2 = new HashMap<Integer, Integer>();
            for (int i = 0; i< elements.length; i++) {
                int temp = elements[i];

                if (!sort2.containsKey(temp) ) {
                    sort2.put(temp, 1);
                }
                else {
                    sort2.put(temp, sort2.get(temp) + 1);
                }

                if(sort2.get(temp) <= maxOccurrences){
                    vastused.add(temp);

                }


            }

            int[] answer = new int[vastused.toArray().length];
            for(int u = 0; u< vastused.size(); u++){
                answer[u] = vastused.get(u);
            }


            System.out.println(vastused.toString());
            for (int l = 0; l < answer.length; l++){
                System.out.print(answer[l]+ " ");

            }
            System.out.println((answer.length));

            return answer;

            }


            // TODO BUDDY PAIRS CODEWARS
    //  testing(381, 4318, "(1050 1925)");
    //testing(1071625, 1103735, "(1081184 1331967)");
    // testing(2382, 3679, "Nothing");

    public static void buddyPairs(long x, long y){
            Map<Long,Long> map = new HashMap<Long, Long>();
            for(long i = x; i <= y; i++){
           map.put(i, helper(i));
           }
           System.out.println(map);


           for(long i =x; i<y; i++){




                }


               }

















// buddy pairs divisor calculator
    // töötab - ära näpi !
    public static long helper(long x){
        long sum = 0;

        for(long i =1; i<x; i++){
            if(x % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }







// TODO harjutus
 public static void test(){
     int a=4;
     int b=5;

     a = b;
     b = a;

     // a = b ??


     System.out.println(a + " " + b);
    }


}
