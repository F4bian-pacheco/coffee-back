package cl.ucm.coffee.web.controller;


import cl.ucm.coffee.service.Coffee.CoffeeService;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.persitence.repository.CoffeeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/")
    public @ResponseBody List<CoffeeDTO> Getcoffes(){

        
        return coffeeService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<String> coffe(){
        
        return ResponseEntity.ok("chao");
    }

}
