package com.warehouse.api.Service;

import com.warehouse.api.DTO.SectionCreateDTO;
import com.warehouse.api.Entity.Section;
import com.warehouse.api.Repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public SectionCreateDTO findById(UUID id) {
        Section section = sectionRepository.findById(id).orElseThrow();
        SectionCreateDTO sectionCreateDTO = convertToDto(section);
        return sectionCreateDTO;
    }
    public SectionCreateDTO save(SectionCreateDTO sectionCreateDTO){
        Section section = convertToEntity(sectionCreateDTO);
        section = sectionRepository.save(section);
        return convertToDto(section);
    }
    public SectionCreateDTO update(UUID id, SectionCreateDTO sectionCreateDTO){
        Section section = convertToEntity(sectionCreateDTO);
        section.setId(id);
        sectionRepository.save(section);
        return convertToDto(section);
    }
    public void deleteById (UUID id) {sectionRepository.deleteById(id);}
    public List<SectionCreateDTO> findAll() {
        List<Section> sections = sectionRepository.findAll();
        List<SectionCreateDTO> sectionCreateDTOS = new ArrayList<>();
        for (Section section : sections) {
            sectionCreateDTOS.add(convertToDto(section));
        }
        return sectionCreateDTOS;
    }
    public SectionCreateDTO convertToDto (Section section){
        SectionCreateDTO sectionCreateDTO = new SectionCreateDTO();
        sectionCreateDTO.setCode(section.getCode());
        return sectionCreateDTO;
    }
    public Section convertToEntity (SectionCreateDTO SectionCreateDTO) {
        Section section = new Section();
        section.setCode(section.getCode());
        return section;
    }
}
