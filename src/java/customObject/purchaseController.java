package customObject;

import entityPackage.PurchaseTable;
import entityPackage.EmployeePurchaseTable;
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
public class purchaseController {
    private List<PurchaseTable> purchaseC;
    private List<EmployeePurchaseTable> purchaseE;
    
    
    public purchaseController() {
        this.purchaseC = new ArrayList<PurchaseTable>();
        this.purchaseE = new ArrayList<EmployeePurchaseTable>();
    }
    
    public List<PurchaseTable> getPurchaseC() {
        return this.purchaseC;
    }
    
    public void setPurchase(List<PurchaseTable> p) {
        this.purchaseC = p;
    }
    public List<EmployeePurchaseTable> getPurchaseE() {
        return this.purchaseE;
    }
    
    public void setPurchaseE(List<EmployeePurchaseTable> p) {
        this.purchaseE = p;
    }
}
