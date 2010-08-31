/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "RoomType", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RoomType.findAll", query = "SELECT r FROM RoomType r"),
    @NamedQuery(name = "RoomType.findByRoomTypeID", query = "SELECT r FROM RoomType r WHERE r.roomTypeID = :roomTypeID"),
    @NamedQuery(name = "RoomType.findByName", query = "SELECT r FROM RoomType r WHERE r.name = :name")})
public class RoomType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RoomTypeID", nullable = false)
    private Short roomTypeID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @OneToMany(mappedBy = "roomTypeID")
    private List<Room> roomList;

    public RoomType() {
    }

    public RoomType(Short roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public RoomType(Short roomTypeID, String name) {
        this.roomTypeID = roomTypeID;
        this.name = name;
    }

    public Short getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(Short roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomTypeID != null ? roomTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomType)) {
            return false;
        }
        RoomType other = (RoomType) object;
        if ((this.roomTypeID == null && other.roomTypeID != null) || (this.roomTypeID != null && !this.roomTypeID.equals(other.roomTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.RoomType[roomTypeID=" + roomTypeID + "]";
    }

}
