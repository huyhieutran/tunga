/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.RestaurantMenu;

/**
 *
 * @author Hieu
 */
@Remote
public interface RestaurantMenuFacadeRemote {

    void create(RestaurantMenu restaurantMenu);

    void edit(RestaurantMenu restaurantMenu);

    void remove(RestaurantMenu restaurantMenu);

    RestaurantMenu find(Object id);

    List<RestaurantMenu> findAll();

    List<RestaurantMenu> findRange(int[] range);

    int count();

}
