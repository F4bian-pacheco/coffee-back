package cl.ucm.coffee.web.controller;


import cl.ucm.coffee.service.Testimonials.TestimonialService;
import cl.ucm.coffee.service.dto.TestimonialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/testimonials")
@RestController
public class TestimonialController {
    @Autowired
    private TestimonialService testimonialService;

    @GetMapping("/")
    public @ResponseBody List<TestimonialDTO> getTestimonials(){

        return testimonialService.findAll();
    }
}
