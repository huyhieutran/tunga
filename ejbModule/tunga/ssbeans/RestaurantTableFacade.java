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
import tunga.entities.RestaurantTable;

/**
 *
 * @author Hieu
 */
@Stateless
public class RestaurantTableFacade implements RestaurantTableFacadeLocal, RestaurantTableFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(RestaurantTable restaurantTable) {
        em.persist(restaurantTable);
    }

    public void edit(RestaurantTable restaurantTable) {
        em.merge(restaurantTable);
    }

    public void remove(RestaurantTable restaurantTable) {
        em.remove(em.merge(restaurantTable));
    }

    public RestaurantTable find(Object id) {
        return em.find(RestaurantTable.class, id);
    }

    public List<RestaurantTable> findAll() {
        return em.createQuery("select object(o) from RestaurantTable as o").getResultList();
    }

    public List<RestaurantTable> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from RestaurantTable as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from RestaurantTable as o").getSingleResult()).intValue();
    }

}
