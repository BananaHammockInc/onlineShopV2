/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadePackage;

import entityPackage.ReceiptTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dex
 */
@Stateless
public class ReceiptTableFacade extends AbstractFacade<ReceiptTable> {
    @PersistenceContext(unitName = "onlineShopV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReceiptTableFacade() {
        super(ReceiptTable.class);
    }
    
}