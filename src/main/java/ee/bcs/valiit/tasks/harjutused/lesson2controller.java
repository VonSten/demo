package ee.bcs.valiit.tasks.harjutused;
import org.springframework.web.bind.annotation.*;

@RequestMapping("lesson2")
@RestController
public class lesson2controller {

    // http://localhost:8080/lesson2/reversearray/?a=1,2,3,4,5,6,7,8,9
    @GetMapping("reversearray")
    public String reverse(@RequestParam("a") int[] input){

        return Lesson2.reverseTen(input);

    }

    // TODO korrutustabel
// http://localhost:8080/lesson2/korrutustabel/4/4
    @GetMapping("korrutustabel/{a}/{b}")
    public String korrutusTabel(@PathVariable("a") int a, @PathVariable("b") int b){

        return Lesson2.korrutustabel(a, b);
    }


    // http://localhost:8080/lesson2/fibonacci?a=40
    @GetMapping("fibonacci")
    public int input(@RequestParam("a") int input) {

        return Lesson2.fibon(input);

    }
  //  http://localhost:8080/lesson2/sequence/20/40
    @GetMapping("sequence/{a}/{b}")
    public String sequence(@PathVariable("a") int a, @PathVariable("b") int b){

        return Lesson2.sequence(a, b);
    }









}
