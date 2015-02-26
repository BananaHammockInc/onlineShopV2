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
@Table(name = "customerTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerTable.findAll", query = "SELECT c FROM CustomerTable c"),
    @NamedQuery(name = "CustomerTable.findByCID", query = "SELECT c FROM CustomerTable c WHERE c.cID = :cID"),
    @NamedQuery(name = "CustomerTable.findByFName", query = "SELECT c FROM CustomerTable c WHERE c.fName = :fName"),
    @NamedQuery(name = "CustomerTable.findBySName", query = "SELECT c FROM CustomerTable c WHERE c.sName = :sName"),
    @NamedQuery(name = "CustomerTable.findByEmail", query = "SELECT c FROM CustomerTable c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerTable.findByAddressLine1", query = "SELECT c FROM CustomerTable c WHERE c.addressLine1 = :addressLine1"),
    @NamedQuery(name = "CustomerTable.findByAddressLine2", query = "SELECT c FROM CustomerTable c WHERE c.addressLine2 = :addressLine2"),
    @NamedQuery(name = "CustomerTable.findByCity", query = "SELECT c FROM CustomerTable c WHERE c.city = :city"),
    @NamedQuery(name = "CustomerTable.findByPassword", query = "SELECT c FROM CustomerTable c WHERE c.password = :password"),
    @NamedQuery(name = "CustomerTable.findByCardNumber", query = "SELECT c FROM CustomerTable c WHERE c.cardNumber = :cardNumber")})
public class CustomerTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cID")
    private Integer cID;
    @Size(max = 255)
    @Column(name = "fName")
    private String fName;
    @Size(max = 255)
    @Column(name = "sName")
    private String sName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "addressLine1")
    private String addressLine1;
    @Size(max = 255)
    @Column(name = "addressLine2")
    private String addressLine2;
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "cardNumber")
    private Integer cardNumber;
    @OneToMany(mappedBy = "customerID")
    private Collection<PurchaseTable> purchaseTableCollection;

    public CustomerTable() {
    }

    public CustomerTable(Integer cID) {
        this.cID = cID;
    }

    public Integer getCID() {
        return cID;
    }

    public void setCID(Integer cID) {
        this.cID = cID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @XmlTransient
    public Collection<PurchaseTable> getPurchaseTableCollection() {
        return purchaseTableCollection;
    }

    public void setPurchaseTableCollection(Collection<PurchaseTable> purchaseTableCollection) {
        this.purchaseTableCollection = purchaseTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cID != null ? cID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTable)) {
            return false;
        }
        CustomerTable other = (CustomerTable) object;
        if ((this.cID == null && other.cID != null) || (this.cID != null && !this.cID.equals(other.cID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.CustomerTable[ cID=" + cID + " ]";
    }
    
}
