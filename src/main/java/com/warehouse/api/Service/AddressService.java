package com.warehouse.api.Service;

import com.warehouse.api.DTO.AddressCreateDTO;
import com.warehouse.api.Entity.Address;
import com.warehouse.api.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressCreateDTO findById(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow();
        AddressCreateDTO addressCreateDTO = convertToDto(address);
        return addressCreateDTO;
    }
    public AddressCreateDTO save(AddressCreateDTO addressCreateDTO){
        Address address = convertToEntity(addressCreateDTO);
        address = addressRepository.save(address);
        return convertToDto(address);
    }
    public AddressCreateDTO update(UUID id, AddressCreateDTO addressCreateDTO){
        Address address = convertToEntity(addressCreateDTO);
        address.setId(id);
        addressRepository.save(address);
        return convertToDto(address);
    }
    public void deleteById (UUID id) {addressRepository.deleteById(id);}
    public List<AddressCreateDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressCreateDTO> addressCreateDTOS = new ArrayList<>();
        for (Address address : addresses) {
            addressCreateDTOS.add(convertToDto(address));
        }
        return addressCreateDTOS;
    }
    public AddressCreateDTO convertToDto (Address address){
        AddressCreateDTO addressCreateDTO = new AddressCreateDTO();
        addressCreateDTO.setCity(address.getCity());
        addressCreateDTO.setStreet(address.getStreet());
        return addressCreateDTO;
    }
    public Address convertToEntity (AddressCreateDTO WarehouseCreateDTO) {
        Address address = new Address();
        address.setCity(address.getCity());
        address.setStreet(address.getStreet());
        return address;
    }
}
