package cl.ucm.coffee.service.Coffee;


import cl.ucm.coffee.persitence.entity.CoffeeEntity;
import cl.ucm.coffee.service.dto.CoffeeDTO;

import java.util.List;

public interface ICoffeeService {
    public List<CoffeeDTO> findAll();
    public void saveCoffee(CoffeeDTO coffeeDTO);
    public void deleteCoffee(Integer coffeeId);
    public CoffeeDTO findById(Integer coffeeId);
    public CoffeeEntity updateCoffee(CoffeeDTO coffeeDTO, Integer coffeeId);

}
