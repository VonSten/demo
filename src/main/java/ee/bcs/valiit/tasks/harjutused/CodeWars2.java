package ee.bcs.valiit.tasks.harjutused;


import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CodeWars2 {

    public static void main(String[] args) {

        //   System.out.println(howOld("5 years old"));
        // toBinary(500);
        //  toBinary(50);
        //  toBinary(500);
        //  toBinary(5000);
        //  solve(new int[]{15,11,10,7,12});
        //redKnight(0, 108);
        sumOfDifferences(new int[]{1, 2, 10});

    }

    public static int howOld(final String herOld) {

        return Integer.parseInt(herOld.substring(0, 1));

    }

    public static int toBinary(int n) {
        Stack<Integer> ans = new Stack<>();
        while (n >= 1) {
            int x = n % 2;
            int y = n / 2;
            ans.push(x);
            n = y;
        }
        StringBuilder sb = new StringBuilder();
        while (!ans.empty()) {
            sb.append(ans.pop());
        }

        System.out.println(sb.toString());
        return ( Integer.parseInt(( sb.toString() )) );
    }


    public static int[] solve(int[] arr) {

        int[] retlist = new int[ arr.length ];

        for (int k = 0; k < retlist.length; k = k + 2) {

            int min = Integer.MIN_VALUE;
            int index = 0;

            for (int j = 0; j < arr.length; j++) {
                if ( arr[ j ] > min ) {
                    min = arr[ j ];
                    index = j;
                }
            }
            retlist[ k ] = min;
            arr[ index ] = Integer.MIN_VALUE;
        }

        for (int k = 1; k < retlist.length; k = k + 2) {

            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if ( arr[ j ] < min && arr[ j ] > -1 ) {
                    min = arr[ j ];
                    index = j;
                }
            }
            retlist[ k ] = min;
            arr[ index ] = Integer.MAX_VALUE;
        }


        for (int k = 0; k < arr.length; k++) {
            System.out.print(retlist[ k ] + " ");
        }
        System.out.println();
        return retlist;

    }


    public static void redKnight(int knight, long pawn) {
        long ans = pawn * 2;

        if ( ( pawn % 2 == 0 && knight == 0 ) || ( pawn % 2 != 0 && knight == 1 ) ) {
            System.out.println("White" + " " + ans);

        }
        System.out.println("Black" + " " + ans);
    }


    public static int sumOfDifferences(int[] arr) {
        List<Integer> arrlist = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            arrlist.add(arr[ i ]);
        }
        Collections.sort(arrlist, Collections.reverseOrder());
        System.out.println(arrlist);
int answer = 0;
        for (int u = 0; u <arrlist.size()-1; u++){
             answer = answer +(arrlist.get(u)-arrlist.get(u+1));

        }
        System.out.println(answer);
        return 0;
    }

}




    

