package cl.ucm.coffee.persitence.repository;

import cl.ucm.coffee.service.dto.TestimonialDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ucm.coffee.persitence.entity.TestimonialsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<TestimonialsEntity,Integer> {

}
