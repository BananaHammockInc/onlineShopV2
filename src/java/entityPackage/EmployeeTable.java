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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dex
 */
@Entity
@Table(name = "employeeTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTable.findAll", query = "SELECT e FROM EmployeeTable e"),
    @NamedQuery(name = "EmployeeTable.findByPkID", query = "SELECT e FROM EmployeeTable e WHERE e.pkID = :pkID"),
    @NamedQuery(name = "EmployeeTable.findByContactNumber", query = "SELECT e FROM EmployeeTable e WHERE e.contactNumber = :contactNumber"),
    @NamedQuery(name = "EmployeeTable.findBySalary", query = "SELECT e FROM EmployeeTable e WHERE e.salary = :salary")})
public class EmployeeTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ID")
    private Integer pkID;
    @Lob
    @Size(max = 65535)
    @Column(name = "fName")
    private String fName;
    @Lob
    @Size(max = 65535)
    @Column(name = "sName")
    private String sName;
    @Lob
    @Size(max = 65535)
    @Column(name = "addressLine1")
    private String addressLine1;
    @Lob
    @Size(max = 65535)
    @Column(name = "addressLine2")
    private String addressLine2;
    @Lob
    @Size(max = 65535)
    @Column(name = "city")
    private String city;
    @Lob
    @Size(max = 65535)
    @Column(name = "password")
    private String password;
    @Column(name = "contactNumber")
    private Integer contactNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "roleInCompany")
    private String roleInCompany;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;

    public EmployeeTable() {
    }

    public EmployeeTable(Integer pkID) {
        this.pkID = pkID;
    }

    public Integer getPkID() {
        return pkID;
    }

    public void setPkID(Integer pkID) {
        this.pkID = pkID;
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

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRoleInCompany() {
        return roleInCompany;
    }

    public void setRoleInCompany(String roleInCompany) {
        this.roleInCompany = roleInCompany;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkID != null ? pkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTable)) {
            return false;
        }
        EmployeeTable other = (EmployeeTable) object;
        if ((this.pkID == null && other.pkID != null) || (this.pkID != null && !this.pkID.equals(other.pkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.EmployeeTable[ pkID=" + pkID + " ]";
    }
    
}
