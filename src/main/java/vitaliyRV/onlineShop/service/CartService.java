package vitaliyRV.onlineShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitaliyRV.onlineShop.entity.Cart;
import vitaliyRV.onlineShop.entity.CartItem;
import vitaliyRV.onlineShop.entity.User;
import vitaliyRV.onlineShop.repository.CartItemRepository;
import vitaliyRV.onlineShop.repository.CartRepository;
import vitaliyRV.onlineShop.utils.CartContainer;
import vitaliyRV.onlineShop.utils.OrderContainer;

import java.util.LinkedList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartContainer cartContainer;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void submitOrderForPayment() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findByUsername(name);

        cartContainer.getCart().setUser(user);
        cartRepository.save(cartContainer.getCart());
        cartItemRepository.saveAll(cartContainer.getCartItems());
        cartContainer.clear();
    }

    public List<OrderContainer> getOrders(){
        User user = userService.getLoggedInUser();
        List<Cart> cartList = cartRepository.findByUser(user);

        List<OrderContainer> result = new LinkedList<>();
        for (Cart cart : cartList){
            List<CartItem> cartItemList = cartItemRepository.findByCart(cart);
            result.add(new OrderContainer(cart, cartItemList));
        }
        return result;
    }
}
