package ee.bcs.valiit.tasks.harjutused;

import java.util.HashMap;
import java.util.Map;

public class BuddyPairs {
    public static void main(String[] args){

        buddy(2177, 4357);
        System.out.println(helper(2295));
        System.out.println(helper(2024));



    }


        public static String buddy(long start, long limit) {

            String ret = "";


            for (long i = start; i < limit; i++) {
                long sum1 = helper(i);       //sum x
                long sum2 = sum1 - 1;        //y

                long sum3 = helper(sum2);   //sum y
                                            // x =i;


               if ( sum3 == i+1 &&  sum2 > i  )

                {
                    ret ="("+ i + " " + ( sum1 - 1 )+")";
                    System.out.println(ret);
                    return ret;
                }



            }
            System.out.println("Nothing");
            return "Nothing";
        }

        public static long helper(long x) {
            long ans = 0;

            for (long i = 2; i <= Math.sqrt(x); i++) {
                if ( x % i == 0 ) {

                    if ( i == ( x / i ) ) {
                        ans += i;
                    }
                    else {
                        ans += ( i + (x / i ));
                    }
                }

            }
            return ans+1;
        }

    }





