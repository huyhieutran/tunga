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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hieu
 */
@Entity
@Table(name = "Food", catalog = "TUNGA", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findByFoodID", query = "SELECT f FROM Food f WHERE f.foodID = :foodID"),
    @NamedQuery(name = "Food.findByName", query = "SELECT f FROM Food f WHERE f.name = :name"),
    @NamedQuery(name = "Food.findByPersonPerUnit", query = "SELECT f FROM Food f WHERE f.personPerUnit = :personPerUnit"),
    @NamedQuery(name = "Food.findByPictureFileName", query = "SELECT f FROM Food f WHERE f.pictureFileName = :pictureFileName"),
    @NamedQuery(name = "Food.findByPrice", query = "SELECT f FROM Food f WHERE f.price = :price"),
    @NamedQuery(name = "Food.findByIsVeg", query = "SELECT f FROM Food f WHERE f.isVeg = :isVeg"),
    @NamedQuery(name = "Food.findByDescription", query = "SELECT f FROM Food f WHERE f.description = :description")})
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FoodID", nullable = false)
    private Integer foodID;
    @Basic(optional = false)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "PersonPerUnit", nullable = false)
    private short personPerUnit;
    @Column(name = "PictureFileName", length = 100)
    private String pictureFileName;
    @Column(name = "Price", precision = 19, scale = 4)
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "IsVeg", nullable = false)
    private boolean isVeg;
    @Column(name = "Description", length = 1073741823)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodID")
    private List<RestaurantMenu> restaurantMenuList;

    public Food() {
    }

    public Food(Integer foodID) {
        this.foodID = foodID;
    }

    public Food(Integer foodID, String name, short personPerUnit, boolean isVeg) {
        this.foodID = foodID;
        this.name = name;
        this.personPerUnit = personPerUnit;
        this.isVeg = isVeg;
    }

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPersonPerUnit() {
        return personPerUnit;
    }

    public void setPersonPerUnit(short personPerUnit) {
        this.personPerUnit = personPerUnit;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(boolean isVeg) {
        this.isVeg = isVeg;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodID != null ? foodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodID == null && other.foodID != null) || (this.foodID != null && !this.foodID.equals(other.foodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tunga.entities.Food[foodID=" + foodID + "]";
    }

}
