package vitaliyRV.onlineShop.utils;

import vitaliyRV.onlineShop.entity.Cart;
import vitaliyRV.onlineShop.entity.CartItem;

import java.util.List;

public class OrderContainer {
    private Cart cart;
    private List<CartItem> items;

    public OrderContainer(Cart cart, List<CartItem> items) {
        this.cart = cart;
        this.items = items;
    }

    public Integer getTotalPrice(){
        int result = 0;
        for (CartItem cartItem : items){
            result += cartItem.getTotalPrice();
        }
        return result;
    }

    public Cart getCart() {
        return cart;
    }

    public List<CartItem> getItems() {
        return items;
    }

}
