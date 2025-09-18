package com.warehouse.api.Controller;

import com.warehouse.api.DTO.WarehouseCreateDTO;
import com.warehouse.api.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService service;
    @GetMapping("/{id}")
    public List<WarehouseCreateDTO> findById(@PathVariable("id") UUID id ){return service.findAll();}

    @GetMapping
    public List<WarehouseCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public WarehouseCreateDTO save(
            @RequestBody WarehouseCreateDTO warehouseCreateDTO){
        return service.save(warehouseCreateDTO);
    }
    @PutMapping("/{id}")
    public WarehouseCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody WarehouseCreateDTO warehouseCreateDTO){
        return service.update(id, warehouseCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id){service.deleteById(id);}
}
