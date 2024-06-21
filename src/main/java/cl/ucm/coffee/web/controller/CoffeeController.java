package cl.ucm.coffee.web.controller;


import cl.ucm.coffee.service.Coffee.CoffeeService;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import cl.ucm.coffee.service.dto.CoffeeTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/")
    public @ResponseBody List<CoffeeDTO> Getcoffees(){

        
        return coffeeService.findAll();
    }
    @GetMapping("/getTestimonials")
    public @ResponseBody List<CoffeeTestDto> GetcoffeeWithTest(){
        return coffeeService.findAllWithTests();
    }

    @PostMapping("/")
    public ResponseEntity<String> saveCoffee( @RequestBody CoffeeDTO coffeeDTO){
        System.out.println("controlador");

        coffeeService.saveCoffee(coffeeDTO);
        
        return ResponseEntity.ok("cafe guardado");
    }
    @DeleteMapping("/{idCoffee}")
    public ResponseEntity<String> deleteCoffee(@PathVariable Integer idCoffee){
//        System.out.println("controlador"+idCoffee);
        coffeeService.deleteCoffee(idCoffee);
        return ResponseEntity.ok("cafe eliminado");
    }

    @PutMapping("/{idCoffee}")
    public ResponseEntity<String> putCoffee(@PathVariable Integer idCoffee, @RequestBody CoffeeDTO coffeeDTO){
        coffeeService.updateCoffee(coffeeDTO,idCoffee);

        return ResponseEntity.ok("cafe actualizado");
    }

}
