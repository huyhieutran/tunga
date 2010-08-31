/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Local;
import tunga.entities.RestaurantTable;

/**
 *
 * @author Hieu
 */
@Local
public interface RestaurantTableFacadeLocal {

    void create(RestaurantTable restaurantTable);

    void edit(RestaurantTable restaurantTable);

    void remove(RestaurantTable restaurantTable);

    RestaurantTable find(Object id);

    List<RestaurantTable> findAll();

    List<RestaurantTable> findRange(int[] range);

    int count();

}
