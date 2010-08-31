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
@Table(name = "RestaurantMenu", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "RestaurantMenu.findAll", query = "SELECT r FROM RestaurantMenu r"),
    @NamedQuery(name = "RestaurantMenu.findByResFoodID", query = "SELECT r FROM RestaurantMenu r WHERE r.resFoodID = :resFoodID"),
    @NamedQuery(name = "RestaurantMenu.findByRetailPrice", query = "SELECT r FROM RestaurantMenu r WHERE r.retailPrice = :retailPrice")})
public class RestaurantMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ResFoodID", nullable = false)
    private Integer resFoodID;
    @Column(name = "RetailPrice", precision = 19, scale = 4)
    private BigDecimal retailPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantMenu")
    private List<OrderFoodDetail> orderFoodDetailList;
    @JoinColumn(name = "FoodID", referencedColumnName = "FoodID", nullable = false)
    @ManyToOne(optional = false)
    private Food foodID;
    @JoinColumn(name = "MenuID", referencedColumnName = "MenuID", nullable = false)
    @ManyToOne(optional = false)
    private Menu menuID;
    @JoinColumn(name = "ResID", referencedColumnName = "ResID", nullable = false)
    @ManyToOne(optional = false)
    private Restaurant resID;

    public RestaurantMenu() {
    }

    public RestaurantMenu(Integer resFoodID) {
        this.resFoodID = resFoodID;
    }

    public Integer getResFoodID() {
        return resFoodID;
    }

    public void setResFoodID(Integer resFoodID) {
        this.resFoodID = resFoodID;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public List<OrderFoodDetail> getOrderFoodDetailList() {
        return orderFoodDetailList;
    }

    public void setOrderFoodDetailList(List<OrderFoodDetail> orderFoodDetailList) {
        this.orderFoodDetailList = orderFoodDetailList;
    }

    public Food getFoodID() {
        return foodID;
    }

    public void setFoodID(Food foodID) {
        this.foodID = foodID;
    }

    public Menu getMenuID() {
        return menuID;
    }

    public void setMenuID(Menu menuID) {
        this.menuID = menuID;
    }

    public Restaurant getResID() {
        return resID;
    }

    public void setResID(Restaurant resID) {
        this.resID = resID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resFoodID != null ? resFoodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantMenu)) {
            return false;
        }
        RestaurantMenu other = (RestaurantMenu) object;
        if ((this.resFoodID == null && other.resFoodID != null) || (this.resFoodID != null && !this.resFoodID.equals(other.resFoodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.RestaurantMenu[resFoodID=" + resFoodID + "]";
    }

}
