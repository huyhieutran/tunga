/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "ReservationDetail", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "ReservationDetail.findAll", query = "SELECT r FROM ReservationDetail r"),
    @NamedQuery(name = "ReservationDetail.findByReservationID", query = "SELECT r FROM ReservationDetail r WHERE r.reservationDetailPK.reservationID = :reservationID"),
    @NamedQuery(name = "ReservationDetail.findByTableID", query = "SELECT r FROM ReservationDetail r WHERE r.reservationDetailPK.tableID = :tableID"),
    @NamedQuery(name = "ReservationDetail.findByQuantity", query = "SELECT r FROM ReservationDetail r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "ReservationDetail.findByDiscount", query = "SELECT r FROM ReservationDetail r WHERE r.discount = :discount")})
public class ReservationDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationDetailPK reservationDetailPK;
    @Basic(optional = false)
    @Column(name = "Quantity", nullable = false)
    private short quantity;
    @Column(name = "Discount", precision = 19, scale = 4)
    private BigDecimal discount;
    @JoinColumn(name = "ReservationID", referencedColumnName = "ReservationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservation reservation;
    @JoinColumn(name = "TableID", referencedColumnName = "TableID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RestaurantTable restaurantTable;

    public ReservationDetail() {
    }

    public ReservationDetail(ReservationDetailPK reservationDetailPK) {
        this.reservationDetailPK = reservationDetailPK;
    }

    public ReservationDetail(ReservationDetailPK reservationDetailPK, short quantity) {
        this.reservationDetailPK = reservationDetailPK;
        this.quantity = quantity;
    }

    public ReservationDetail(int reservationID, String tableID) {
        this.reservationDetailPK = new ReservationDetailPK(reservationID, tableID);
    }

    public ReservationDetailPK getReservationDetailPK() {
        return reservationDetailPK;
    }

    public void setReservationDetailPK(ReservationDetailPK reservationDetailPK) {
        this.reservationDetailPK = reservationDetailPK;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationDetailPK != null ? reservationDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationDetail)) {
            return false;
        }
        ReservationDetail other = (ReservationDetail) object;
        if ((this.reservationDetailPK == null && other.reservationDetailPK != null) || (this.reservationDetailPK != null && !this.reservationDetailPK.equals(other.reservationDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.ReservationDetail[reservationDetailPK=" + reservationDetailPK + "]";
    }

}
