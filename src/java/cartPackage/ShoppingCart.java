package cartPackage;

import entityPackage.ProductTable;
import java.util.*;

/**
 *
 * @author dex
 */
public class ShoppingCart {

    List<ShoppingCartItem> items;
    int numberOfItems;
    double total;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0;
    }
    public synchronized void addItem(ProductTable product) {
        boolean newItem = true;
        for (ShoppingCartItem scItem : items) {
            if (scItem.getProduct().getPID().intValue() == product.getPID().intValue()) {
                newItem = false;
                scItem.incrementQuantity();
            }
        }
        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(product);
            items.add(scItem);
        }
    }

    public synchronized void update(ProductTable product, String quantity) {
        short qty = -1;
        qty = Short.parseShort(quantity);
        if (qty >= 0) {
            ShoppingCartItem item = null;
            for (ShoppingCartItem scItem : items) {
                if (scItem.getProduct().getPID() == product.getPID()) {
                    if (qty != 0) {
                        scItem.setQuantity(qty);
                    } else {
                        item = scItem;
                        break;
                    }
                }
            }
            if (item != null) {
                items.remove(item);
            }
        }
    }
    public synchronized List<ShoppingCartItem> getItems() {
        return items;
    }
    public synchronized int getNumberOfItems() {
        numberOfItems = 0;
        for (ShoppingCartItem scItem : items) {
            numberOfItems += scItem.getQuantity();
        }
        return numberOfItems;
    }
    public synchronized double getSubtotal() {
        double amount = 0;
        for (ShoppingCartItem scItem : items) {
            ProductTable product = (ProductTable) scItem.getProduct();
            amount += (scItem.getQuantity() * product.getRetailPrice().doubleValue());
        }
        return amount;
    }
    public synchronized void calculateTotal(String surcharge) {
        double amount = 0;
        double s = Double.parseDouble(surcharge);
        amount = this.getSubtotal();
        amount += s;
        total = amount;
    }
    public synchronized double getTotal() {
        return total;
    }
    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
}