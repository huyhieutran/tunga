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
@Table(name = "Menu", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuID", query = "SELECT m FROM Menu m WHERE m.menuID = :menuID"),
    @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.name = :name")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MenuID", nullable = false)
    private Integer menuID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuID")
    private List<RestaurantMenu> restaurantMenuList;

    public Menu() {
    }

    public Menu(Integer menuID) {
        this.menuID = menuID;
    }

    public Menu(Integer menuID, String name) {
        this.menuID = menuID;
        this.name = name;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RestaurantMenu> getRestaurantMenuList() {
        return restaurantMenuList;
    }

    public void setRestaurantMenuList(List<RestaurantMenu> restaurantMenuList) {
        this.restaurantMenuList = restaurantMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuID != null ? menuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuID == null && other.menuID != null) || (this.menuID != null && !this.menuID.equals(other.menuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Menu[menuID=" + menuID + "]";
    }

}
