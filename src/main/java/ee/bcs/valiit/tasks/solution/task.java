package ee.bcs.valiit.tasks.solution;

public class task {

public void fizzBuzz(){
for (int i = 1; i<=100; i++){
    if(i% 3 == 0){
        System.out.println("Fizz");

    }
    else if(i%5 == 0){
        System.out.println("Buzz");

    }
    else if(i% 5 == 0 && i%3 == 0 ){
        System.out.println("FizzBuzz");

    }

    else System.out.println(i);
}



}
}