package ee.bcs.valiit.tasks.harjutused;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeWars {

    public static void main(String[] args) {

        //  toJadenCase("the-stealth-warrior");// returns "theStealthWarrior"
        //   toJadenCase("The_Stealth_Warrior"); // returns "TheStealthWarrior
        // toJadenCase("see_on-test_string_testimiseks");
        // nthPower(new int[] {3,1,2,2}, 3);
        //  deleteNth(new int[] {31, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3);
        //   Get(100L);


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




    // TODO PADOVAN

    public static BigInteger Get(long power){
        Map<Long, BigInteger> padoMap = new HashMap<Long, BigInteger>();

        padoMap.put(0L, BigInteger.valueOf(1));
        padoMap.put(1L, BigInteger.valueOf(1));
        padoMap.put(2L, BigInteger.valueOf(1));
        padoMap.put(3L, BigInteger.valueOf(2));
        padoMap.put(4L, BigInteger.valueOf(2));
        padoMap.put(5L, BigInteger.valueOf(3));
        padoMap.put(6L, BigInteger.valueOf(4));
        padoMap.put(7L, BigInteger.valueOf(5));
        padoMap.put(8L, BigInteger.valueOf(7));
        padoMap.put(9L, BigInteger.valueOf(9));
        padoMap.put(10L, BigInteger.valueOf(12));
        padoMap.put(11L, BigInteger.valueOf(16));
        if (power>0 && power <=12) {

            //   System.out.println(padoMap.get(power));
            return padoMap.get(power);
        }


        Long counter =power;
        Long count = 12L;
        BigInteger padovanx = BigInteger.valueOf(0);
        while(count <= counter){


            BigInteger padovan = padoMap.get(count -2L).add(padoMap.get(count-3L));
            System.out.println(padovan);
            padoMap.put(count, padovan);
            padoMap.remove(count-4);
            count = count + 1L;
        }


        System.out.println(padoMap.get(power));
        return padovanx;


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
