package vitaliyRV.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitaliyRV.onlineShop.entity.Cart;
import vitaliyRV.onlineShop.entity.User;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);
}
