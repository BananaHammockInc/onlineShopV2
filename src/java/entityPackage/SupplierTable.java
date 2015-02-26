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
@Table(name = "supplierTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierTable.findAll", query = "SELECT s FROM SupplierTable s"),
    @NamedQuery(name = "SupplierTable.findBySID", query = "SELECT s FROM SupplierTable s WHERE s.sID = :sID"),
    @NamedQuery(name = "SupplierTable.findByBusinessName", query = "SELECT s FROM SupplierTable s WHERE s.businessName = :businessName"),
    @NamedQuery(name = "SupplierTable.findByPassword", query = "SELECT s FROM SupplierTable s WHERE s.password = :password")})
public class SupplierTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sID")
    private Integer sID;
    @Size(max = 255)
    @Column(name = "businessName")
    private String businessName;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "supplierID")
    private Collection<InvoiceTable> invoiceTableCollection;
    @OneToMany(mappedBy = "supplierID")
    private Collection<ProductTable> productTableCollection;

    public SupplierTable() {
    }

    public SupplierTable(Integer sID) {
        this.sID = sID;
    }

    public Integer getSID() {
        return sID;
    }

    public void setSID(Integer sID) {
        this.sID = sID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<InvoiceTable> getInvoiceTableCollection() {
        return invoiceTableCollection;
    }

    public void setInvoiceTableCollection(Collection<InvoiceTable> invoiceTableCollection) {
        this.invoiceTableCollection = invoiceTableCollection;
    }

    @XmlTransient
    public Collection<ProductTable> getProductTableCollection() {
        return productTableCollection;
    }

    public void setProductTableCollection(Collection<ProductTable> productTableCollection) {
        this.productTableCollection = productTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sID != null ? sID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierTable)) {
            return false;
        }
        SupplierTable other = (SupplierTable) object;
        if ((this.sID == null && other.sID != null) || (this.sID != null && !this.sID.equals(other.sID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.SupplierTable[ sID=" + sID + " ]";
    }
    
}
