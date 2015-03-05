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
@Table(name = "invoiceContentTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceContentTable.findAll", query = "SELECT i FROM InvoiceContentTable i"),
    @NamedQuery(name = "InvoiceContentTable.findByIncID", query = "SELECT i FROM InvoiceContentTable i WHERE i.incID = :incID"),
    @NamedQuery(name = "InvoiceContentTable.findByAmountAdded", query = "SELECT i FROM InvoiceContentTable i WHERE i.amountAdded = :amountAdded")})
public class InvoiceContentTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "incID")
    private Integer incID;
    @Column(name = "amountAdded")
    private Integer amountAdded;
    @JoinColumn(name = "invoiceID", referencedColumnName = "inID")
    @ManyToOne
    private InvoiceTable invoiceID;
    @JoinColumn(name = "productID", referencedColumnName = "pID")
    @ManyToOne
    private ProductTable productID;

    public InvoiceContentTable() {
    }

    public InvoiceContentTable(Integer incID) {
        this.incID = incID;
    }

    public Integer getIncID() {
        return incID;
    }

    public void setIncID(Integer incID) {
        this.incID = incID;
    }

    public Integer getAmountAdded() {
        return amountAdded;
    }

    public void setAmountAdded(Integer amountAdded) {
        this.amountAdded = amountAdded;
    }

    public InvoiceTable getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(InvoiceTable invoiceID) {
        this.invoiceID = invoiceID;
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
        hash += (incID != null ? incID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceContentTable)) {
            return false;
        }
        InvoiceContentTable other = (InvoiceContentTable) object;
        if ((this.incID == null && other.incID != null) || (this.incID != null && !this.incID.equals(other.incID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.InvoiceContentTable[ incID=" + incID + " ]";
    }
    
}
