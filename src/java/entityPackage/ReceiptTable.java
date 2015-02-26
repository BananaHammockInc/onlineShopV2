/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "receiptTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptTable.findAll", query = "SELECT r FROM ReceiptTable r"),
    @NamedQuery(name = "ReceiptTable.findByRID", query = "SELECT r FROM ReceiptTable r WHERE r.rID = :rID"),
    @NamedQuery(name = "ReceiptTable.findByAmountRemoved", query = "SELECT r FROM ReceiptTable r WHERE r.amountRemoved = :amountRemoved"),
    @NamedQuery(name = "ReceiptTable.findByCost", query = "SELECT r FROM ReceiptTable r WHERE r.cost = :cost")})
public class ReceiptTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rID")
    private Integer rID;
    @Column(name = "amountRemoved")
    private Integer amountRemoved;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @JoinColumn(name = "purchaseID", referencedColumnName = "puID")
    @ManyToOne
    private PurchaseTable purchaseID;
    @JoinColumn(name = "productID", referencedColumnName = "pID")
    @ManyToOne
    private ProductTable productID;

    public ReceiptTable() {
    }

    public ReceiptTable(Integer rID) {
        this.rID = rID;
    }

    public Integer getRID() {
        return rID;
    }

    public void setRID(Integer rID) {
        this.rID = rID;
    }

    public Integer getAmountRemoved() {
        return amountRemoved;
    }

    public void setAmountRemoved(Integer amountRemoved) {
        this.amountRemoved = amountRemoved;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public PurchaseTable getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(PurchaseTable purchaseID) {
        this.purchaseID = purchaseID;
    }

    public ProductTable getProductID() {
        return productID;
    }

    public void setProductID(ProductTable productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rID != null ? rID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceiptTable)) {
            return false;
        }
        ReceiptTable other = (ReceiptTable) object;
        if ((this.rID == null && other.rID != null) || (this.rID != null && !this.rID.equals(other.rID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.ReceiptTable[ rID=" + rID + " ]";
    }
    
}
