/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hieu
 */
@Embeddable
public class ReservationDetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ReservationID", nullable = false)
    private int reservationID;
    @Basic(optional = false)
    @Column(name = "TableID", nullable = false, length = 10)
    private String tableID;

    public ReservationDetailPK() {
    }

    public ReservationDetailPK(int reservationID, String tableID) {
        this.reservationID = reservationID;
        this.tableID = tableID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reservationID;
        hash += (tableID != null ? tableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationDetailPK)) {
            return false;
        }
        ReservationDetailPK other = (ReservationDetailPK) object;
        if (this.reservationID != other.reservationID) {
            return false;
        }
        if ((this.tableID == null && other.tableID != null) || (this.tableID != null && !this.tableID.equals(other.tableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.ReservationDetailPK[reservationID=" + reservationID + ", tableID=" + tableID + "]";
    }

}
