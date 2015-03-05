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
 * Aaron Kelly - 12350566
 * Alex McElhinney - 12437802
 * Evan Preisler - 10101753
 * CT338 - Software Engineering Project: Banana Hammock, Online Fruit & Veg Store
 * 2015
 * 
 *
 * @author dex
 */
@Entity
@Table(name = "employeeReceiptTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeReceiptTable.findAll", query = "SELECT e FROM EmployeeReceiptTable e"),
    @NamedQuery(name = "EmployeeReceiptTable.findByRID", query = "SELECT e FROM EmployeeReceiptTable e WHERE e.rID = :rID"),
    @NamedQuery(name = "EmployeeReceiptTable.findByAmountRemoved", query = "SELECT e FROM EmployeeReceiptTable e WHERE e.amountRemoved = :amountRemoved"),
    @NamedQuery(name = "EmployeeReceiptTable.findByCost", query = "SELECT e FROM EmployeeReceiptTable e WHERE e.cost = :cost")})
public class EmployeeReceiptTable implements Serializable {
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
    private EmployeePurchaseTable purchaseID;
    @JoinColumn(name = "productID", referencedColumnName = "pID")
    @ManyToOne
    private ProductTable productID;

    public EmployeeReceiptTable() {
    }

    public EmployeeReceiptTable(Integer rID) {
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

    public EmployeePurchaseTable getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(EmployeePurchaseTable purchaseID) {
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
        if (!(object instanceof EmployeeReceiptTable)) {
            return false;
        }
        EmployeeReceiptTable other = (EmployeeReceiptTable) object;
        if ((this.rID == null && other.rID != null) || (this.rID != null && !this.rID.equals(other.rID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.EmployeeReceiptTable[ rID=" + rID + " ]";
    }
    
}
