package vitaliyRV.onlineShop.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vitaliyRV.onlineShop.entity.Cart;
import vitaliyRV.onlineShop.entity.CartItem;
import vitaliyRV.onlineShop.entity.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;


@Component
@Scope(scopeName = SCOPE_SESSION, proxyMode = TARGET_CLASS)
public class CartContainer implements Serializable {
    private Cart cart;
    private Map<Integer, CartItem> cartItems;

    public CartContainer() {
        cart = new Cart();
        cartItems = new HashMap<>();
    }

    public Cart getCart() {
        return cart;
    }

    public List<CartItem> getCartItems() {
        return new LinkedList<>(cartItems.values());
    }

    public void addItem(Product product) {
        int productId = product.getId();
        CartItem tempItem = cartItems.get(productId);
        if (tempItem != null) {
            incrementQuantity(productId);
        } else {
            tempItem = new CartItem();
            tempItem.setCart(cart);
            tempItem.setProduct(product);
            tempItem.setAmount(1);
            cartItems.put(productId, tempItem);
        }
    }

    public void removeItem(int productID) {
        cartItems.remove(productID);
    }

    public int getTotalPrice() {
        int total = 0;
        List<CartItem> cartItemList = getCartItems();
        for (CartItem item : cartItemList) {
            total += getProductTotalPrice(item.getProduct().getId());
        }
        return total;
    }

    public void clear() {
        cartItems.clear();
    }

    public void incrementQuantity(int productId) {
        int amount = cartItems.get(productId).getAmount();
        cartItems.get(productId).setAmount(++amount);
    }


    public int getProductTotalPrice(int productID) {
        int price = cartItems.get(productID).getProduct().getPrice();
        int amount = cartItems.get(productID).getAmount();
        return price * amount;
    }

    @Override
    public String toString() {
        return "{\"CartContainer\":{"
                + "\"cart\":" + cart
                + ", \"cartItems\":" + cartItems
                + "}}";
    }
}
