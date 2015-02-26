package cartPackage;

import entityPackage.ProductTable;
/**
 *
 * @author dex
 */
public class ShoppingCartItem {
     ProductTable product;
    short quantity;

    public ShoppingCartItem(ProductTable product) {
        this.product = product;
        quantity = 1;
    }

    public ProductTable getProduct() {
        return product;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * product.getRetailPrice().doubleValue());
        return amount;
    }
}