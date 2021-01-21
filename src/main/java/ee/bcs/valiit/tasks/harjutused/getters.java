package ee.bcs.valiit.tasks.harjutused;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("car")
@RestController


public class getters {

    private int counter = 0;



    HashMap<Integer, Car> list = new HashMap<Integer, Car>();

    @GetMapping("set/{a}/{b}/{c}")
    public Car setCar(@PathVariable("a") String a,
                      @PathVariable("b") String b,
                      @PathVariable("c") String c)
    {

        Car gt = new Car();
        gt.setRband(a);
        gt.setModel(b);
        gt.setRegnr(c);
        return gt;
    }


    @GetMapping("get")
    public Car getCar(){
        Car gg = new Car();
        gg.getRegnr();
        gg.getRband();
        gg.getModel();
        return gg;

    }

    @PostMapping("")
    public void test(@RequestBody Car input){
        list.put(counter,input);
        counter ++;
    }

    @GetMapping("")
    public HashMap<Integer, Car>  getCars(){
        return list;
    }

    @GetMapping("/{a}")
    public Car getCar(@PathVariable("a") int index){

        return list.get(index);
    }

    @PutMapping("/{a}")
    public void putCar(@RequestBody Car input, @PathVariable("a") int index){
        list.replace(index, input);

    }

    @DeleteMapping("/{a}")

    public void deleteCar(@PathVariable("a") int index){
        list.remove(index);
    }

}


