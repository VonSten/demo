package ee.bcs.valiit.tasks;
import org.springframework.web.bind.annotation.*;

@RequestMapping("lesson3")
@RestController
public class lesson3controller {

    // http://localhost:8080/lesson3/sumarray/?a=1,4,3,4,4
    @GetMapping("sumarray")
    public int input(@RequestParam("a") int[] input) {

        return Lesson3.sumArray(input);

    }


    // http://localhost:8080/lesson3/fact/5
    @GetMapping("fact/{a}")
    public int fact(@PathVariable("a") int input) {
        return Lesson3.factorial(input);
    }


    // http://localhost:8080/lesson3/sort/1,200,2000,2000,2,22
    @GetMapping("sort/{a}")
    public String sort(@PathVariable("a") int[] input){

        return Lesson3.sort(input);
    }

    // http://localhost:8080/lesson3/reversestring/kirvevarsolisitkestkasest

    @GetMapping("reversestring/{a}")
    public String reverseS(@PathVariable("a") String input) {
        return Lesson3.reverseString(input);

    }


}
