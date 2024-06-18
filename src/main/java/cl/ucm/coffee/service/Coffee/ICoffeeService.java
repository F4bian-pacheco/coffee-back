package cl.ucm.coffee.service.Coffee;


import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.service.dto.CoffeeDTO;

import java.util.List;

public interface ICoffeeService {
    public List<CoffeeDTO> findAll();

}
