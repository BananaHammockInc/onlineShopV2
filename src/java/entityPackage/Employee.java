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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByPkID", query = "SELECT e FROM Employee e WHERE e.pkID = :pkID"),
    @NamedQuery(name = "Employee.findByFName", query = "SELECT e FROM Employee e WHERE e.fName = :fName"),
    @NamedQuery(name = "Employee.findBySName", query = "SELECT e FROM Employee e WHERE e.sName = :sName"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByAddressLine1", query = "SELECT e FROM Employee e WHERE e.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Employee.findByAddressLine2", query = "SELECT e FROM Employee e WHERE e.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Employee.findByCity", query = "SELECT e FROM Employee e WHERE e.city = :city"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByContactNumber", query = "SELECT e FROM Employee e WHERE e.contactNumber = :contactNumber"),
    @NamedQuery(name = "Employee.findByRoleInCompany", query = "SELECT e FROM Employee e WHERE e.roleInCompany = :roleInCompany"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")})
public class Employee implements Serializable {
    @OneToMany(mappedBy = "employeeID")
    private Collection<EmployeePurchaseTable> employeePurchaseTableCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ID")
    private Integer pkID;
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
    @Column(name = "contactNumber")
    private Integer contactNumber;
    @Size(max = 255)
    @Column(name = "roleInCompany")
    private String roleInCompany;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;

    public Employee() {
    }

    public Employee(Integer pkID) {
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.pkID == null && other.pkID != null) || (this.pkID != null && !this.pkID.equals(other.pkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Employee[ pkID=" + pkID + " ]";
    }

    @XmlTransient
    public Collection<EmployeePurchaseTable> getEmployeePurchaseTableCollection() {
        return employeePurchaseTableCollection;
    }

    public void setEmployeePurchaseTableCollection(Collection<EmployeePurchaseTable> employeePurchaseTableCollection) {
        this.employeePurchaseTableCollection = employeePurchaseTableCollection;
    }
    
}
