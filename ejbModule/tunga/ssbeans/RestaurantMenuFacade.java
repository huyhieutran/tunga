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
import tunga.entities.RestaurantMenu;

/**
 *
 * @author Hieu
 */
@Stateless
public class RestaurantMenuFacade implements RestaurantMenuFacadeLocal, RestaurantMenuFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(RestaurantMenu restaurantMenu) {
        em.persist(restaurantMenu);
    }

    public void edit(RestaurantMenu restaurantMenu) {
        em.merge(restaurantMenu);
    }

    public void remove(RestaurantMenu restaurantMenu) {
        em.remove(em.merge(restaurantMenu));
    }

    public RestaurantMenu find(Object id) {
        return em.find(RestaurantMenu.class, id);
    }

    public List<RestaurantMenu> findAll() {
        return em.createQuery("select object(o) from RestaurantMenu as o").getResultList();
    }

    public List<RestaurantMenu> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from RestaurantMenu as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from RestaurantMenu as o").getSingleResult()).intValue();
    }

}
