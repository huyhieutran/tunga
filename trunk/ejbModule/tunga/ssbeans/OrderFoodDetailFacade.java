/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tunga.entities.OrderFoodDetail;

/**
 *
 * @author Hieu
 */
@Stateless
public class OrderFoodDetailFacade implements OrderFoodDetailFacadeLocal, OrderFoodDetailFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(OrderFoodDetail orderFoodDetail) {
        em.persist(orderFoodDetail);
    }

    public void edit(OrderFoodDetail orderFoodDetail) {
        em.merge(orderFoodDetail);
    }

    public void remove(OrderFoodDetail orderFoodDetail) {
        em.remove(em.merge(orderFoodDetail));
    }

    public OrderFoodDetail find(Object id) {
        return em.find(OrderFoodDetail.class, id);
    }

    public List<OrderFoodDetail> findAll() {
        return em.createQuery("select object(o) from OrderFoodDetail as o").getResultList();
    }

    public List<OrderFoodDetail> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from OrderFoodDetail as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from OrderFoodDetail as o").getSingleResult()).intValue();
    }

}
