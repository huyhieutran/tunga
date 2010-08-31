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
@Table(name = "Room", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomID", query = "SELECT r FROM Room r WHERE r.roomID = :roomID"),
    @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name"),
    @NamedQuery(name = "Room.findByPictureFileName", query = "SELECT r FROM Room r WHERE r.pictureFileName = :pictureFileName")})
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RoomID", nullable = false, length = 10)
    private String roomID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "PictureFileName", length = 100)
    private String pictureFileName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomID")
    private List<RestaurantTable> restaurantTableList;
    @JoinColumn(name = "ResID", referencedColumnName = "ResID", nullable = false)
    @ManyToOne(optional = false)
    private Restaurant resID;
    @JoinColumn(name = "RoomTypeID", referencedColumnName = "RoomTypeID")
    @ManyToOne
    private RoomType roomTypeID;

    public Room() {
    }

    public Room(String roomID) {
        this.roomID = roomID;
    }

    public Room(String roomID, String name) {
        this.roomID = roomID;
        this.name = name;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public List<RestaurantTable> getRestaurantTableList() {
        return restaurantTableList;
    }

    public void setRestaurantTableList(List<RestaurantTable> restaurantTableList) {
        this.restaurantTableList = restaurantTableList;
    }

    public Restaurant getResID() {
        return resID;
    }

    public void setResID(Restaurant resID) {
        this.resID = resID;
    }

    public RoomType getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(RoomType roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomID != null ? roomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Room[roomID=" + roomID + "]";
    }

}
