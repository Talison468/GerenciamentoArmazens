package com.warehouse.api.Controller;

import com.warehouse.api.DTO.ShipmentCreateDTO;
import com.warehouse.api.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {
    @Autowired
    ShipmentService service;
    @GetMapping("/{id}")
    public List<ShipmentCreateDTO> findById(@PathVariable("id") UUID id){return service.findAll();}

    @GetMapping
    public List<ShipmentCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public ShipmentCreateDTO save(
            @RequestBody ShipmentCreateDTO shipmentCreateDTO) {
        return service.save(shipmentCreateDTO);
    }
    @PutMapping("/{id}")
    public ShipmentCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody ShipmentCreateDTO shipmentCreateDTO){
        return service.update(id, shipmentCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id){service.deleteById(id);}
}
