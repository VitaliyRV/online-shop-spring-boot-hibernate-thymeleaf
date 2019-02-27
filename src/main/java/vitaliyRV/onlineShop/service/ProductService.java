package vitaliyRV.onlineShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitaliyRV.onlineShop.entity.Product;
import vitaliyRV.onlineShop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(Integer id){
        return productRepository.getOne(id);
    }
}
