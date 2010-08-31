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
@Table(name = "Restaurant", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByResID", query = "SELECT r FROM Restaurant r WHERE r.resID = :resID"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name"),
    @NamedQuery(name = "Restaurant.findByPictureFileName", query = "SELECT r FROM Restaurant r WHERE r.pictureFileName = :pictureFileName"),
    @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address"),
    @NamedQuery(name = "Restaurant.findByPhone1", query = "SELECT r FROM Restaurant r WHERE r.phone1 = :phone1"),
    @NamedQuery(name = "Restaurant.findByPhone2", query = "SELECT r FROM Restaurant r WHERE r.phone2 = :phone2"),
    @NamedQuery(name = "Restaurant.findByEmail", query = "SELECT r FROM Restaurant r WHERE r.email = :email"),
    @NamedQuery(name = "Restaurant.findByWebsite", query = "SELECT r FROM Restaurant r WHERE r.website = :website"),
    @NamedQuery(name = "Restaurant.findByParkingInfo", query = "SELECT r FROM Restaurant r WHERE r.parkingInfo = :parkingInfo"),
    @NamedQuery(name = "Restaurant.findByDescription", query = "SELECT r FROM Restaurant r WHERE r.description = :description")})
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ResID", nullable = false)
    private Integer resID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @Column(name = "PictureFileName", length = 100)
    private String pictureFileName;
    @Basic(optional = false)
    @Column(name = "Address", nullable = false, length = 150)
    private String address;
    @Basic(optional = false)
    @Column(name = "Phone1", nullable = false, length = 15)
    private String phone1;
    @Column(name = "Phone2", length = 15)
    private String phone2;
    @Column(name = "Email", length = 255)
    private String email;
    @Column(name = "Website", length = 255)
    private String website;
    @Column(name = "ParkingInfo", length = 250)
    private String parkingInfo;
    @Column(name = "Description", length = 1073741823)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resID")
    private List<RestaurantMenu> restaurantMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resID")
    private List<Room> roomList;
    @JoinColumn(name = "LocID", referencedColumnName = "LocID", nullable = false)
    @ManyToOne(optional = false)
    private Location locID;

    public Restaurant() {
    }

    public Restaurant(Integer resID) {
        this.resID = resID;
    }

    public Restaurant(Integer resID, String name, String address, String phone1) {
        this.resID = resID;
        this.name = name;
        this.address = address;
        this.phone1 = phone1;
    }

    public Integer getResID() {
        return resID;
    }

    public void setResID(Integer resID) {
        this.resID = resID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RestaurantMenu> getRestaurantMenuList() {
        return restaurantMenuList;
    }

    public void setRestaurantMenuList(List<RestaurantMenu> restaurantMenuList) {
        this.restaurantMenuList = restaurantMenuList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Location getLocID() {
        return locID;
    }

    public void setLocID(Location locID) {
        this.locID = locID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resID != null ? resID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.resID == null && other.resID != null) || (this.resID != null && !this.resID.equals(other.resID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Restaurant[resID=" + resID + "]";
    }

}
