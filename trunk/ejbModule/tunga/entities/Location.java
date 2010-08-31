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
@Table(name = "Location", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocID", query = "SELECT l FROM Location l WHERE l.locID = :locID"),
    @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LocID", nullable = false)
    private Integer locID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "parentLocID")
    private List<Location> locationList;
    @JoinColumn(name = "ParentLocID", referencedColumnName = "LocID")
    @ManyToOne
    private Location parentLocID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locID")
    private List<Restaurant> restaurantList;

    public Location() {
    }

    public Location(Integer locID) {
        this.locID = locID;
    }

    public Location(Integer locID, String name) {
        this.locID = locID;
        this.name = name;
    }

    public Integer getLocID() {
        return locID;
    }

    public void setLocID(Integer locID) {
        this.locID = locID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public Location getParentLocID() {
        return parentLocID;
    }

    public void setParentLocID(Location parentLocID) {
        this.parentLocID = parentLocID;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locID != null ? locID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locID == null && other.locID != null) || (this.locID != null && !this.locID.equals(other.locID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Location[locID=" + locID + "]";
    }

}
