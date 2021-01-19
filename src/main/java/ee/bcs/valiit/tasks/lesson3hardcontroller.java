package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RequestMapping("lesson3hard")
@RestController
public class lesson3hardcontroller {

    private int input;

    // http://localhost:8080/lesson3hard/morse/morsekood%20morsekood
    @GetMapping("morse/{a}")
    public String morsecode(@PathVariable("a") String morsecode){

        return Lesson3Hard.morseCode(morsecode);
    }


// http://localhost:8080/lesson3hard/evenfibonacci/1000
    @GetMapping("evenfibonacci/{a}")
    public int evenFibonacci(@PathVariable("a") int input){

        return Lesson3Hard.evenFibonacci(input);

    }
  public Random rnd(){
        return new Random();
  }
   ;
    int  guess = rnd().nextInt(100);
    int count = 0;

@GetMapping("rand/{input}")
    public String randomgame(@PathVariable("input") int input) {

    count++;
    if(guess == input){
        guess  = rnd().nextInt(100);
        String ret = "Sinu võit " + count + " käiku";
        count = 0;
        return ret;

    }
    return Lesson3Hard.randomGame(input, guess, count);

}




}
