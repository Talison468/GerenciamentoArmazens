package com.warehouse.api.Controller;

import com.warehouse.api.DTO.AddressCreateDTO;
import com.warehouse.api.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    AddressService service;
    @GetMapping("/{id}")
    public List<AddressCreateDTO> findById(@PathVariable("id") UUID id){return service.findAll();}

    @GetMapping
    public List<AddressCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public AddressCreateDTO save(
            @RequestBody AddressCreateDTO addressCreateDTO){
        return service.save(addressCreateDTO);
    }
    @PutMapping("/{id}")
    public AddressCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody AddressCreateDTO addressCreateDTO){
        return service.update(id, addressCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id){service.deleteById(id);}
}
