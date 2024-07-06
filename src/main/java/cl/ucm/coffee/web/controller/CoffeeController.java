package cl.ucm.coffee.web.controller;

import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.service.Coffee.CoffeeService;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import cl.ucm.coffee.service.dto.CoffeeDtoPut;
import cl.ucm.coffee.service.dto.CoffeeTestDto;
import jakarta.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/")
    public ResponseEntity<List<CoffeeDTO>> create() {

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
    public ResponseEntity<Map> saveCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        try {
            coffeeService.saveCoffee(coffeeDTO);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Café guardado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Captura cualquier otra excepción y devuelve un mensaje de error genérico
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al guardar el café: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // @PostMapping("/image")
    // public ResponseEntity<String> saveImage(@RequestBody byte[] Image, @RequestParam String coffeeId) {
    //     // CoffeeEntity coffeeEntity = coffeeService.

    // }

    @DeleteMapping("/{idCoffee}")
    public ResponseEntity<Map> deleteCoffee(@PathVariable Integer idCoffee) {
        try {
            coffeeService.deleteCoffee(idCoffee);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Café eliminado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al eliminar el café: " + e.getMessage());
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/{idCoffee}")
    public ResponseEntity<Map> putCoffee(@PathVariable Integer idCoffee, @RequestBody CoffeeDtoPut coffeeDTOPut) throws ValidationException {
        try {
            coffeeService.updateCoffee(coffeeDTOPut, idCoffee);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Café actualizado correctamente");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Captura cualquier excepción y devuelve un mensaje de error genérico
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error al actualizar el café");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
