/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "Reservation", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByReservationID", query = "SELECT r FROM Reservation r WHERE r.reservationID = :reservationID"),
    @NamedQuery(name = "Reservation.findByReserveDate", query = "SELECT r FROM Reservation r WHERE r.reserveDate = :reserveDate"),
    @NamedQuery(name = "Reservation.findByStatus", query = "SELECT r FROM Reservation r WHERE r.status = :status"),
    @NamedQuery(name = "Reservation.findByGuestTitle", query = "SELECT r FROM Reservation r WHERE r.guestTitle = :guestTitle"),
    @NamedQuery(name = "Reservation.findByGuestFirstName", query = "SELECT r FROM Reservation r WHERE r.guestFirstName = :guestFirstName"),
    @NamedQuery(name = "Reservation.findByGuestLastName", query = "SELECT r FROM Reservation r WHERE r.guestLastName = :guestLastName"),
    @NamedQuery(name = "Reservation.findByGuestAddress", query = "SELECT r FROM Reservation r WHERE r.guestAddress = :guestAddress"),
    @NamedQuery(name = "Reservation.findByGuestPhone", query = "SELECT r FROM Reservation r WHERE r.guestPhone = :guestPhone"),
    @NamedQuery(name = "Reservation.findByGuestMobilePhone", query = "SELECT r FROM Reservation r WHERE r.guestMobilePhone = :guestMobilePhone"),
    @NamedQuery(name = "Reservation.findByGuestEmail", query = "SELECT r FROM Reservation r WHERE r.guestEmail = :guestEmail"),
    @NamedQuery(name = "Reservation.findByComment", query = "SELECT r FROM Reservation r WHERE r.comment = :comment")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ReservationID", nullable = false)
    private Integer reservationID;
    @Basic(optional = false)
    @Column(name = "ReserveDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reserveDate;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false)
    private short status;
    @Column(name = "GuestTitle", length = 10)
    private String guestTitle;
    @Column(name = "GuestFirstName", length = 50)
    private String guestFirstName;
    @Column(name = "GuestLastName", length = 50)
    private String guestLastName;
    @Column(name = "GuestAddress", length = 200)
    private String guestAddress;
    @Column(name = "GuestPhone", length = 15)
    private String guestPhone;
    @Column(name = "GuestMobilePhone", length = 15)
    private String guestMobilePhone;
    @Column(name = "GuestEmail", length = 255)
    private String guestEmail;
    @Column(name = "Comment", length = 200)
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    private List<ReservationDetail> reservationDetailList;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne
    private User username;

    public Reservation() {
    }

    public Reservation(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Reservation(Integer reservationID, Date reserveDate, short status) {
        this.reservationID = reservationID;
        this.reserveDate = reserveDate;
        this.status = status;
    }

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getGuestTitle() {
        return guestTitle;
    }

    public void setGuestTitle(String guestTitle) {
        this.guestTitle = guestTitle;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getGuestMobilePhone() {
        return guestMobilePhone;
    }

    public void setGuestMobilePhone(String guestMobilePhone) {
        this.guestMobilePhone = guestMobilePhone;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ReservationDetail> getReservationDetailList() {
        return reservationDetailList;
    }

    public void setReservationDetailList(List<ReservationDetail> reservationDetailList) {
        this.reservationDetailList = reservationDetailList;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationID != null ? reservationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationID == null && other.reservationID != null) || (this.reservationID != null && !this.reservationID.equals(other.reservationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Reservation[reservationID=" + reservationID + "]";
    }

}
