package com.warehouse.api.Controller;

import com.warehouse.api.DTO.SectionCreateDTO;
import com.warehouse.api.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {
    @Autowired
    SectionService service;
    @GetMapping("/{id}")
    public List<SectionCreateDTO> findById(@PathVariable("id") UUID id){return service.findAll();}

    @GetMapping
    public List<SectionCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public SectionCreateDTO save(
            @RequestBody SectionCreateDTO sectionCreateDTO){
        return service.save(sectionCreateDTO);
    }
    @PutMapping("/{id}")
    public SectionCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody SectionCreateDTO sectionCreateDTO){
        return service.update(id, sectionCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id){service.deleteById(id);}
}
