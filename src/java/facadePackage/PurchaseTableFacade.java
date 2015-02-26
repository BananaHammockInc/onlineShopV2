/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePackage;

import entityPackage.PurchaseTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dex
 */
@Stateless
public class PurchaseTableFacade extends AbstractFacade<PurchaseTable> {
    @PersistenceContext(unitName = "onlineShopV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseTableFacade() {
        super(PurchaseTable.class);
    }
    
}
