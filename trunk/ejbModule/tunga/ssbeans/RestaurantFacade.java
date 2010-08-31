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
import tunga.entities.Restaurant;

/**
 *
 * @author Hieu
 */
@Stateless
public class RestaurantFacade implements RestaurantFacadeLocal, RestaurantFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Restaurant restaurant) {
        em.persist(restaurant);
    }

    public void edit(Restaurant restaurant) {
        em.merge(restaurant);
    }

    public void remove(Restaurant restaurant) {
        em.remove(em.merge(restaurant));
    }

    public Restaurant find(Object id) {
        return em.find(Restaurant.class, id);
    }

    public List<Restaurant> findAll() {
        return em.createQuery("select object(o) from Restaurant as o").getResultList();
    }

    public List<Restaurant> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Restaurant as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Restaurant as o").getSingleResult()).intValue();
    }

}
