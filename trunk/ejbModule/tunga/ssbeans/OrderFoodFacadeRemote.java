/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.OrderFood;

/**
 *
 * @author Hieu
 */
@Remote
public interface OrderFoodFacadeRemote {

    void create(OrderFood orderFood);

    void edit(OrderFood orderFood);

    void remove(OrderFood orderFood);

    OrderFood find(Object id);

    List<OrderFood> findAll();

    List<OrderFood> findRange(int[] range);

    int count();

}
