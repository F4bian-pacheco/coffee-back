package cl.ucm.coffee.web.controller;

import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.service.Coffee.CoffeeService;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import cl.ucm.coffee.service.dto.CoffeeTestDto;
import jakarta.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<CoffeeDTO>> Getcoffees() {

        try {
            List<CoffeeDTO> coffees = coffeeService.findAll();
            return ResponseEntity.ok(coffees);
        } catch (Exception e) {
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getTestimonials")
    public ResponseEntity<List<CoffeeTestDto>> GetcoffeeWithTest() {
        try {
            List<CoffeeTestDto> coffeeTestDtos = coffeeService.findAllWithTests();
            return ResponseEntity.ok(coffeeTestDtos);
        } catch (Exception e) {
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<CoffeeDTO> getCoffeesByName(@RequestParam String name) {
        try {
            CoffeeDTO coffeeDTO = coffeeService.findByName(name);
            return ResponseEntity.ok(coffeeDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> saveCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        try {
            coffeeService.saveCoffee(coffeeDTO);
            return ResponseEntity.ok("Café guardado exitosamente");
        } catch (Exception e) {
            // Captura cualquier otra excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el café");
        }
    }

    @PostMapping("/image")
    public ResponseEntity<String> saveImage(@RequestBody byte[] Image, @RequestParam String coffeeId) {
        // CoffeeEntity coffeeEntity = coffeeService.

    }

    @DeleteMapping("/{idCoffee}")
    public ResponseEntity<String> deleteCoffee(@PathVariable Integer idCoffee) {
        try {
            coffeeService.deleteCoffee(idCoffee);
            return ResponseEntity.ok("Café eliminado correctamente");
        } catch (Exception e) {
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el café");
        }
    }

    @PutMapping("/{idCoffee}")
    public ResponseEntity<String> putCoffee(@PathVariable Integer idCoffee, @RequestBody CoffeeDTO coffeeDTO) {
        try {
            coffeeService.updateCoffee(coffeeDTO, idCoffee);
            return ResponseEntity.ok("Café actualizado correctamente");
        } catch (Exception e) {
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el café");
        }
    }

}
