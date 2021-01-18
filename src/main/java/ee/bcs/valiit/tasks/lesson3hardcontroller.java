package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

@RequestMapping("lesson3hard")
@RestController
public class lesson3hardcontroller {

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


    //TODO random game

}
