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
@Table(name = "employeePurchaseTable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeePurchaseTable.findAll", query = "SELECT e FROM EmployeePurchaseTable e"),
    @NamedQuery(name = "EmployeePurchaseTable.findByPuID", query = "SELECT e FROM EmployeePurchaseTable e WHERE e.puID = :puID"),
    @NamedQuery(name = "EmployeePurchaseTable.findByDate", query = "SELECT e FROM EmployeePurchaseTable e WHERE e.date = :date"),
    @NamedQuery(name = "EmployeePurchaseTable.findByTotalRemoved", query = "SELECT e FROM EmployeePurchaseTable e WHERE e.totalRemoved = :totalRemoved")})
public class EmployeePurchaseTable implements Serializable {
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
    private Collection<EmployeeReceiptTable> employeeReceiptTableCollection;
    @JoinColumn(name = "employeeID", referencedColumnName = "pk_ID")
    @ManyToOne
    private Employee employeeID;

    public EmployeePurchaseTable() {
    }

    public EmployeePurchaseTable(Integer puID) {
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
    public Collection<EmployeeReceiptTable> getEmployeeReceiptTableCollection() {
        return employeeReceiptTableCollection;
    }

    public void setEmployeeReceiptTableCollection(Collection<EmployeeReceiptTable> employeeReceiptTableCollection) {
        this.employeeReceiptTableCollection = employeeReceiptTableCollection;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
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
        if (!(object instanceof EmployeePurchaseTable)) {
            return false;
        }
        EmployeePurchaseTable other = (EmployeePurchaseTable) object;
        if ((this.puID == null && other.puID != null) || (this.puID != null && !this.puID.equals(other.puID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.EmployeePurchaseTable[ puID=" + puID + " ]";
    }
    
}
