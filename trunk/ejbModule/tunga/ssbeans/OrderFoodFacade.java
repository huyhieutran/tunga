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
import tunga.entities.OrderFood;

/**
 *
 * @author Hieu
 */
@Stateless
public class OrderFoodFacade implements OrderFoodFacadeLocal, OrderFoodFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(OrderFood orderFood) {
        em.persist(orderFood);
    }

    public void edit(OrderFood orderFood) {
        em.merge(orderFood);
    }

    public void remove(OrderFood orderFood) {
        em.remove(em.merge(orderFood));
    }

    public OrderFood find(Object id) {
        return em.find(OrderFood.class, id);
    }

    public List<OrderFood> findAll() {
        return em.createQuery("select object(o) from OrderFood as o").getResultList();
    }

    public List<OrderFood> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from OrderFood as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from OrderFood as o").getSingleResult()).intValue();
    }

}
