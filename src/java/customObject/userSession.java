/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customObject;

import cartPackage.ShoppingCart;
import entityPackage.CustomerTable;
import entityPackage.Employee;
import entityPackage.SupplierTable;
/**
 * 
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
public class userSession {
    private ShoppingCart cart;
    private Employee employee;
    private CustomerTable customer;
    private SupplierTable supplier;
    private boolean admin;
    private boolean supplierAdmin;
    
    public userSession () {
        this.cart = new ShoppingCart();
        this.employee = new Employee();
        this.customer = new CustomerTable();
        this.supplier = new SupplierTable();
        this.admin = false;
        this.supplierAdmin = false;
    }
        
    public ShoppingCart getCart() {
        return this.cart;
    }
    
    public void setCart(ShoppingCart c) {
        this.cart = c;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee e) {
        this.admin = true;
        this.employee = e;
    }
    
    public CustomerTable getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(CustomerTable c) {
        this.customer = c;
    }
    
    public SupplierTable getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(SupplierTable s) {
        this.supplierAdmin = true;
        this.supplier = s;
    }
    
    public boolean getAdmin() {
        return this.admin;
    }
    
    public boolean getSupplierAdmin() {
        return this.supplierAdmin;
    }
}
