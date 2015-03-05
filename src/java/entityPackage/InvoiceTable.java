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
@Table(name = "invoiceTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceTable.findAll", query = "SELECT i FROM InvoiceTable i"),
    @NamedQuery(name = "InvoiceTable.findByInID", query = "SELECT i FROM InvoiceTable i WHERE i.inID = :inID"),
    @NamedQuery(name = "InvoiceTable.findByDate", query = "SELECT i FROM InvoiceTable i WHERE i.date = :date"),
    @NamedQuery(name = "InvoiceTable.findByTotalAdded", query = "SELECT i FROM InvoiceTable i WHERE i.totalAdded = :totalAdded")})
public class InvoiceTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inID")
    private Integer inID;
    @Size(max = 255)
    @Column(name = "date")
    private String date;
    @Column(name = "totalAdded")
    private Integer totalAdded;
    @JoinColumn(name = "supplierID", referencedColumnName = "sID")
    @ManyToOne
    private SupplierTable supplierID;
    @OneToMany(mappedBy = "invoiceID")
    private Collection<InvoiceContentTable> invoiceContentTableCollection;

    public InvoiceTable() {
    }

    public InvoiceTable(Integer inID) {
        this.inID = inID;
    }

    public Integer getInID() {
        return inID;
    }

    public void setInID(Integer inID) {
        this.inID = inID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTotalAdded() {
        return totalAdded;
    }

    public void setTotalAdded(Integer totalAdded) {
        this.totalAdded = totalAdded;
    }

    public SupplierTable getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(SupplierTable supplierID) {
        this.supplierID = supplierID;
    }

    @XmlTransient
    public Collection<InvoiceContentTable> getInvoiceContentTableCollection() {
        return invoiceContentTableCollection;
    }

    public void setInvoiceContentTableCollection(Collection<InvoiceContentTable> invoiceContentTableCollection) {
        this.invoiceContentTableCollection = invoiceContentTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inID != null ? inID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceTable)) {
            return false;
        }
        InvoiceTable other = (InvoiceTable) object;
        if ((this.inID == null && other.inID != null) || (this.inID != null && !this.inID.equals(other.inID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.InvoiceTable[ inID=" + inID + " ]";
    }
    
}
