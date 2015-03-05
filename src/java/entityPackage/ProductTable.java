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
@Table(name = "productTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductTable.findAll", query = "SELECT p FROM ProductTable p"),
    @NamedQuery(name = "ProductTable.findByPID", query = "SELECT p FROM ProductTable p WHERE p.pID = :pID"),
    @NamedQuery(name = "ProductTable.findByProductName", query = "SELECT p FROM ProductTable p WHERE p.productName = :productName"),
    @NamedQuery(name = "ProductTable.findByDescription", query = "SELECT p FROM ProductTable p WHERE p.description = :description"),
    @NamedQuery(name = "ProductTable.findByWholesalePrice", query = "SELECT p FROM ProductTable p WHERE p.wholesalePrice = :wholesalePrice"),
    @NamedQuery(name = "ProductTable.findByRetailPrice", query = "SELECT p FROM ProductTable p WHERE p.retailPrice = :retailPrice"),
    @NamedQuery(name = "ProductTable.findByStockLevel", query = "SELECT p FROM ProductTable p WHERE p.stockLevel = :stockLevel")})
public class ProductTable implements Serializable {
    @OneToMany(mappedBy = "productID")
    private Collection<EmployeeReceiptTable> employeeReceiptTableCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pID")
    private Integer pID;
    @Size(max = 255)
    @Column(name = "productName")
    private String productName;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wholesalePrice")
    private Double wholesalePrice;
    @Column(name = "retailPrice")
    private Double retailPrice;
    @Column(name = "stockLevel")
    private Integer stockLevel;
    @OneToMany(mappedBy = "productID")
    private Collection<ReceiptTable> receiptTableCollection;
    @JoinColumn(name = "supplierID", referencedColumnName = "sID")
    @ManyToOne
    private SupplierTable supplierID;
    @OneToMany(mappedBy = "productID")
    private Collection<InvoiceContentTable> invoiceContentTableCollection;

    public ProductTable() {
    }

    public ProductTable(Integer pID) {
        this.pID = pID;
    }

    public Integer getPID() {
        return pID;
    }

    public void setPID(Integer pID) {
        this.pID = pID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    @XmlTransient
    public Collection<ReceiptTable> getReceiptTableCollection() {
        return receiptTableCollection;
    }

    public void setReceiptTableCollection(Collection<ReceiptTable> receiptTableCollection) {
        this.receiptTableCollection = receiptTableCollection;
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
        hash += (pID != null ? pID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductTable)) {
            return false;
        }
        ProductTable other = (ProductTable) object;
        if ((this.pID == null && other.pID != null) || (this.pID != null && !this.pID.equals(other.pID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.ProductTable[ pID=" + pID + " ]";
    }

    @XmlTransient
    public Collection<EmployeeReceiptTable> getEmployeeReceiptTableCollection() {
        return employeeReceiptTableCollection;
    }

    public void setEmployeeReceiptTableCollection(Collection<EmployeeReceiptTable> employeeReceiptTableCollection) {
        this.employeeReceiptTableCollection = employeeReceiptTableCollection;
    }
    
}
