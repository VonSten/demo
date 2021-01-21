package ee.bcs.valiit.tasks.harjutused;

public class BouncingBall {

    public static  void main (String[]args){

bouncingBall(30, 0.66, 1.5);

    }


    public static int bouncingBall(double h, double bounce, double window) {
      int  count = 0;
       if(h<=0 || bounce <= 0 || bounce >= 1 || window >= h ){

           return -1;
       }



        while(h > window){
            count++;
            h = h*bounce;
            if(h>window){
                count++;
            }
        }


        System.out.println(count);
        return count;
    }
}
