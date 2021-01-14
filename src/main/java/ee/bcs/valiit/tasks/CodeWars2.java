package ee.bcs.valiit.tasks;


import java.util.Stack;

public class CodeWars2 {

    public static void main(String[] args) {

      //   System.out.println(howOld("5 years old"));
      // toBinary(500);
      //  toBinary(50);
      //  toBinary(500);
      //  toBinary(5000);
        solve(new int[]{15,11,10,7,12});

    }
        public static int howOld(final String herOld){

            return Integer.parseInt(herOld.substring(0,1));

        }

    public static int toBinary(int n) {
        Stack<Integer> ans = new Stack<>();
        while(n >= 1) {
            int x = n % 2;
            int y = n / 2;
             ans.push(x);
        n = y;
        }
        StringBuilder sb = new StringBuilder();
        while(!ans.empty()){
        sb.append(ans.pop());
        }

        System.out.println(sb.toString());
        return (Integer.parseInt(( sb.toString() )));
    }


    public static int[] solve (int[] arr) {

        int[] retlist = new int[ arr.length ];

        for (int k = 0; k < retlist.length; k=  k+2) {

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

        for (int k = 1; k < retlist.length; k=  k+2) {

            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if ( arr[ j ] < min && arr[j] >-1) {
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




}






    

