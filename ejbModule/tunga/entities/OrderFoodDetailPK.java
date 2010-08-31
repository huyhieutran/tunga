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
public class OrderFoodDetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "OrderID", nullable = false)
    private int orderID;
    @Basic(optional = false)
    @Column(name = "ResFoodID", nullable = false)
    private int resFoodID;

    public OrderFoodDetailPK() {
    }

    public OrderFoodDetailPK(int orderID, int resFoodID) {
        this.orderID = orderID;
        this.resFoodID = resFoodID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getResFoodID() {
        return resFoodID;
    }

    public void setResFoodID(int resFoodID) {
        this.resFoodID = resFoodID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderID;
        hash += (int) resFoodID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderFoodDetailPK)) {
            return false;
        }
        OrderFoodDetailPK other = (OrderFoodDetailPK) object;
        if (this.orderID != other.orderID) {
            return false;
        }
        if (this.resFoodID != other.resFoodID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.OrderFoodDetailPK[orderID=" + orderID + ", resFoodID=" + resFoodID + "]";
    }

}
