package ee.bcs.valiit.tasks.harjutused;


import org.springframework.web.bind.annotation.*;

@RequestMapping("lesson1")
@RestController


public class lesson1mathutilcontroller {

    // http://localhost:8080/lesson1/intmax3/6/8/12
    @GetMapping("intmax3/{a}/{b}/{c}")
    public int maxInt3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){

        return Lesson1MathUtil.max3(a, b, c);
    }

    // http://localhost:8080/lesson1/intmin3/6/8/12
    @GetMapping("intmin3/{a}/{b}/{c}")
    public int minInt3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){

        return Lesson1MathUtil.min3(a, b, c);
    }



    // http://localhost:8080/lesson1/intmin/6/8
    @GetMapping("intmin/{a}/{b}")
    public int minInt(@PathVariable("a") int a, @PathVariable("b") int b){

        return Lesson1MathUtil.min(a, b);
    }

    // http://localhost:8080/lesson1/intmax/6/8
    @GetMapping("intmax/{a}/{b}")
    public int maxInt(@PathVariable("a") int a, @PathVariable("b") int b){

        return Lesson1MathUtil.max(a, b);

    }

    // http://localhost:8080/lesson1/abs/-6/
    @GetMapping("abs/{a}")
    public int abs(@PathVariable("a") int a){

        return Lesson1MathUtil.abs(a);

    }




}
