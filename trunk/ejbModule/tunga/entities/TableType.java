/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "TableType", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "TableType.findAll", query = "SELECT t FROM TableType t"),
    @NamedQuery(name = "TableType.findByTableTypeID", query = "SELECT t FROM TableType t WHERE t.tableTypeID = :tableTypeID"),
    @NamedQuery(name = "TableType.findBySize", query = "SELECT t FROM TableType t WHERE t.size = :size")})
public class TableType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TableTypeID", nullable = false)
    private Short tableTypeID;
    @Basic(optional = false)
    @Column(name = "Size", nullable = false)
    private short size;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableTypeID")
    private List<RestaurantTable> restaurantTableList;

    public TableType() {
    }

    public TableType(Short tableTypeID) {
        this.tableTypeID = tableTypeID;
    }

    public TableType(Short tableTypeID, short size) {
        this.tableTypeID = tableTypeID;
        this.size = size;
    }

    public Short getTableTypeID() {
        return tableTypeID;
    }

    public void setTableTypeID(Short tableTypeID) {
        this.tableTypeID = tableTypeID;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public List<RestaurantTable> getRestaurantTableList() {
        return restaurantTableList;
    }

    public void setRestaurantTableList(List<RestaurantTable> restaurantTableList) {
        this.restaurantTableList = restaurantTableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableTypeID != null ? tableTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableType)) {
            return false;
        }
        TableType other = (TableType) object;
        if ((this.tableTypeID == null && other.tableTypeID != null) || (this.tableTypeID != null && !this.tableTypeID.equals(other.tableTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.TableType[tableTypeID=" + tableTypeID + "]";
    }

}
