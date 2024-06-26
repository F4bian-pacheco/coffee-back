package cl.ucm.coffee.web.controller;

import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.persitence.entity.TestimonialsEntity;
import cl.ucm.coffee.service.Coffee.CoffeeService;
import cl.ucm.coffee.service.Testimonials.TestimonialService;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import cl.ucm.coffee.service.dto.TestimonialDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/testimonials")
public class TestimonialsController {

    @Autowired
    TestimonialService testimonialService;
    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/")
    public @ResponseBody List<TestimonialDTO> getTestimonials(){

        return testimonialService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<String> saveTestimonial(@RequestBody TestimonialDTO testimonialDTO){
        TestimonialsEntity testimonialsEntity = new TestimonialsEntity();
//        CoffeeDTO coffeeDTO = coffeeService.findById(testimonialDTO.getIdCoffee());
//        CoffeeEntity coffeeEntity = new CoffeeEntity();
//        coffeeEntity.setIdCoffee(coffeeDTO.getIdCoffee());
//        coffeeEntity.setName(coffeeDTO.getName());
//        coffeeEntity.setDescription(coffeeDTO.getDescription());
//        coffeeEntity.setPrice(coffeeDTO.getPrice());
//        coffeeEntity.setImage64(coffeeDTO.getImage64());


//        testimonialsEntity.setIdTestimonials(testimonialDTO.getIdTestimonials());
        testimonialsEntity.setTestimonial(testimonialDTO.getTestimonial());
        testimonialsEntity.setUsername(testimonialDTO.getUsername());
        testimonialsEntity.setIdCoffee(testimonialDTO.getIdCoffee());
//        testimonialsEntity.setCoffee(coffeeEntity);

        testimonialService.save(testimonialsEntity);

        return ResponseEntity.ok("testimonio creado correctamente");

    }
}
