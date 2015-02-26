/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "purchaseTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseTable.findAll", query = "SELECT p FROM PurchaseTable p"),
    @NamedQuery(name = "PurchaseTable.findByPuID", query = "SELECT p FROM PurchaseTable p WHERE p.puID = :puID"),
    @NamedQuery(name = "PurchaseTable.findByDate", query = "SELECT p FROM PurchaseTable p WHERE p.date = :date"),
    @NamedQuery(name = "PurchaseTable.findByTotalRemoved", query = "SELECT p FROM PurchaseTable p WHERE p.totalRemoved = :totalRemoved")})
public class PurchaseTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "puID")
    private Integer puID;
    @Size(max = 255)
    @Column(name = "date")
    private String date;
    @Column(name = "totalRemoved")
    private Integer totalRemoved;
    @OneToMany(mappedBy = "purchaseID")
    private Collection<ReceiptTable> receiptTableCollection;
    @JoinColumn(name = "customerID", referencedColumnName = "cID")
    @ManyToOne
    private CustomerTable customerID;

    public PurchaseTable() {
    }

    public PurchaseTable(Integer puID) {
        this.puID = puID;
    }

    public Integer getPuID() {
        return puID;
    }

    public void setPuID(Integer puID) {
        this.puID = puID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotalRemoved() {
        return totalRemoved;
    }

    public void setTotalRemoved(Integer totalRemoved) {
        this.totalRemoved = totalRemoved;
    }

    @XmlTransient
    public Collection<ReceiptTable> getReceiptTableCollection() {
        return receiptTableCollection;
    }

    public void setReceiptTableCollection(Collection<ReceiptTable> receiptTableCollection) {
        this.receiptTableCollection = receiptTableCollection;
    }

    public CustomerTable getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerTable customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puID != null ? puID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseTable)) {
            return false;
        }
        PurchaseTable other = (PurchaseTable) object;
        if ((this.puID == null && other.puID != null) || (this.puID != null && !this.puID.equals(other.puID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.PurchaseTable[ puID=" + puID + " ]";
    }
    
}
