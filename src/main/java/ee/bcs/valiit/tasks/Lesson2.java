package ee.bcs.valiit.tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Lesson2 {



    public static void main(String[] args) {
        // siia saab kirjutada koodi testimiseks
        //exercise1();
        //exercise2(10);
        // exercise3(5,5);
        //exercise4(21);
    //  exercise5(201, 210);
        fibon(1);
    }

    // loo 10 elemendile täisarvude massiv
    // loe sisse konsoolist 10 täisarvu
    // trüki arvud välja vastupidises järiekorras
    public static void exercise1() {
        int[] output = new int[ 10 ];
        Scanner scr = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int input = scr.nextInt();
            output[ i ] = input;
        }

        for (int i = 9; i > -1; i--) {
            System.out.println(output[ i ]);
        }
    }

    // prindi välja x esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static void exercise2(int x) {
        for (int i = 1; i <= x * 2; i++) {
            if ( i % 2 == 0 ) {
                System.out.print(i);

            }
        }
    }

    // trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    //  näiteks x = 3 y = 3
    //  väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    //  1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // 2 lisa + " " print funktsiooni ja kasuta print mitte println
    //  3 trüki seda sama rida y korda
    // 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    //  5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void exercise3(int x, int y) {
        for (int v = 0; v < y; v++) {
            System.out.println();
            for (int u = 1; u < x + 1; u++) {
                System.out.print(( u * ( v + 1 ) + "   " ));
            }


        }
    }



    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element


    public static int fibon(int n) {
        int ret = 0;
        int i1 = 0;
        int i2 = 1;
        if(n==1){


            return 1;

        }

        for (int i = 1; i < n; i++) {

            int i3 = i1 + i2;
            ret = i3;

            i1 = i2;
            i2 = i3;
        }
     //  System.out.println(ret);

       return ret;
    }

    public static void exercise5(int i, int j) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        // 1 (tee alamfunktsioon) mis leiab 3n+1 sequenci pikkuse
        // kui on paaris / 2 kui on paaritu *3+1
        //2 tee tsükkel mis leiab i -> j kõige suurema tsükkli pikkuse
        int max = 0;
         for(int a =i ; a<j; a++ ){
             if(threeN(a)>max){

                 max = threeN(a);
             }
         }
        System.out.print(i+" "+ j + " " + " "+ max);



    }



    public static int threeN(int input) {
        int count = 1;
        int number = input;

        while (number > 1) {
               count++;
            if ( number % 2 == 0 ) {
                number = number / 2;


            } else {
                number = (number * 3) + 1;
            }

        }
        return count;

    }

}


