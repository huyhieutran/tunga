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
@Table(name = "OrderFoodDetail", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "OrderFoodDetail.findAll", query = "SELECT o FROM OrderFoodDetail o"),
    @NamedQuery(name = "OrderFoodDetail.findByOrderID", query = "SELECT o FROM OrderFoodDetail o WHERE o.orderFoodDetailPK.orderID = :orderID"),
    @NamedQuery(name = "OrderFoodDetail.findByResFoodID", query = "SELECT o FROM OrderFoodDetail o WHERE o.orderFoodDetailPK.resFoodID = :resFoodID"),
    @NamedQuery(name = "OrderFoodDetail.findByQuantity", query = "SELECT o FROM OrderFoodDetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderFoodDetail.findByDiscount", query = "SELECT o FROM OrderFoodDetail o WHERE o.discount = :discount")})
public class OrderFoodDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderFoodDetailPK orderFoodDetailPK;
    @Basic(optional = false)
    @Column(name = "Quantity", nullable = false)
    private short quantity;
    @Column(name = "Discount", precision = 19, scale = 4)
    private BigDecimal discount;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderFood orderFood;
    @JoinColumn(name = "ResFoodID", referencedColumnName = "ResFoodID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RestaurantMenu restaurantMenu;

    public OrderFoodDetail() {
    }

    public OrderFoodDetail(OrderFoodDetailPK orderFoodDetailPK) {
        this.orderFoodDetailPK = orderFoodDetailPK;
    }

    public OrderFoodDetail(OrderFoodDetailPK orderFoodDetailPK, short quantity) {
        this.orderFoodDetailPK = orderFoodDetailPK;
        this.quantity = quantity;
    }

    public OrderFoodDetail(int orderID, int resFoodID) {
        this.orderFoodDetailPK = new OrderFoodDetailPK(orderID, resFoodID);
    }

    public OrderFoodDetailPK getOrderFoodDetailPK() {
        return orderFoodDetailPK;
    }

    public void setOrderFoodDetailPK(OrderFoodDetailPK orderFoodDetailPK) {
        this.orderFoodDetailPK = orderFoodDetailPK;
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

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(OrderFood orderFood) {
        this.orderFood = orderFood;
    }

    public RestaurantMenu getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(RestaurantMenu restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderFoodDetailPK != null ? orderFoodDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderFoodDetail)) {
            return false;
        }
        OrderFoodDetail other = (OrderFoodDetail) object;
        if ((this.orderFoodDetailPK == null && other.orderFoodDetailPK != null) || (this.orderFoodDetailPK != null && !this.orderFoodDetailPK.equals(other.orderFoodDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.OrderFoodDetail[orderFoodDetailPK=" + orderFoodDetailPK + "]";
    }

}
