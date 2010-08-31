/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.OrderFoodDetail;

/**
 *
 * @author Hieu
 */
@Remote
public interface OrderFoodDetailFacadeRemote {

    void create(OrderFoodDetail orderFoodDetail);

    void edit(OrderFoodDetail orderFoodDetail);

    void remove(OrderFoodDetail orderFoodDetail);

    OrderFoodDetail find(Object id);

    List<OrderFoodDetail> findAll();

    List<OrderFoodDetail> findRange(int[] range);

    int count();

}
