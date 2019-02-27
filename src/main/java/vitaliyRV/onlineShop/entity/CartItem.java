package vitaliyRV.onlineShop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_item")
public class CartItem  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shopCartId", referencedColumnName = "id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Product product;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Transient
    public Integer getTotalPrice(){
        return amount * product.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (!id.equals(cartItem.id)) return false;
        if (!cart.equals(cartItem.cart)) return false;
        if (!product.equals(cartItem.product)) return false;
        return amount.equals(cartItem.amount);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cart.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{\"CartItem\":{"
                + "\"id\":\"" + id + "\""
                + ", \"cart\":" + cart
                + ", \"product\":" + product
                + ", \"amount\":\"" + amount + "\""
                + "}}";
    }
}
