package ee.bcs.valiit.tasks.harjutused;

public class Lesson1MathUtil {
    private String test;

    public Lesson1MathUtil(String test) {
        this.test = test;
    }




    public static void main(String[] args) {
        System.out.println(min(3,5));
        System.out.println(max(7,9));
        System.out.println(abs(-5));
        System.out.println(isEven(8));
        System.out.println(isEven(9));
        System.out.println("kolmest arvust väiksem: " + min3(9, 99, 999));
        System.out.println("kolmest arvust suurem: " + max3(9, 9, 999));


    }

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
