package cl.ucm.coffee.service.Coffee;

import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.persitence.entity.TestimonialsEntity;
import cl.ucm.coffee.persitence.repository.CoffeeRepository;
import cl.ucm.coffee.service.dto.CoffeeDTO;
import cl.ucm.coffee.service.dto.TestimonialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService implements  ICoffeeService{
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public List<CoffeeDTO> findAll(){
        List<CoffeeEntity> coffeeEntities = coffeeRepository.findAll();
        List<CoffeeDTO> coffeeDTOs = new ArrayList<>();

        for (CoffeeEntity coffeeEntity : coffeeEntities) {
            CoffeeDTO coffeeDTO = new CoffeeDTO();
            coffeeDTO.setIdCoffee(coffeeEntity.getIdCoffee());
            coffeeDTO.setName(coffeeEntity.getName());
            coffeeDTO.setDescription(coffeeEntity.getDescription());
            coffeeDTO.setPrice(coffeeEntity.getPrice());
            coffeeDTO.setImage64(coffeeEntity.getImage64());

            // Convertir testimonios si es necesario
            List<TestimonialDTO> testimonialDTOs = convertTestimonialsToDTOs(coffeeEntity.getTestimonials());
            coffeeDTO.setTestimonials(testimonialDTOs);

            coffeeDTOs.add(coffeeDTO);
        }

        return coffeeDTOs;
    }

    // Método para convertir TestimonialsEntity a TestimonialDTO
    private List<TestimonialDTO> convertTestimonialsToDTOs(List<TestimonialsEntity> testimonials) {
        List<TestimonialDTO> testimonialDTOs = new ArrayList<>();

        for (TestimonialsEntity testimonialEntity : testimonials) {
            TestimonialDTO testimonialDTO = new TestimonialDTO();
            testimonialDTO.setIdTestimonials(testimonialEntity.getIdTestimonials());
            testimonialDTO.setTestimonial(testimonialEntity.getTestimonial());
            testimonialDTO.setUsername(testimonialEntity.getUsername());

            testimonialDTOs.add(testimonialDTO);
        }

        return testimonialDTOs;
    }
}
