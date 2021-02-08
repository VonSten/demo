package ee.bcs.valiit.tasks.harjutused;

public class Lesson1MathUtil {
    private String test;




    //  tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
       int min = 0;
       if(a<=b){
           min =a;
       }
       else{
           min=b;

       }


        return min;
    }

    // tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        int max = 0;
        if(a>b){
            max = a;
        }
        else {
            max = b;

        }
        return max;
    }

    // tagasta a absoluut arv
    public static int abs(int a) {
        int abs = 0;
        if(a >= 0){
            abs = a;
        }
        else {
            abs = -a;
        }

        return abs;
    }

    // tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        return ( a % 2 == 0);

    }

    // tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        int min = 0;
        if(a < b){
            min = a;
        }
        else {
           min = b;
        }

        if (min > c){
            min = c;

        }
        else {
            min = min;

        }


        return min;
    }

    // tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        int temp = Math.max(a,b);
        int max = Math.max(temp,c);
        return max;
    }
}
