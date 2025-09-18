package com.warehouse.api.Service;

import com.warehouse.api.DTO.ProductCreateDTO;
import com.warehouse.api.Entity.Product;
import com.warehouse.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductCreateDTO findById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductCreateDTO productCreateDTO = convertToDto(product);
        return productCreateDTO;
    }
    public ProductCreateDTO save(ProductCreateDTO productCreateDTO){
        Product product = convertToEntity(productCreateDTO);
        product = productRepository.save(product);
        return convertToDto(product);
    }
    public ProductCreateDTO update(UUID id, ProductCreateDTO productCreateDTO){
        Product product = convertToEntity(productCreateDTO);
        product.setId(id);
        productRepository.save(product);
        return convertToDto(product);
    }
    public void deleteById (UUID id) {productRepository.deleteById(id);}
    public List<ProductCreateDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductCreateDTO> productCreateDTOS = new ArrayList<>();
        for (Product product : products) {
            productCreateDTOS.add(convertToDto(product));
        }
        return productCreateDTOS;
    }
    public ProductCreateDTO convertToDto (Product product){
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setName(product.getName());
        productCreateDTO.setSku(product.getSku());
        return productCreateDTO;
    }
    public Product convertToEntity (ProductCreateDTO ProductCreateDTO) {
        Product product = new Product();
        product.setName(product.getName());
        product.setSku(product.getSku());
        return product;
    }
}
