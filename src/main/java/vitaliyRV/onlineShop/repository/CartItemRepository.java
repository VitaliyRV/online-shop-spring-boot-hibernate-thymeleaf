package vitaliyRV.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitaliyRV.onlineShop.entity.Cart;
import vitaliyRV.onlineShop.entity.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart(Cart cart);
}
