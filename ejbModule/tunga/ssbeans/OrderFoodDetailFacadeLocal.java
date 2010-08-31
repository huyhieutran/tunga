/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Local;
import tunga.entities.OrderFoodDetail;

/**
 *
 * @author Hieu
 */
@Local
public interface OrderFoodDetailFacadeLocal {

    void create(OrderFoodDetail orderFoodDetail);

    void edit(OrderFoodDetail orderFoodDetail);

    void remove(OrderFoodDetail orderFoodDetail);

    OrderFoodDetail find(Object id);

    List<OrderFoodDetail> findAll();

    List<OrderFoodDetail> findRange(int[] range);

    int count();

}
