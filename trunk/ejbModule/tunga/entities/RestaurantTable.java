/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "RestaurantTable", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RestaurantTable.findAll", query = "SELECT r FROM RestaurantTable r"),
    @NamedQuery(name = "RestaurantTable.findByTableID", query = "SELECT r FROM RestaurantTable r WHERE r.tableID = :tableID"),
    @NamedQuery(name = "RestaurantTable.findByStatus", query = "SELECT r FROM RestaurantTable r WHERE r.status = :status"),
    @NamedQuery(name = "RestaurantTable.findByRetailPrice", query = "SELECT r FROM RestaurantTable r WHERE r.retailPrice = :retailPrice")})
public class RestaurantTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TableID", nullable = false, length = 10)
    private String tableID;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private boolean status;
    @Column(name = "RetailPrice", precision = 19, scale = 4)
    private BigDecimal retailPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantTable")
    private List<ReservationDetail> reservationDetailList;
    @JoinColumn(name = "RoomID", referencedColumnName = "RoomID", nullable = false)
    @ManyToOne(optional = false)
    private Room roomID;
    @JoinColumn(name = "TableTypeID", referencedColumnName = "TableTypeID", nullable = false)
    @ManyToOne(optional = false)
    private TableType tableTypeID;

    public RestaurantTable() {
    }

    public RestaurantTable(String tableID) {
        this.tableID = tableID;
    }

    public RestaurantTable(String tableID, boolean status) {
        this.tableID = tableID;
        this.status = status;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public List<ReservationDetail> getReservationDetailList() {
        return reservationDetailList;
    }

    public void setReservationDetailList(List<ReservationDetail> reservationDetailList) {
        this.reservationDetailList = reservationDetailList;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public TableType getTableTypeID() {
        return tableTypeID;
    }

    public void setTableTypeID(TableType tableTypeID) {
        this.tableTypeID = tableTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableID != null ? tableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantTable)) {
            return false;
        }
        RestaurantTable other = (RestaurantTable) object;
        if ((this.tableID == null && other.tableID != null) || (this.tableID != null && !this.tableID.equals(other.tableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.RestaurantTable[tableID=" + tableID + "]";
    }

}
