/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "OrderFood", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "OrderFood.findAll", query = "SELECT o FROM OrderFood o"),
    @NamedQuery(name = "OrderFood.findByOrderID", query = "SELECT o FROM OrderFood o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderFood.findByOrderDate", query = "SELECT o FROM OrderFood o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "OrderFood.findByTax", query = "SELECT o FROM OrderFood o WHERE o.tax = :tax"),
    @NamedQuery(name = "OrderFood.findByFreight", query = "SELECT o FROM OrderFood o WHERE o.freight = :freight"),
    @NamedQuery(name = "OrderFood.findBySubPrice", query = "SELECT o FROM OrderFood o WHERE o.subPrice = :subPrice"),
    @NamedQuery(name = "OrderFood.findByTotalPrice", query = "SELECT o FROM OrderFood o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "OrderFood.findByDeliveryToAddress", query = "SELECT o FROM OrderFood o WHERE o.deliveryToAddress = :deliveryToAddress"),
    @NamedQuery(name = "OrderFood.findByStatus", query = "SELECT o FROM OrderFood o WHERE o.status = :status"),
    @NamedQuery(name = "OrderFood.findByGuestTitle", query = "SELECT o FROM OrderFood o WHERE o.guestTitle = :guestTitle"),
    @NamedQuery(name = "OrderFood.findByGuestFirstName", query = "SELECT o FROM OrderFood o WHERE o.guestFirstName = :guestFirstName"),
    @NamedQuery(name = "OrderFood.findByGuestLastName", query = "SELECT o FROM OrderFood o WHERE o.guestLastName = :guestLastName"),
    @NamedQuery(name = "OrderFood.findByGuestAddress", query = "SELECT o FROM OrderFood o WHERE o.guestAddress = :guestAddress"),
    @NamedQuery(name = "OrderFood.findByGuestPhone", query = "SELECT o FROM OrderFood o WHERE o.guestPhone = :guestPhone"),
    @NamedQuery(name = "OrderFood.findByGuestMobilePhone", query = "SELECT o FROM OrderFood o WHERE o.guestMobilePhone = :guestMobilePhone"),
    @NamedQuery(name = "OrderFood.findByGuestEmail", query = "SELECT o FROM OrderFood o WHERE o.guestEmail = :guestEmail"),
    @NamedQuery(name = "OrderFood.findByComment", query = "SELECT o FROM OrderFood o WHERE o.comment = :comment")})
public class OrderFood implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OrderID", nullable = false)
    private Integer orderID;
    @Basic(optional = false)
    @Column(name = "OrderDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "Tax", nullable = false, precision = 19, scale = 4)
    private BigDecimal tax;
    @Basic(optional = false)
    @Column(name = "Freight", nullable = false, precision = 19, scale = 4)
    private BigDecimal freight;
    @Basic(optional = false)
    @Column(name = "SubPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal subPrice;
    @Basic(optional = false)
    @Column(name = "TotalPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal totalPrice;
    @Basic(optional = false)
    @Column(name = "DeliveryToAddress", nullable = false, length = 200)
    private String deliveryToAddress;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderFood")
    private List<OrderFoodDetail> orderFoodDetailList;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne
    private User username;

    public OrderFood() {
    }

    public OrderFood(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderFood(Integer orderID, Date orderDate, BigDecimal tax, BigDecimal freight, BigDecimal subPrice, BigDecimal totalPrice, String deliveryToAddress, short status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.tax = tax;
        this.freight = freight;
        this.subPrice = subPrice;
        this.totalPrice = totalPrice;
        this.deliveryToAddress = deliveryToAddress;
        this.status = status;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(BigDecimal subPrice) {
        this.subPrice = subPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryToAddress() {
        return deliveryToAddress;
    }

    public void setDeliveryToAddress(String deliveryToAddress) {
        this.deliveryToAddress = deliveryToAddress;
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

    public List<OrderFoodDetail> getOrderFoodDetailList() {
        return orderFoodDetailList;
    }

    public void setOrderFoodDetailList(List<OrderFoodDetail> orderFoodDetailList) {
        this.orderFoodDetailList = orderFoodDetailList;
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
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderFood)) {
            return false;
        }
        OrderFood other = (OrderFood) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.OrderFood[orderID=" + orderID + "]";
    }

}
