package vitaliyRV.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitaliyRV.onlineShop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
