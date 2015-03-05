/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePackage;

import entityPackage.EmployeeReceiptTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Stateless
public class EmployeeReceiptTableFacade extends AbstractFacade<EmployeeReceiptTable> {
    @PersistenceContext(unitName = "onlineShopV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeReceiptTableFacade() {
        super(EmployeeReceiptTable.class);
    }
    
}
