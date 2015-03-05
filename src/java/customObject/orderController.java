/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customObject;

import entityPackage.InvoiceTable;
import entityPackage.InvoiceContentTable;
import java.util.ArrayList;
import java.util.List;
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
public class orderController {
    private List<InvoiceTable> invoice;
    private List<InvoiceContentTable> content;
    
    public orderController() {
        this.invoice = new ArrayList<InvoiceTable>();
        this.content = new ArrayList<InvoiceContentTable>();
    }
    
    public List<InvoiceTable> getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(List<InvoiceTable> i) {
        this.invoice = i;
    }
    
    public void addInvoice(InvoiceTable i) {
        this.invoice.add(i);
    }
    
    public List<InvoiceContentTable> getContent() {
        return  this.content;
    }
    
    public void setContent(List<InvoiceContentTable> c) {
        this.content = c;
    }
    
    public void addContent(InvoiceContentTable c) {
        this.content.add(c);
    }
}
